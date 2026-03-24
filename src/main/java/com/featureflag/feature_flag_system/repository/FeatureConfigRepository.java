package com.featureflag.feature_flag_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.featureflag.feature_flag_system.model.FeatureConfig;

public interface FeatureConfigRepository extends JpaRepository<FeatureConfig, String> {
    Optional<FeatureConfig> findByFeatureIdAndEnvironmentId(String featureId, String environmentId);
}