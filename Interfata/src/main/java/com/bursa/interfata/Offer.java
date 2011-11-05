package com.bursa.interfata;

import java.io.Serializable;
import java.security.InvalidParameterException;

public class Offer implements Serializable{
	private static final long serialVersionUID = 933734879983461281L;

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
	
	public void decrease(int quantity){
		if(quantity>number)
			throw new InvalidParameterException("Quantity larger than number");
		number -= quantity;
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
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Offer))
			return false;
		
		Offer offer = (Offer)obj;
		
		if(offer.getCompany().equals(this.company) &&
				offer.getNumber()==this.number &&
				offer.getValue()==this.value &&
				offer.getType().equals(this.type))
		return true;
		
		return false;
	}
	
}
