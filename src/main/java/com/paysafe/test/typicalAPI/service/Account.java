package com.paysafe.test.typicalAPI.service;


public class Account {

	
	private String merchantRefNum;
	private int amount;
	private String currency;
	private String customerIp;
	private String userAgent;
	private String acceptHeader;
	private Card card;
	
	public Account() {
		
	}

	public String getMerchantRefNum() {
		return merchantRefNum;
	}

	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomerIp() {
		return customerIp;
	}

	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getAcceptHeader() {
		return acceptHeader;
	}

	public void setAcceptHeader(String acceptHeader) {
		this.acceptHeader = acceptHeader;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Account [merchantRefNum=" + merchantRefNum + ", amount=" + amount + ", currency=" + currency
				+ ", customerIp=" + customerIp + ", userAgent=" + userAgent + ", acceptHeader=" + acceptHeader
				+ ", card=" + card + "]";
	}

}
