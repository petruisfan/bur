package com.bursa.interfata;

public class Transaction {
	private int sellerId = 0;			// who is the seller
	private int buyerId = 0;			// who is the buyer
	private String company = "";		// for what company
	private int value = 0;				// the value of one share
	private int number = 0;				// the number of shares

	
	public Transaction(int sellerId, int buyerId, String company, int value,int number) {
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.company = company;
		this.value = value;
		this.number = number;
	}
	
}
