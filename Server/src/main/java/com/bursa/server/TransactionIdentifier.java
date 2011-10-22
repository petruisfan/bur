package com.bursa.server;

import com.bursa.interfata.Transaction;

public class TransactionIdentifier {
	private static int id = 0;			// the id of the last transaction
	private final int transactionId;	// the unique transaction id
	
	private Transaction transaction;
	
	public TransactionIdentifier () {
		transactionId = incrementId(); 
	}
	
	private static int incrementId(){
		return ++id;
	}
}
