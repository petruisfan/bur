package com.bursa.interfata;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface Interfata extends Remote{
    public String hello() throws RemoteException;
    
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
    public ArrayList<Share> getShares(String type) throws RemoteException;
    
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
