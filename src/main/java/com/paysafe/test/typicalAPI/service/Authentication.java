package com.paysafe.test.typicalAPI.service;

public class Authentication {
	
	private int eci;
	private String cavv;
	private String xid;
	private String threeDEnrollment;
	private String threeDResult;
	private String signatureStatus;
	
	public Authentication( ) {
		
	}

	public int getEci() {
		return eci;
	}

	public void setEci(int eci) {
		this.eci = eci;
	}

	public String getCavv() {
		return cavv;
	}

	public void setCavv(String cavv) {
		this.cavv = cavv;
	}

	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public String getThreeDEnrollment() {
		return threeDEnrollment;
	}

	public void setThreeDEnrollment(String threeDEnrollment) {
		this.threeDEnrollment = threeDEnrollment;
	}

	public String getThreeDResult() {
		return threeDResult;
	}

	public void setThreeDResult(String threeDResult) {
		this.threeDResult = threeDResult;
	}

	public String getSignatureStatus() {
		return signatureStatus;
	}

	public void setSignatureStatus(String signatureStatus) {
		this.signatureStatus = signatureStatus;
	}

	@Override
	public String toString() {
		return "Authentication [eci=" + eci + ", cavv=" + cavv + ", xid=" + xid + ", threeDEnrollment="
				+ threeDEnrollment + ", threeDResult=" + threeDResult + ", signatureStatus=" + signatureStatus + "]";
	}

}
