package com.paysafe.test.typicalAPI.service;

public class Auths {
	
	private String merchantRefNum;
	private int amount;
	private boolean settleWithAuth;
	private Card card;
	private Authentication authentication;
	private BillinDetails billinDetails;
	
	public Auths() {
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



	public boolean isSettleWithAuth() {
		return settleWithAuth;
	}



	public void setSettleWithAuth(boolean settleWithAuth) {
		this.settleWithAuth = settleWithAuth;
	}



	public Card getCard() {
		return card;
	}



	public void setCard(Card card) {
		this.card = card;
	}



	public Authentication getAuthentication() {
		return authentication;
	}



	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}



	public BillinDetails getBillinDetails() {
		return billinDetails;
	}



	public void setBillinDetails(BillinDetails billinDetails) {
		this.billinDetails = billinDetails;
	}



	@Override
	public String toString() {
		return "Auths [merchantRefNum=" + merchantRefNum + ", amount=" + amount + ", settleWithAuth=" + settleWithAuth
				+ ", card=" + card + ", authentication=" + authentication + ", billinDetails=" + billinDetails + "]";
	}



	public static class Card{
		private String cardNum;
		private CardExpiry cardExpiry;
		private int cvv;
		
		public Card() {
		}

		public Card(String cardNum, CardExpiry cardExpiry, int cvv) {
			super();
			this.cardNum = cardNum;
			this.cardExpiry = cardExpiry;
			this.cvv = cvv;
		}



		public String getCardNum() {
			return cardNum;
		}

		public void setCardNum(String cardNum) {
			this.cardNum = cardNum;
		}

		public CardExpiry getCardExpiry() {
			return cardExpiry;
		}

		public void setCardExpiry(CardExpiry cardExpiry) {
			this.cardExpiry = cardExpiry;
		}

		public int getCvv() {
			return cvv;
		}

		public void setCvv(int cvv) {
			this.cvv = cvv;
		}

		@Override
		public String toString() {
			return "Card [cardNum=" + cardNum + ", cardExpiry=" + cardExpiry + ", cvv=" + cvv + "]";
		}
		
		
	}
	
}
