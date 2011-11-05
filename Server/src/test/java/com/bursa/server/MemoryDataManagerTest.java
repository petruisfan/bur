package com.bursa.server;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.bursa.interfata.Offer;
import com.bursa.interfata.Offer.OfferType;
import com.bursa.interfata.Transaction;

public class MemoryDataManagerTest {
	MemoryDataManager dm;
	
	@Before
	public void setUp() {
		dm = new MemoryDataManager();
	}
	
	@Test
	public void testGetShares() {
		Offer share1 = new Offer(OfferType.BUY, "name", 10, 3);
		Offer share2 = new Offer(OfferType.BUY, "asda", 44, 9);
		Offer share3 = new Offer(OfferType.SELL, "valies", 10, 3);
		Offer share4 = new Offer(OfferType.BUY, "company", 10, 3);
		
		dm.addShare(share1, 10);
		dm.addShare(share2, 10);
		dm.addShare(share3, 10);
		dm.addShare(share4, 10);
		
		ArrayList<Offer> result = dm.getShares(OfferType.BUY);
		
		
		assertEquals(result.size(),3);
		
		assertEquals(result.get(0),share1);
		assertEquals(result.get(1),share2);
		assertEquals(result.get(2),share4);
	}
	
	@Test
	public void testGetSharesNull() {
		ArrayList<Offer> result = dm.getShares(OfferType.BUY);
		
		assertEquals(result.size(),0);
	}
	
	@Test
	public void testGetTransactions() {
		Transaction tran = null;

		for (int i=0;i<17;i++) {
			tran = new Transaction(i+23, 24, "aaa", 23, 54);
			dm.addTransaction(tran);
		}
		
		ArrayList<Transaction> result = dm.getTransactions(15);
		
		assertEquals(result.size(),15);

		for (int i=0; i<15; i++) {
			Transaction t = result.get(i);
			assertEquals(t.getSellerId(),39-i);
		}
	}
	
	@Test
	public void testGetTransactionNull() {
		ArrayList<Transaction> result = dm.getTransactions(15);
		
		assertEquals(result.size(),0);
	}
}
