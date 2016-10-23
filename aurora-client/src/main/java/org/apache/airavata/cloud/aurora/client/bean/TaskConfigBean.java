package org.apache.airavata.cloud.aurora.client.bean;

import java.util.HashSet;
import java.util.Set;

public class TaskConfigBean {
	
	private String taskName;
	
	private ResourceBean resources;
	
	private int maxFailures;
	
	private Set<ProcessBean> processes;

	public TaskConfigBean(String taskName, Set<ProcessBean> processes, ResourceBean resources) {
		this.taskName = taskName;
		this.processes = processes;
		this.resources = resources;
		
		// set default value
		this.maxFailures = 1;
	}
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public ResourceBean getResources() {
		return resources;
	}

	public void setResources(ResourceBean resources) {
		this.resources = resources;
	}

	public int getMaxFailures() {
		return maxFailures;
	}

	public void setMaxFailures(int maxFailures) {
		this.maxFailures = maxFailures;
	}

	public Set<ProcessBean> getProcesses() {
		if(processes == null) {
			processes = new HashSet<>();
		}
		
		return processes;
	}

	public void setProcesses(Set<ProcessBean> processes) {
		this.processes = processes;
	}
	
}
