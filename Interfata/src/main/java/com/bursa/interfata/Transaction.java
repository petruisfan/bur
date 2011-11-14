package com.bursa.interfata;

import java.io.Serializable;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 76789037759155600L;

	private final int sellerId;			// who is the seller
	private final int buyerId;			// who is the buyer
	private final String company;		// for what company
	private final int value;				// the value of one share
	private final int number;				// the number of shares

	
	public Transaction(int sellerId, int buyerId, String company, int value,int number) {
		assert company != null && !company.equals("");
		assert value>0 && number>0;
		
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.company = company;
		this.value = value;
		this.number = number;
	}


	public int getSellerId() {
		return sellerId;
	}


	public int getBuyerId() {
		return buyerId;
	}


	public String getCompany() {
		return company;
	}


	public int getValue() {
		return value;
	}


	public int getNumber() {
		return number;
	}

	public String toString() {
		String result = "";
		
		result += sellerId + " " + buyerId + " " + company + " " + value + " " + number;
		
		return result;
	}
}
