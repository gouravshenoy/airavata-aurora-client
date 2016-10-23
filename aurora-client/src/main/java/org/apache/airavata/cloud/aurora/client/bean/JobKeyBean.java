package org.apache.airavata.cloud.aurora.client.bean;

public class JobKeyBean {

	private String environment;
	private String role;
	private String name;
	
	public JobKeyBean(String environment, String role, String name) {
		this.environment = environment;
		this.role = role;
		this.name = name;
	}
	
	public String getEnvironment() {
		return environment;
	}
	
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
