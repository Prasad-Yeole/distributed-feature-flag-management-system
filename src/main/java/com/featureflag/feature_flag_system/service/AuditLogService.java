package com.featureflag.feature_flag_system.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.featureflag.feature_flag_system.dto.AuditLogDTO;
import com.featureflag.feature_flag_system.model.AuditLog;
import com.featureflag.feature_flag_system.repository.AuditLogRepository;

@Service
public class AuditLogService {

    private final AuditLogRepository auditRepo;

    public AuditLogService(AuditLogRepository auditRepo) {
        this.auditRepo = auditRepo;
    }

    //  GET ALL LOGS
    public List<AuditLogDTO> getAllLogs() {
        return auditRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    //  FILTER BY FEATURE
    public List<AuditLogDTO> getLogsByFeature(String featureName) {
        return auditRepo.findByFeature_Name(featureName)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    //  DTO MAPPING
    private AuditLogDTO mapToDTO(AuditLog log) {
        AuditLogDTO dto = new AuditLogDTO();

        dto.setFeatureName(log.getFeature().getName());
        dto.setAction(log.getAction());
        dto.setChangedBy(log.getChangedBy());
        dto.setTimestamp(log.getTimestamp());

        return dto;
    }
}