package com.featureflag.feature_flag_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.featureflag.feature_flag_system.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, String> {

    List<AuditLog> findByFeature_Name(String featureName);

}