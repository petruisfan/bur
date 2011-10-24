package com.bursa.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.security.auth.login.CredentialException;

import com.bursa.interfata.Connector;
import com.bursa.interfata.StockServer;
import com.bursa.server.objectIdentifier.UserIdentifier;

/**
 * Use this to connect to the server and receive a server thread.
 * @author petre
 */
public class MainServer extends UnicastRemoteObject implements Connector {
	private static final long serialVersionUID = 8671385262117139390L;

	private DataManager dm;
	private int id;
	
	
	public MainServer() throws RemoteException {
		super();
		dm = new MemoryDataManager();
	}
	
	public String hello() throws RemoteException {
        return "Hello";
    }
	
	public StockServer connect(String user, String pass) throws RemoteException, CredentialException {
		this.verifyCredentials(user,pass);
		
		ComunicationServer result = new ComunicationServer(dm,id);
		
		return result;
	}

	private void verifyCredentials(String user, String pass) throws CredentialException {
		if (user == null || pass == null) {
			throw new CredentialException(); 
		}
		
		int id = UserIdentifier.verifyCredentials(user, pass);
		
		if (id == -1) {
			throw new CredentialException();
		}
		this.id = id;
	}

	public boolean disconnect() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
