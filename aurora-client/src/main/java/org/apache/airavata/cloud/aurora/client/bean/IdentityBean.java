package org.apache.airavata.cloud.aurora.client.bean;

public class IdentityBean {

	private String user;
	
	public IdentityBean(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
