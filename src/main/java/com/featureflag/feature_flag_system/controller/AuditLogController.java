package com.featureflag.feature_flag_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.featureflag.feature_flag_system.dto.AuditLogDTO;
import com.featureflag.feature_flag_system.service.AuditLogService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

	private final AuditLogService service;

	public AuditLogController(AuditLogService service) {
		this.service = service;
	}

	@GetMapping
	public List<AuditLogDTO> getLogs(
			@RequestParam(value = "featureName", required = false) String featureName) {

		if (featureName != null && !featureName.isBlank()) {
			return service.getLogsByFeature(featureName);
		}

		return service.getAllLogs();
	}
}