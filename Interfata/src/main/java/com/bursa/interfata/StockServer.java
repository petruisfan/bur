package com.bursa.interfata;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.bursa.interfata.Share.OfferType;


public interface StockServer extends Remote{
    /**
     * Post a new share transaction (selling/buying).
     * @param type
     * @param company
     * @param value
     * @param shareNumber
     * @return
     * @throws RemoteException
     */
    public boolean postShare(Share share) throws RemoteException;
    
    /**
     * Get a list of the current share actions.
     * @param type	buy/sell
     * @return
     * @throws RemoteException
     */
    public ArrayList<Share> getShares(OfferType type) throws RemoteException;
    
    /**
     * Modify the share object on the server
     * @param share
     * @return
     * @throws RemoteException
     */
    public boolean modifyShare(Share share) throws RemoteException;
    
    /**
     * Return a list of the last 15 transactions
     * @return
     * @throws RemoteException
     */
    public ArrayList<Transaction> getTransaction() throws RemoteException; 
}
