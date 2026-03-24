package com.featureflag.feature_flag_system.dto;

import jakarta.validation.constraints.*;

public class ConfigRequestDTO {

	@NotBlank(message = "Feature ID cannot be empty")
	private String featureId;
    
	@NotBlank(message = "Environment ID cannot be empty")
	private String envId;
    
	private boolean enabled;
    
	 @Min(value = 0, message = "Rollout must be >= 0")
	 @Max(value = 100, message = "Rollout must be <= 100")
    private int rollout;

    // getters & setters
    public String getFeatureId() { return featureId; }
    public void setFeatureId(String featureId) { this.featureId = featureId; }

    public String getEnvId() { return envId; }
    public void setEnvId(String envId) { this.envId = envId; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public int getRollout() { return rollout; }
    public void setRollout(int rollout) { this.rollout = rollout; }
}