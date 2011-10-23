package com.bursa.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.bursa.interfata.StockServer;
import com.bursa.interfata.Share;
import com.bursa.interfata.Share.OfferType;
import com.bursa.interfata.Transaction;

public class Server extends UnicastRemoteObject implements StockServer{
    private static final long serialVersionUID = 1536781879666827889L;

    // Intermediate layer for comunicating with the data objects.
    private DataManager dm;
    
    public Server() throws RemoteException {
        super();
        dm = new MemoryDataManager();
    }

    public String hello() throws RemoteException {
        return "Hello";
    }

	public boolean postShare(Share share) throws RemoteException {
		boolean result = dm.addShare(share);
		return result;
	}

	public ArrayList<Share> getShares(OfferType type) throws RemoteException {
		ArrayList<Share> result = dm.getShares(type);
		return result;
	}

	public boolean modifyShare(Share share) throws RemoteException {
		boolean result = dm.modifyShare(share);
		return result;
	}

	public ArrayList<Transaction> getTransaction() throws RemoteException {
		ArrayList<Transaction> result = dm.getTransactions();
		return result;
	}
    
}
