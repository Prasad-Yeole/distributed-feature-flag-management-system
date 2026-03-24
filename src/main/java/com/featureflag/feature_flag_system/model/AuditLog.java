package com.featureflag.feature_flag_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@ManyToOne
	@JoinColumn(name = "feature_id")
	private FeatureFlag feature;

	private String action; // CREATED / UPDATED

	private String changedBy;

	private LocalDateTime timestamp;

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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}