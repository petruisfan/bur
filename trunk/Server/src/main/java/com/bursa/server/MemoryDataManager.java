package com.bursa.server;

import java.util.ArrayList;

import com.bursa.interfata.Share;
import com.bursa.interfata.Share.OfferType;
import com.bursa.interfata.Transaction;
import com.bursa.server.objectIdentifier.ShareIdentifier;
import com.bursa.server.objectIdentifier.TransactionIdentifier;

public class MemoryDataManager implements DataManager {
	private ArrayList<ShareIdentifier> shares;
	private ArrayList<TransactionIdentifier> transactions;
	
	
	public MemoryDataManager() {
		this.shares = new ArrayList<ShareIdentifier>();
		this.transactions = new ArrayList<TransactionIdentifier>();
	}
	
	public boolean addShare(Share share) {
		ShareIdentifier newShare = new ShareIdentifier(share);
		boolean result = shares.add(newShare);
		return result;
	}

	public ArrayList<Share> getShares(OfferType type) {
		ArrayList<Share> result = new ArrayList<Share>();
		
		for (ShareIdentifier s:shares) {
			OfferType offer = s.getType();
			
			if (offer.compareTo(type) == 0) {
				result.add(s.getShare());
			}
		}

		return result;
	}

	public boolean modifyShare(Share share) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
