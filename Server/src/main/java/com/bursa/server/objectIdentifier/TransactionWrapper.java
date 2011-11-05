package com.bursa.server.objectIdentifier;

import com.bursa.interfata.Transaction;

public class TransactionWrapper {
	private static int id = 0;			// the id of the last transaction
	private final int transactionId;	// the unique transaction id
	
	private Transaction transaction;
	
	public TransactionWrapper (Transaction t) {
		this.transaction = t;
		transactionId = ++id; 
		if (id > Integer.MAX_VALUE-5) {
			System.out.println("Id reseting");
		}
	}
	
	public int getId() {
		return transactionId;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}
}
