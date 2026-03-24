package com.featureflag.feature_flag_system.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.featureflag.feature_flag_system.dto.EvaluationResponseDTO;
import com.featureflag.feature_flag_system.service.FeatureConfigService;

import jakarta.validation.constraints.NotBlank;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/features")
@Validated
public class FeatureEvaluationController {

    private final FeatureConfigService service;

    public FeatureEvaluationController(FeatureConfigService service) {
        this.service = service;
    }

    @GetMapping("/evaluate")
    public EvaluationResponseDTO evaluateFeature(
        @RequestParam("featureName") @NotBlank String featureName,
        @RequestParam("userId") @NotBlank String userId,
        @RequestParam("env") @NotBlank String env) {

        return service.evaluateFeature(featureName, userId, env);
    }
}