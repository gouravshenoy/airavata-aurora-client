package org.apache.airavata.cloud.aurora.client.bean;

public class ProcessBean {

	private String name;
	private String cmdLine;
	private boolean isDaemon;
	private boolean isEphemeral;
	private boolean isFinal;
	private int max_failures;
	private int min_duration;

	public ProcessBean(String name, String cmdLine, boolean isDaemon) {
		this.name = name;
		this.cmdLine = cmdLine;
		this.isDaemon = isDaemon;
		
		// set defaults
		this.isEphemeral = false;
		this.isFinal = false;
		this.max_failures = 1;
		this.min_duration = 5;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmdLine() {
		return cmdLine;
	}

	public void setCmdLine(String cmdLine) {
		this.cmdLine = cmdLine;
	}

	public boolean isDaemon() {
		return isDaemon;
	}

	public void setDaemon(boolean isDaemon) {
		this.isDaemon = isDaemon;
	}

	public boolean isEphemeral() {
		return isEphemeral;
	}

	public void setEphemeral(boolean isEphemeral) {
		this.isEphemeral = isEphemeral;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public int getMax_failures() {
		return max_failures;
	}

	public void setMax_failures(int max_failures) {
		this.max_failures = max_failures;
	}

	public int getMin_duration() {
		return min_duration;
	}

	public void setMin_duration(int min_duration) {
		this.min_duration = min_duration;
	}
	
}
