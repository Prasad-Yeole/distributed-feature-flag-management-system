package com.featureflag.feature_flag_system.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.featureflag.feature_flag_system.model.FeatureFlag;

public interface FeatureFlagRepository extends JpaRepository<FeatureFlag, String> {
	Optional<FeatureFlag> findByName(String name);
}