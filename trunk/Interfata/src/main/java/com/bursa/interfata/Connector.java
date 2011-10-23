package com.bursa.interfata;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Connector extends Remote{
    
	public StockServer connect() throws RemoteException;
	
    public boolean disconnect() throws RemoteException;
}
