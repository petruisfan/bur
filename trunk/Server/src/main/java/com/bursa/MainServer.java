package com.bursa;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import com.bursa.server.Server;

public class MainServer {

	public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry started.");
            
            Server obj = new Server();
            Naming.rebind("//localhost/HelloServer",obj);
            System.out.println("Server bound in rmi registry");
            
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
