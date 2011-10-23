package com.bursa.server;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.bursa.interfata.Share;
import com.bursa.interfata.Share.OfferType;

public class MemorydataManagerTest {
	MemoryDataManager dm;
	
	@Before
	public void setUp() {
		dm = new MemoryDataManager();
	}
	
	@Test
	public void testGetShares() {
		Share share1 = new Share(OfferType.BUY, null, 10, 3);
		Share share2 = new Share(OfferType.BUY, "", 44, 9);
		Share share3 = new Share(OfferType.SELL, null, 10, 3);
		
		dm.addShare(share1);
		dm.addShare(share2);
		dm.addShare(share3);
		
		ArrayList<Share> result = dm.getShares(OfferType.BUY);
		
		assertEquals(result.size(),2);
		assertEquals(result.get(0),share1);
		assertEquals(result.get(1),share2);
	}
	
	@Test
	public void testGetSharesNull() {
		ArrayList<Share> result = dm.getShares(OfferType.BUY);
		
		assertEquals(result.size(),0);
	}
}
