package com.featureflag.feature_flag_system.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.featureflag.feature_flag_system.dto.ConfigRequestDTO;
import com.featureflag.feature_flag_system.dto.FeatureConfigDTO;
import com.featureflag.feature_flag_system.model.FeatureConfig;
import com.featureflag.feature_flag_system.service.FeatureConfigService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/configs")
@Validated
public class FeatureConfigController {

    private final FeatureConfigService service;

    public FeatureConfigController(FeatureConfigService service) {
        this.service = service;
    }

//    @GetMapping("/evaluate")
//    public EvaluationResponseDTO evaluateFeature(
//        @RequestParam("featureName") @NotBlank(message = "Feature name required") String featureName,
//        @RequestParam("userId") @NotBlank(message = "UserId required") String userId,
//        @RequestParam("env") @NotBlank(message = "Environment required") String env) {
//
//        return service.evaluateFeature(featureName, userId, env);
//    }
    
    @PostMapping
    public FeatureConfigDTO createOrUpdate(@Valid @RequestBody ConfigRequestDTO request) {

    	System.out.println("REQUEST: " + request.getFeatureId() + " " + request.getRollout());
    	
    	FeatureConfig config = service.createOrUpdateConfig(
                request.getFeatureId(),
                request.getEnvId(),
                request.isEnabled(),
                request.getRollout()
        );

        return service.convertToDTO(config);
    }
    
    @GetMapping
    public FeatureConfigDTO getConfig(
        @RequestParam("featureName") @NotBlank String featureName,
        @RequestParam("env") @NotBlank String env) {

        FeatureConfig config = service.getRawConfig(featureName, env);
        return service.convertToDTO(config);
    }
}
