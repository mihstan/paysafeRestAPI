package com.paysafe.test.typicalAPI.service;


public class AccessControlServerOptions {

	private String acsURL;
    private String paReq;
    
    public AccessControlServerOptions() {
    	
    }

	public String getAcsURL() {
		return acsURL;
	}

	public void setAcsURL(String acsURL) {
		this.acsURL = acsURL;
	}

	public String getPaReq() {
		return paReq;
	}

	public void setPaReq(String paReq) {
		this.paReq = paReq;
	}

	@Override
	public String toString() {
		return "AccessControlServerOptions [acsURL=" + acsURL + ", paReq=" + paReq + "]";
	}
   
}
