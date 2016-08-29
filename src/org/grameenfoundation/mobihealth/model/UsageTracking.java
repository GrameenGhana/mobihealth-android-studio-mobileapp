package org.grameenfoundation.mobihealth.model;

public class UsageTracking {

	String usageId;
	String username;
	String module;
	String submodule;
	String duration;
	String durationPlayed;
	String actionDate;
	String  type;
	String status;
	String extras;
	
	public UsageTracking()
	{
		
	}
	

	public String getUsageId() {
		return usageId;
	}
	public void setUsageId(String usageId) {
		this.usageId = usageId;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	public String getSubModule() {
		return submodule;
	}
	public void setSubModule(String submodule) {
		this.submodule = submodule;
	}
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDurationPlayed() {
		return durationPlayed;
	}
	public void setDurationPlayed(String durationPlayed) {
		this.durationPlayed = durationPlayed;
	}
	
	public String getActionDate() {
		return actionDate;
	}
	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras= extras;
	}
}
