package com.paysafe.test.typicalAPI.service;

public class AuthenticationResult {
	
	private String threeDResult;
	private String txnTime;
	private String cavv;
	private String signatureStatus;
	private String status;
	private String merchantRefNum;
	private String xid;
	private int eci;
	private String id;
	
	public AuthenticationResult () {
		
	}

	public String getThreeDResult() {
		return threeDResult;
	}

	public void setThreeDResult(String threeDResult) {
		this.threeDResult = threeDResult;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public String getCavv() {
		return cavv;
	}

	public void setCavv(String cavv) {
		this.cavv = cavv;
	}

	public String getSignatureStatus() {
		return signatureStatus;
	}

	public void setSignatureStatus(String signatureStatus) {
		this.signatureStatus = signatureStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMerchantRefNum() {
		return merchantRefNum;
	}

	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}

	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public int getEci() {
		return eci;
	}

	public void setEci(int eci) {
		this.eci = eci;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AuthenticationResult [threeDResult=" + threeDResult + ", txnTime=" + txnTime + ", cavv=" + cavv
				+ ", signatureStatus=" + signatureStatus + ", status=" + status + ", merchantRefNum=" + merchantRefNum
				+ ", xid=" + xid + ", eci=" + eci + ", id=" + id + "]";
	}
}
