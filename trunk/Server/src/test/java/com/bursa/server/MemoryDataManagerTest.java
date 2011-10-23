package com.bursa.server;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.bursa.interfata.Share;
import com.bursa.interfata.Share.OfferType;
import com.bursa.interfata.Transaction;

public class MemoryDataManagerTest {
	MemoryDataManager dm;
	
	@Before
	public void setUp() {
		dm = new MemoryDataManager();
	}
	
	@Test
	public void testGetShares() {
		Share share1 = new Share(OfferType.BUY, "name", 10, 3);
		Share share2 = new Share(OfferType.BUY, "asda", 44, 9);
		Share share3 = new Share(OfferType.SELL, "valies", 10, 3);
		Share share4 = new Share(OfferType.BUY, "company", 10, 3);
		
		dm.addShare(share1);
		dm.addShare(share2);
		dm.addShare(share3);
		dm.addShare(share4);
		
		ArrayList<Share> result = dm.getShares(OfferType.BUY);
		
		
		assertEquals(result.size(),3);
		
		assertEquals(result.get(0),share1);
		assertEquals(result.get(1),share2);
		assertEquals(result.get(2),share4);
	}
	
	@Test
	public void testGetSharesNull() {
		ArrayList<Share> result = dm.getShares(OfferType.BUY);
		
		assertEquals(result.size(),0);
	}
	
	@Test
	public void testGetTransactions() {
		Transaction tran = null;

		for (int i=0;i<17;i++) {
			tran = new Transaction(i+23, 24, "aaa", 23, 54);
			dm.addTransaction(tran);
		}
		
		ArrayList<Transaction> result = dm.getTransactions();
		
		assertEquals(result.size(),15);

		for (int i=0; i<15; i++) {
			Transaction t = result.get(i);
			assertEquals(t.getSellerId(),39-i);
		}
	}
	
}
