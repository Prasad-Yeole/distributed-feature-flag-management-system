package com.featureflag.feature_flag_system.dto;

import java.time.LocalDateTime;

public class AuditLogDTO {

    private String featureName;
    private String action;
    private String changedBy;
    private LocalDateTime timestamp;
	
 // getters & setters
    public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
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