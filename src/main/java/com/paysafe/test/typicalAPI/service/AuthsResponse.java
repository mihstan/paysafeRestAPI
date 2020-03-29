package com.paysafe.test.typicalAPI.service;

public class AuthsResponse {

	private String id;
	private String merchantRefNum;
	private String txnTime;
	private String status;
	private int amount;
	private boolean settleWithAuth;
	private int availableToSettle;
	private Card card;
	
	public AuthsResponse() {
		
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMerchantRefNum() {
		return merchantRefNum;
	}



	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}



	public String getTxnTime() {
		return txnTime;
	}



	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public boolean isSettleWithAuth() {
		return settleWithAuth;
	}



	public void setSettleWithAuth(boolean settleWithAuth) {
		this.settleWithAuth = settleWithAuth;
	}



	public int getAvailableToSettle() {
		return availableToSettle;
	}



	public void setAvailableToSettle(int availableToSettle) {
		this.availableToSettle = availableToSettle;
	}



	public Card getCard() {
		return card;
	}



	public void setCard(Card card) {
		this.card = card;
	}



	@Override
	public String toString() {
		return "AuthsResponse [id=" + id + ", merchantRefNum=" + merchantRefNum + ", txnTime=" + txnTime + ", status="
				+ status + ", amount=" + amount + ", settleWithAuth=" + settleWithAuth + ", availableToSettle="
				+ availableToSettle + ", card=" + card + "]";
	}



	class Card{
		private String type;
		private String lastDigits;
		private CardExpiry cardExpiry;
		
		public Card() {
			
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
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

		@Override
		public String toString() {
			return "Card [type=" + type + ", lastDigits=" + lastDigits + ", cardExpiry=" + cardExpiry + "]";
		}
		
		
	}
}
