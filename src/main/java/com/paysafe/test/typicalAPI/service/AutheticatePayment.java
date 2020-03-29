package com.paysafe.test.typicalAPI.service;

public class AutheticatePayment {

	private String merchantRefNum;
	private String paReq;
	
	public AutheticatePayment() {
		
	}

	public String getMerchantRefNum() {
		return merchantRefNum;
	}

	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}

	public String getPaReq() {
		return paReq;
	}

	public void setPaReq(String paReq) {
		this.paReq = paReq;
	}

	@Override
	public String toString() {
		return "AutheticatePayment [merchantRefNum=" + merchantRefNum + ", paReq=" + paReq + "]";
	}
	
	
}
