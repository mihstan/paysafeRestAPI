package com.paysafe.test.typicalAPI.service;

public class CardExpiry {

	private int month;
	private int year;
	
	public CardExpiry() {
		
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "CardExpiry [month=" + month + ", year=" + year + "]";
	}
	
	
}
