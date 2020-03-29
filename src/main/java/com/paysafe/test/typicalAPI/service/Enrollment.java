package com.paysafe.test.typicalAPI.service;

import java.util.List;

public class Enrollment {

	private String acsURL;
    private String txnTime;
    private String customerIp;
    private String status;
    private String threeDEnrollment;
	private String merchantRefNum;
    private String currency;
    private int amount;
    private Card card;
    private String id;
    private String paReq;
    
    public Enrollment() {
    	
    }
    
    

	 public String getAcsURL() {
		return acsURL;
	}



	public void setAcsURL(String acsURL) {
		this.acsURL = acsURL;
	}



	public String getTxnTime() {
		return txnTime;
	}



	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}



	public String getCustomerIp() {
		return customerIp;
	}



	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	public String getThreeDEnrollment() {
		return threeDEnrollment;
	}

	public void setThreeDEnrollment(String threeDEnrollment) {
		this.threeDEnrollment = threeDEnrollment;
	}

	public String getMerchantRefNum() {
		return merchantRefNum;
	}



	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public Card getCard() {
		return card;
	}



	public void setCard(Card card) {
		this.card = card;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPaReq() {
		return paReq;
	}



	public void setPaReq(String paReq) {
		this.paReq = paReq;
	}

	@Override
	public String toString() {
		return "Enrollment [acsURL=" + acsURL + ", txnTime=" + txnTime + ", customerIp=" + customerIp + ", status="
				+ status + ", merchantRefNum=" + merchantRefNum + ", currency=" + currency + ", amount=" + amount
				+ ", card=" + card + ", id=" + id + ", paReq=" + paReq + "]";
	}



	public class Card{
		private  String lastDigits;
		private CardExpiry cardExpiry;
		private String cardType;
		
		public Card() {
			
		}

		public String getLastDigits() {
			return lastDigits;
		}

		public void setLastDigits(String lastDigits) {
			this.lastDigits = lastDigits;
		}

		public CardExpiry getCardExpiry() {
			return cardExpiry;
		}

		public void setCardExpiry(CardExpiry cardExpiry) {
			this.cardExpiry = cardExpiry;
		}

		public String getCardType() {
			return cardType;
		}

		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		@Override
		public String toString() {
			return "Card [lastDigits=" + lastDigits + ", cardExpiry=" + cardExpiry + ", cardType=" + cardType + "]";
		}
		
	
	}
    
}
