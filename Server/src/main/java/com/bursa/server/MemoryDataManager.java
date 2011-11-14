package com.bursa.server;

import java.util.ArrayList;
import java.util.Vector;

import com.bursa.interfata.Offer;
import com.bursa.interfata.Offer.OfferType;
import com.bursa.interfata.Transaction;
import com.bursa.server.objectIdentifier.OfferWrapper;
import com.bursa.server.objectIdentifier.TransactionWrapper;

/**
 * Simulates the actions using objects from memory;
 */
public class MemoryDataManager implements DataManager {
	private ArrayList<OfferWrapper> shares;
	private Vector<TransactionWrapper> transactions;
	
	public MemoryDataManager() {
		this.shares = new ArrayList<OfferWrapper>();
		this.transactions = new Vector<TransactionWrapper>();
	}
	
	private void checkMatchingTransaction(OfferWrapper o){
		for(OfferWrapper offer:shares){
			if(offer.getType()==OfferType.SELL &&
					o.getType()==OfferType.BUY &&
					offer.getShare().getCompany().equals(o.getShare().getCompany()) &&
					offer.getShare().getValue()<=o.getShare().getValue()){

				int quantity = offer.getShare().getNumber()>o.getShare().getNumber()?o.getShare().getNumber():offer.getShare().getNumber();
				Transaction t = new Transaction(offer.getClientId(), o.getClientId(), 
						o.getShare().getCompany(), 
						offer.getShare().getValue(),
						quantity);
				TransactionWrapper tw = new TransactionWrapper(t);

				transactions.add(tw);
				
				Offer o2 = offer.getShare().cloneWithOtherQuantity(quantity);
				Offer o3 = o.getShare().cloneWithOtherQuantity(quantity);
					
				offer.setShare(o2);
				o.setShare(o3);
				
				//offer.getShare().decrease(quantity);
				//o.getShare().decrease(quantity);
				
				if(o.getShare().getNumber()==0)
					shares.remove(o);
				if(offer.getShare().getNumber()==0)
					shares.remove(offer);
				if (!(o.getShare().getNumber()==0 || offer.getShare().getNumber()==0))
					throw new IllegalStateException("You shouldn't see this!");
				return;
			}
			if(offer.getType()==OfferType.BUY &&
					o.getType()==OfferType.SELL &&
					offer.getShare().getCompany().equals(o.getShare().getCompany()) &&
					offer.getShare().getValue()>=o.getShare().getValue()){

				int quantity = offer.getShare().getNumber()>o.getShare().getNumber()?o.getShare().getNumber():offer.getShare().getNumber();
				Transaction t = new Transaction(o.getClientId(), offer.getClientId(), 
						o.getShare().getCompany(), 
						o.getShare().getValue(),
						quantity);
				TransactionWrapper tw = new TransactionWrapper(t);
				
				transactions.add(tw);

				Offer o2 = offer.getShare().cloneWithOtherQuantity(quantity);
				Offer o3 = o.getShare().cloneWithOtherQuantity(quantity);
					
				offer.setShare(o2);
				o.setShare(o3);
				
				//offer.getShare().decrease(quantity);
				//o.getShare().decrease(quantity);
				
				if(o.getShare().getNumber()==0)
					shares.remove(o);
				if(offer.getShare().getNumber()==0)
					shares.remove(offer);
				if (!(o.getShare().getNumber()==0 || offer.getShare().getNumber()==0))
					throw new IllegalStateException("You shouldn't see this!");
				return;
			}
		}
	}
	
	public synchronized boolean addShare(Offer share, int id) {
		OfferWrapper newShare = new OfferWrapper(share, id);
		boolean result = shares.add(newShare);
		checkMatchingTransaction(newShare);
		return result;
	}

	public synchronized ArrayList<Offer> getShares(OfferType type) {
		ArrayList<Offer> result = new ArrayList<Offer>();
		
		for (OfferWrapper s:shares) {
			OfferType offer = s.getType();
			
			if (offer.compareTo(type) == 0) {
				result.add(s.getShare());
			}
		}

		return result;
	}
	
	public synchronized boolean modifyShare(Offer newShare, Offer oldShare, int id) {
		for(OfferWrapper s:shares){
			if(s.getClientId()==id){
				if(s.getShare().equals(oldShare)){
					s.setShare(newShare);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ThreadSafe because transaction is immutual.
	 */
	public ArrayList<Transaction> getTransactions(int transactionCount) {
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		
		for (int i=transactions.size()-1, j=0; i>=0 && j<transactionCount; j++, i--) {
			Transaction tr = transactions.get(i).getTransaction();
			result.add (tr);
		}
		
		return result;
	}

	/**
	 * ThreadSafe because vector is synchronized.
	 */
	public boolean addTransaction(Transaction t) {
		boolean result = false;
		
		TransactionWrapper tran = new TransactionWrapper(t);
		result = transactions.add(tran);
		
		return result;
	}
}
