package org.apache.airavata.cloud.aurora.client.bean;

public class JobConfigBean {

	private JobKeyBean job;
	
	private IdentityBean owner;
	
	private TaskConfigBean taskConfig;
	
	private boolean isService;
	
	private int priority;
	
	private boolean production;
	
	private int maxTaskFailures;
	
	private int instances;
	
	private String cluster;
	
	public JobConfigBean(JobKeyBean job, IdentityBean owner, TaskConfigBean taskConfig, String cluster) {
		this.job = job;
		this.owner = owner;
		this.taskConfig = taskConfig;
		this.cluster = cluster;
		
		// set defaults
		this.isService = false;
		this.maxTaskFailures = 1;
		this.instances = 1;
	}
	
	public JobKeyBean getJob() {
		return job;
	}
	
	public void setJob(JobKeyBean job) {
		this.job = job;
	}

	public IdentityBean getOwner() {
		return owner;
	}

	public void setOwner(IdentityBean owner) {
		this.owner = owner;
	}

	public boolean isService() {
		return isService;
	}

	public void setService(boolean isService) {
		this.isService = isService;
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public boolean isProduction() {
		return production;
	}

	public void setProduction(boolean production) {
		this.production = production;
	}

	public TaskConfigBean getTaskConfig() {
		return taskConfig;
	}

	public void setTaskConfig(TaskConfigBean taskConfig) {
		this.taskConfig = taskConfig;
	}

	public int getMaxTaskFailures() {
		return maxTaskFailures;
	}

	public void setMaxTaskFailures(int maxTaskFailures) {
		this.maxTaskFailures = maxTaskFailures;
	}

	public int getInstances() {
		return instances;
	}

	public void setInstances(int instances) {
		this.instances = instances;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
}
