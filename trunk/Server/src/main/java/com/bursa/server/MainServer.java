package com.bursa.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.security.auth.login.CredentialException;

import com.bursa.interfata.Connector;
import com.bursa.interfata.StockServer;

/**
 * Use this to connect to the server and receive a server thread.
 * @author petre
 */
public class MainServer extends UnicastRemoteObject implements Connector {
	private static final long serialVersionUID = 8671385262117139390L;

	private DataManager dm;
	
	
	public MainServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String hello() throws RemoteException {
        return "Hello";
    }
	
	public StockServer connect(String user, String pass) throws RemoteException, CredentialException {
		this.verifyCredentials(user,pass);
		
		dm = new MemoryDataManager();
		// TODO add some threads!!!
		Server result = new Server(dm);
		
		return result;
	}

	private void verifyCredentials(String user, String pass) throws CredentialException {
		if (user == null || pass == null) {
			throw new CredentialException(); 
		}
	}

	public boolean disconnect() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
