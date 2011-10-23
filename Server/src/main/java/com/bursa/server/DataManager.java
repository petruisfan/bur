package com.bursa.server;

import java.util.ArrayList;

import com.bursa.interfata.Share;
import com.bursa.interfata.Share.OfferType;
import com.bursa.interfata.Transaction;

public interface DataManager {

	/**
	 * Add a share object to the list of shares.
	 * @param share
	 * @return
	 */
	public boolean addShare(Share share) ;

	/**
	 * Get the list of shares of a certain type: sell or buy.
	 * @param type
	 * @return
	 */
	public ArrayList<Share> getShares(OfferType type) ;

	/**
	 * Modify an existing share.
	 * @param share
	 * @return
	 */
	public boolean modifyShare(Share share) ;

	/**
	 * Get a list of the last 15 transactions;
	 * @return
	 */
	public ArrayList<Transaction> getTransactions() ;
	
	/**
	 * Add a transcation to the list of transactions;
	 * @param t
	 * @return
	 */
	public boolean addTransaction(Transaction t);
}
