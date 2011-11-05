package com.bursa.interfata;

import java.io.Serializable;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 76789037759155600L;

	private int sellerId = 0;			// who is the seller
	private int buyerId = 0;			// who is the buyer
	private String company = "";		// for what company
	private int value = 0;				// the value of one share
	private int number = 0;				// the number of shares

	
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
