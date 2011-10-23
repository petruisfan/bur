package com.bursa.interfata;

public class Share {
	
	public enum OfferType {
		SELL,
		BUY
	}
	
	private OfferType type;		// sell or buy
	private String company;		// the name of the company
	private int number;			// the number of shares
	private int value;			// the value of one share
	

	public Share(OfferType type, String company, int number, int value) {
		assert(number > 0);
		assert(value > 0);
		assert(type != null);
		assert(company != null);
		
		this.type = type;
		this.company = company;
		this.number = number;
		this.value = value;
	}


	public OfferType getType() {
		return this.type;
	}
	
}
