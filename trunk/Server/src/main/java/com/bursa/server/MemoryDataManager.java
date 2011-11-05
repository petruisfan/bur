package com.bursa.server;

import java.util.ArrayList;

import com.bursa.interfata.Offer;
import com.bursa.interfata.Offer.OfferType;
import com.bursa.interfata.Transaction;
import com.bursa.server.objectIdentifier.OfferWrapper;
import com.bursa.server.objectIdentifier.TransactionWrapper;

/**
 * Simulates the actions using objects from memory;
 * @author petre
 */
public class MemoryDataManager implements DataManager {
	private ArrayList<OfferWrapper> shares;
	private ArrayList<TransactionWrapper> transactions;
	
	public MemoryDataManager() {
		this.shares = new ArrayList<OfferWrapper>();
		this.transactions = new ArrayList<TransactionWrapper>();
	}
	
	
	public boolean addShare(Offer share, int id) {
		OfferWrapper newShare = new OfferWrapper(share, id);
		boolean result = shares.add(newShare);
		return result;
	}

	
	public ArrayList<Offer> getShares(OfferType type) {
		ArrayList<Offer> result = new ArrayList<Offer>();
		
		for (OfferWrapper s:shares) {
			OfferType offer = s.getType();
			
			if (offer.compareTo(type) == 0) {
				result.add(s.getShare());
			}
		}

		return result;
	}

	
	public boolean modifyShare(Offer share, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public ArrayList<Transaction> getTransactions(int transactionCount) {
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		
		for (int i=transactions.size()-1, j=0; i>0 && j<transactionCount; j++, i--) {
			Transaction tr = transactions.get(i).getTransaction();
			result.add (tr);
		}
		
		return result;
	}

	
	public boolean addTransaction(Transaction t) {
		boolean result = false;
		
		TransactionWrapper tran = new TransactionWrapper(t);
		result = transactions.add(tran);
		
		return result;
	}
}
