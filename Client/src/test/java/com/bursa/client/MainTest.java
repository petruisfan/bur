package com.bursa.client;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.security.auth.login.CredentialException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bursa.interfata.Connector;
import com.bursa.interfata.Offer;
import com.bursa.interfata.Offer.OfferType;
import com.bursa.interfata.StockServer;
import com.bursa.interfata.Transaction;

public class MainTest {
	private String user="jon", pass = "tiger";
	private int transactionCount = 15;
	private StockServer server  ;
	private Connector RMIserver ;
	
	
	@Before
	public void setUp() throws MalformedURLException, RemoteException, NotBoundException, CredentialException {
		RMIserver = (Connector)Naming.lookup("rmi://localhost/bursa");
		server= RMIserver.connect(user, pass);
		
	}
	
	@After
	public void tearDown() throws RemoteException {
		RMIserver.disconnect();
	}
	
	//@Test
	public void test() throws RemoteException{
		ArrayList<Transaction> trans = server.getTransaction(transactionCount);
		int save = trans.size();
		
		Offer share = new Offer(OfferType.SELL, "Oce", 4, 4);
		Offer share2 = new Offer(OfferType.BUY, "Oce", 4, 4);
		
		server.postShare(share);
		server.postShare(share2);
		
		trans = server.getTransaction(transactionCount);
		assertEquals(save+1,trans.size());
	}
	
	private void postOffer(OfferType type, String company, int number, int value) throws RemoteException {
		Offer share = new Offer(type,company, number, value);
		server.postShare(share);
	}
	
	@Test
	public void test2() throws RemoteException {
		Thread t1 = new Thread( new Runnable () {
			@Override
			public void run() {
				for (;;) {
					if (Thread.currentThread().isInterrupted())
						break;
					try {
						postOffer(OfferType.BUY, "Continental", 10, 10);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread t2 = new Thread( new Runnable () {
			@Override
			public void run() {
				for (;;) {
					if (Thread.currentThread().isInterrupted())
						break;
					try {
						postOffer(OfferType.SELL, "Continental", 10, 10);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t3 = new Thread( new Runnable () {
			@Override
			public void run() {
				for (;;) {
					if (Thread.currentThread().isInterrupted())
						break;
					try {
						server.getTransaction(transactionCount);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
	}
}
