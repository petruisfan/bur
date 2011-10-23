package com.bursa.interfata;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.security.auth.login.CredentialException;

public interface Connector extends Remote{
	public String hello() throws RemoteException;
	
	/**
	 * Connect to the stock server using a user & pass.
	 * @param user
	 * @param pass
	 * @return
	 * @throws RemoteException
	 * @throws CredentialException
	 */
	public StockServer connect(String user, String pass) throws RemoteException, CredentialException;
	
	/**
	 * Disconnect from the server.
	 * @return
	 * @throws RemoteException
	 */
    public boolean disconnect() throws RemoteException;
}
