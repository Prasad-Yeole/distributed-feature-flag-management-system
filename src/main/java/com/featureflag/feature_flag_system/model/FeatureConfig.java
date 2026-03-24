package com.featureflag.feature_flag_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(
	    name = "feature_config",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = {"feature_id", "environment_id"})
	    }
	)
public class FeatureConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    private FeatureFlag feature;

    @ManyToOne
    @JoinColumn(name = "environment_id", nullable = false)
    private Environment environment;

    private boolean enabled;

    private int rolloutPercentage;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // getters & setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public FeatureFlag getFeature() {
        return feature;
    }

    public void setFeature(FeatureFlag feature) {
        this.feature = feature;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
    
    public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getRolloutPercentage() {
		return rolloutPercentage;
	}

	public void setRolloutPercentage(int rolloutPercentage) {
		this.rolloutPercentage = rolloutPercentage;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}