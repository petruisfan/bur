package com.bursa.server.objectIdentifier;

import com.bursa.interfata.Transaction;

public class TransactionIdentifier {
	private static int id = 0;			// the id of the last transaction
	private final int transactionId;	// the unique transaction id
	
	private Transaction transaction;
	
	public TransactionIdentifier (Transaction t) {
		this.transaction = t;
		transactionId = incrementId(); 
	}
	
	private static int incrementId(){
		return ++id;
	}
	
	public int getId() {
		return transactionId;
	}
}
