package com.featureflag.feature_flag_system.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.featureflag.feature_flag_system.model.Environment;


public interface EnvironmentRepository extends JpaRepository<Environment, String> {
	Optional<Environment> findByName(String name);
}