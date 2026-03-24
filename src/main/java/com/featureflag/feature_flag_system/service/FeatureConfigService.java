package com.featureflag.feature_flag_system.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import com.featureflag.feature_flag_system.model.FeatureConfig;
import com.featureflag.feature_flag_system.model.FeatureFlag;
import com.featureflag.feature_flag_system.model.Environment;
import com.featureflag.feature_flag_system.dto.EvaluationResponseDTO;
import com.featureflag.feature_flag_system.dto.FeatureConfigDTO;
import com.featureflag.feature_flag_system.model.AuditLog;
import com.featureflag.feature_flag_system.repository.AuditLogRepository;
import com.featureflag.feature_flag_system.repository.EnvironmentRepository;
import com.featureflag.feature_flag_system.repository.FeatureConfigRepository;
import com.featureflag.feature_flag_system.repository.FeatureFlagRepository;
import com.featureflag.feature_flag_system.exception.*;
import java.time.LocalDateTime;

@Service
public class FeatureConfigService {

	private final FeatureConfigRepository configRepo;
	private final FeatureFlagRepository featureRepo;
	private final EnvironmentRepository envRepo;
	private final AuditLogRepository auditRepo;
	private final FeatureCacheService cacheService;

	public FeatureConfigService(FeatureConfigRepository configRepo,
			FeatureFlagRepository featureRepo,
			EnvironmentRepository envRepo,
			AuditLogRepository auditRepo,
			FeatureCacheService cacheService) {
		this.configRepo = configRepo;
		this.featureRepo = featureRepo;
		this.envRepo = envRepo;
		this.auditRepo = auditRepo;
		this.cacheService = cacheService;
	}

	// CACHE INVALIDATION when config changes
	@CacheEvict(value = "featureConfigCache", allEntries = true)
	public FeatureConfig createOrUpdateConfig(String featureId, String envId,
	                                          boolean enabled, int rollout) {

	    FeatureFlag feature = featureRepo.findById(featureId)
	            .orElseThrow(() -> new FeatureNotFoundException("Feature not found"));

	    Environment env = envRepo.findById(envId)
	            .orElseThrow(() -> new EnvironmentNotFoundException("Environment not found"));

	    FeatureConfig config = configRepo
	            .findByFeatureIdAndEnvironmentId(featureId, envId)
	            .orElse(new FeatureConfig());

	    boolean isNew = (config.getId() == null);

	    config.setFeature(feature);
	    config.setEnvironment(env);
	    config.setEnabled(enabled);
	    config.setRolloutPercentage(rollout);
	    config.setUpdatedAt(LocalDateTime.now());

	    if (config.getCreatedAt() == null) {
	        config.setCreatedAt(LocalDateTime.now());
	    }

	    FeatureConfig savedConfig = configRepo.save(config);

	    // AUDIT LOG
	    AuditLog log = new AuditLog();
	    log.setFeature(feature);
	    log.setAction(isNew ? "CREATED" : "UPDATED");
	    log.setChangedBy("admin");
	    log.setTimestamp(LocalDateTime.now());

	    auditRepo.save(log);

	    return savedConfig; 
	}

	public EvaluationResponseDTO evaluateFeature(String featureName, String userId, String envName) {

	    EvaluationResponseDTO response = new EvaluationResponseDTO();
	    response.setFeatureName(featureName);

	    // 1. Get Config (from cache)
	    FeatureConfig config = cacheService.getFeatureConfig(featureName, envName);

	    // 2. Global check
	    if (!config.getFeature().isActive()) {
	        response.setEnabled(false);
	        response.setReason("FEATURE_DISABLED_GLOBALLY");
	        return response;
	    }

	    // 3. Enabled check
	    if (!config.isEnabled()) {
	        response.setEnabled(false);
	        response.setReason("DISABLED_IN_ENVIRONMENT");
	        return response;
	    }

	    // 4. Rollout logic
	    int percentage = config.getRolloutPercentage();
	    int hash = Math.abs((userId + featureName).hashCode()) % 100;

	    if (hash < percentage) {
	        response.setEnabled(true);
	        response.setReason("ROLLOUT_MATCH");
	    } else {
	        response.setEnabled(false);
	        response.setReason("ROLLOUT_EXCLUDED");
	    }

	    return response;
	}
	
	private FeatureConfigDTO mapToDTO(FeatureConfig config) {

		FeatureConfigDTO dto = new FeatureConfigDTO();

		dto.setFeatureName(config.getFeature().getName());
		dto.setEnvironment(config.getEnvironment().getName());
		dto.setEnabled(config.isEnabled());
		dto.setRolloutPercentage(config.getRolloutPercentage());

		return dto;
	}
	public FeatureConfig getRawConfig(String featureName, String envName) {
		return cacheService.getFeatureConfig(featureName, envName);
	}

	public FeatureConfigDTO convertToDTO(FeatureConfig config) {
		return mapToDTO(config);
	}
}