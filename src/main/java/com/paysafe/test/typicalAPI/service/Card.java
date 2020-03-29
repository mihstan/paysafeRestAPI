package com.paysafe.test.typicalAPI.service;

public class Card {

	private String cardNum;
	private CardExpiry cardExpiry;
	
	public Card() {
		
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

	@Override
	public String toString() {
		return "Card [cardNum=" + cardNum + ", cardExpiry=" + cardExpiry + "]";
	}
	
	
}
