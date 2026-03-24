package com.featureflag.feature_flag_system.service;

import com.featureflag.feature_flag_system.model.FeatureFlag;
import com.featureflag.feature_flag_system.model.AuditLog;
import com.featureflag.feature_flag_system.exception.FeatureNotFoundException;
import com.featureflag.feature_flag_system.repository.FeatureFlagRepository;
import com.featureflag.feature_flag_system.repository.AuditLogRepository; 

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeatureFlagService {

	private final FeatureFlagRepository featureFlagRepository;
	private final AuditLogRepository auditRepo; 

	// UPDATED CONSTRUCTOR (no breaking change, Spring will inject automatically)
	public FeatureFlagService(FeatureFlagRepository featureFlagRepository,
			AuditLogRepository auditRepo) {
		this.featureFlagRepository = featureFlagRepository;
		this.auditRepo = auditRepo;
	}

	// CREATE FEATURE
	public FeatureFlag createFeature(FeatureFlag feature) {

		feature.setCreatedAt(LocalDateTime.now());
		feature.setUpdatedAt(LocalDateTime.now());

		FeatureFlag saved = featureFlagRepository.save(feature);

		// AUDIT LOG (NEW)
		AuditLog log = new AuditLog();
		log.setFeature(saved);
		log.setAction("FEATURE_CREATED");
		log.setChangedBy("admin"); // can improve later
		log.setTimestamp(LocalDateTime.now());

		auditRepo.save(log);

		return saved;
	}

	// GET ALL FEATURES
	public List<FeatureFlag> getAllFeatures() {
		return featureFlagRepository.findAll();
	}

	// GET FEATURE BY ID
	public FeatureFlag getFeatureById(String id) {
		return featureFlagRepository.findById(id)
				.orElseThrow(() -> new FeatureNotFoundException("Feature not found"));
	}

	// UPDATE FEATURE
	public FeatureFlag updateFeature(String id, FeatureFlag updatedFeature) {

		FeatureFlag existing = getFeatureById(id);

		if (updatedFeature.getName() != null)
			existing.setName(updatedFeature.getName());

		if (updatedFeature.getDescription() != null)
			existing.setDescription(updatedFeature.getDescription());

		if (updatedFeature.getOwner() != null)
			existing.setOwner(updatedFeature.getOwner());

		existing.setActive(updatedFeature.isActive());
		existing.setUpdatedAt(LocalDateTime.now());

		FeatureFlag saved = featureFlagRepository.save(existing);

		// AUDIT LOG (NEW)
		AuditLog log = new AuditLog();
		log.setFeature(saved);
		log.setAction("FEATURE_UPDATED");
		log.setChangedBy("admin");
		log.setTimestamp(LocalDateTime.now());

		auditRepo.save(log);

		return saved;
	}

	// DELETE FEATURE
	public void deleteFeature(String id) {
		FeatureFlag feature = getFeatureById(id); 
		featureFlagRepository.delete(feature); 
	}
}