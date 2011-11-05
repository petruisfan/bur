package com.bursa.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.bursa.interfata.StockServer;
import com.bursa.interfata.Offer;
import com.bursa.interfata.Offer.OfferType;
import com.bursa.interfata.Transaction;

public class ComunicationServer extends UnicastRemoteObject implements StockServer{
    private static final long serialVersionUID = 1536781879666827889L;

    // Intermediate layer for comunicating with the data objects.
    private DataManager dm;
	private int id;
    
    public ComunicationServer(DataManager dm2, int id2) throws RemoteException {
        super();
        this.dm = dm2;
        this.id = id2;
    }

	public boolean postShare(Offer share) throws RemoteException {
		boolean result = dm.addShare(share, id);
		return result;
	}

	public ArrayList<Offer> getShares(OfferType type) throws RemoteException {
		ArrayList<Offer> result = dm.getShares(type);
		return result;
	}

	public boolean modifyShare(Offer newShare, Offer oldShare) throws RemoteException {
		boolean result = dm.modifyShare(newShare, oldShare, id);
		return result;
	}

	public ArrayList<Transaction> getTransaction(int transactionCount) throws RemoteException {
		ArrayList<Transaction> result = dm.getTransactions(transactionCount);
		return result;
	}
    
}
