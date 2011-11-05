package com.bursa.server.objectIdentifier;

import com.bursa.interfata.Offer;
import com.bursa.interfata.Offer.OfferType;

public class OfferWrapper {
	private Offer share;
	
	private static int id = 0;	// the id of the last share action
	private final int shareId;	// unique id for each share action
	private int clientId;		// who is selling/ buying
	
	public OfferWrapper(Offer s, int id2) {
		this.share = s;
		this.clientId = id2;
		shareId = ++id;
		if (id > Integer.MAX_VALUE-5) {
			System.out.println("Id reseting");
		}
	}
	
	public int getId() {
		return shareId;
	}

	public Offer getShare() {
		return share;
	}

	public OfferType getType() {
		OfferType result = share.getType();
		return result;
	}
}
