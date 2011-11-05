package com.bursa.interfata;

public class Offer {
	
	public enum OfferType {
		SELL,
		BUY
	}
	
	private OfferType type = null;		// sell or buy
	private String company = null;		// the name of the company
	private int number = -1;			// the number of shares
	private int value = -1;			// the value of one share
	

	public Offer(OfferType type, String company, int number, int value) {
		if (number <= 0 || 
				value <= 0 || 
				type == null || 
				company == null ||
				company.equals("")) {
			throw new IllegalArgumentException("Share arguments are not valid");
		}
		
		this.type = type;
		this.company = company;
		this.number = number;
		this.value = value;
	}


	public OfferType getType() {
		return type;
	}


	public String getCompany() {
		return company;
	}


	public int getNumber() {
		return number;
	}


	public int getValue() {
		return value;
	}

	public String toString() {
		String result = "";
		result += this.type + " " + this.company + " " + this.number + " " + this.value;
		return result;
	}
	
}
