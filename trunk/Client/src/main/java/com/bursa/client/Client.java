package com.bursa.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.bursa.interfata.Interfata;

public class Client{
    
    public static void main(String[] args) {
        try {
            Interfata obj = (Interfata)Naming.lookup("rmi://localhost/HelloServer");
            System.out.println(obj.hello());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        
    }
}
