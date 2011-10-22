package com.bursa.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.bursa.interfata.Interfata;
import com.bursa.interfata.Share;
import com.bursa.interfata.Transaction;

public class Server extends UnicastRemoteObject implements Interfata{

    private static final long serialVersionUID = 1536781879666827889L;

    public Server() throws RemoteException {
        super();
    }

    public String hello() throws RemoteException {
        return "Hello";
    }

	public boolean postShare(Share share) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Share> getShares(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modifyShare(Share share) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Transaction> getTransaction() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
    
}
