package org.apache.airavata.cloud.aurora.client.bean;

public class ResourceBean {
	
	private double numCpus;
	
	private long diskMb;
	
	private long ramMb;
	
	public ResourceBean(double numCpus, long diskMb, long ramMb) {
		this.numCpus = numCpus;
		this.diskMb = diskMb;
		this.ramMb = ramMb;
	}

	public double getNumCpus() {
		return numCpus;
	}

	public void setNumCpus(double numCpus) {
		this.numCpus = numCpus;
	}

	public long getDiskMb() {
		return diskMb;
	}

	public void setDiskMb(long diskMb) {
		this.diskMb = diskMb;
	}

	public long getRamMb() {
		return ramMb;
	}

	public void setRamMb(long ramMb) {
		this.ramMb = ramMb;
	}

	
}
