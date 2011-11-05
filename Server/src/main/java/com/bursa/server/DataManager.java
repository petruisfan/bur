package com.bursa.server;

import java.util.ArrayList;

import com.bursa.interfata.Offer;
import com.bursa.interfata.Offer.OfferType;
import com.bursa.interfata.Transaction;

public interface DataManager {

	/**
	 * Add a share object to the list of shares.
	 * @param share
	 * @return
	 */
	public boolean addShare(Offer share, int id) ;

	/**
	 * Get the list of shares of a certain type: sell or buy.
	 * @param type
	 * @return
	 */
	public ArrayList<Offer> getShares(OfferType type) ;

	/**
	 * Modify an existing share.
	 * @param share
	 * @param oldShare 
	 * @return
	 */
	public boolean modifyShare(Offer newShare, Offer oldShare, int id) ;

	/**
	 * Get a list of the last 15 transactions;
	 * @return
	 */
	public ArrayList<Transaction> getTransactions(int transactionCount) ;
	
	/**
	 * Add a transcation to the list of transactions;
	 * @param t
	 * @return
	 */
	public boolean addTransaction(Transaction t);
}
