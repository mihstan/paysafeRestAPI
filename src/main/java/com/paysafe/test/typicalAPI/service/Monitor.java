package com.paysafe.test.typicalAPI.service;

public class Monitor {

	private String status;
	
	public Monitor() {
	}

	public Monitor(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Monitor [status=" + status + "]";
	}

}
