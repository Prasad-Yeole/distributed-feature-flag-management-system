package com.featureflag.feature_flag_system.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.featureflag.feature_flag_system.model.FeatureConfig;
import com.featureflag.feature_flag_system.model.FeatureFlag;
import com.featureflag.feature_flag_system.model.Environment;
import com.featureflag.feature_flag_system.repository.FeatureConfigRepository;
import com.featureflag.feature_flag_system.repository.FeatureFlagRepository;
import com.featureflag.feature_flag_system.repository.EnvironmentRepository;

@Service
public class FeatureCacheService {

    private final FeatureConfigRepository configRepo;
    private final FeatureFlagRepository featureRepo;
    private final EnvironmentRepository envRepo;

    public FeatureCacheService(FeatureConfigRepository configRepo,
                               FeatureFlagRepository featureRepo,
                               EnvironmentRepository envRepo) {
        this.configRepo = configRepo;
        this.featureRepo = featureRepo;
        this.envRepo = envRepo;
    }

    @Cacheable(value = "featureConfigCache", key = "#featureName + '_' + #envName")
    public FeatureConfig getFeatureConfig(String featureName, String envName) {

        System.out.println("DB HIT (cache miss)");

        FeatureFlag feature = featureRepo.findByName(featureName)
                .orElseThrow(() -> new RuntimeException("Feature not found"));

        Environment env = envRepo.findByName(envName)
                .orElseThrow(() -> new RuntimeException("Environment not found"));

        return configRepo
                .findByFeatureIdAndEnvironmentId(feature.getId(), env.getId())
                .orElseThrow(() -> new RuntimeException("Config not found"));
    }
}