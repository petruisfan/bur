package com.bursa.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.security.auth.login.CredentialException;

import com.bursa.client.gui.MainFrame;
import com.bursa.interfata.Connector;
import com.bursa.interfata.Offer;
import com.bursa.interfata.StockServer;
import com.bursa.interfata.Offer.OfferType;
import com.bursa.interfata.Transaction;

public class Main {
	private Connector RMIserver = null;
	private StockServer server = null;
	private int transactionCount = 15;

	public static void main(String[] args) {
		if (args.length == 0 || args[0].equals("-g")) {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		} 
		else if (args[0].equals("-c")){
			Main m = new Main();
			try {
				m.startCommandMode();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

	private void connect() throws MalformedURLException, RemoteException, NotBoundException {
		RMIserver = (Connector)Naming.lookup("rmi://localhost/bursa");
	}

	/**
	 * Read commands from terminals.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 * @throws IOException 
	 */
	private void startCommandMode() throws NotBoundException, MalformedURLException, RemoteException{
		this.connect();

		boolean success = false;
		String user = null, pass = null;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (!success) {
			try {
				System.out.println("user:");
				user = input.readLine();
				
				System.out.println("password:");
				pass = input.readLine();
				
				server  = RMIserver.connect(user, pass);
				success = true;
			} catch (Exception e1) {
				System.out.println("Enter credentials again.");
			}
		}

		System.out.println("This is the terminal mode. Press h for help");


		try {
			while (true){
				System.out.print(" >$ " );
				String option = input.readLine();

				switch (option.toLowerCase().charAt(0)) {
				case 's':
					this.printSharesForSale();
					break;
				case 'w':
					this.printWantedShare();
					break;
				case 'a':
					this.addSharesToServer();
					break;
				case 't':
					this.printLast15Transactions();
					break;
				case 'h': 
					printHelpMenu(); 
					break;
				case 'q':
					System.out.println("Will now exit!");
					
					Thread.sleep(500);
					
					server=null;
					RMIserver.disconnect();
					System.exit(0);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printSharesForSale() {
		System.out.println("Shares for sale:");
		
		this.listOffer(OfferType.SELL);
	}

	private void listOffer(OfferType type) {
		ArrayList<Offer> offers = null;
		try {
			offers = server.getShares(type);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for (Offer f:offers) {
			System.out.println(f);
		}
	}

	private void printWantedShare() {
		System.out.println("Shares other people want to buy:");

		this.listOffer(OfferType.BUY);
	}

	private void addSharesToServer() {
		String company, offer;
		int nr, val;
		OfferType ot = null;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Buy or sell shares? ");
			offer = input.readLine();
			
			if (offer.equals("SELL")) {
				ot = OfferType.SELL;
			} else if (offer.equals("BUY")) {
				ot = OfferType.BUY;
			}

			System.out.print("Company: ");
			company = input.readLine();
			
			System.out.print("Number of shares: ");
			nr = Integer.valueOf(input.readLine());
			
			System.out.print("Value of one share: ");
			val = Integer.valueOf(input.readLine());
			
			Offer offerObj = new Offer(ot,company,nr,val);
			
			server.postShare(offerObj);
			
			System.out.println("Done!");
			
		}catch(RemoteException r){
			System.out.println("Remote Exception");
			r.printStackTrace();
		}catch (IOException e){
			System.out.println("Input exception");
		}
	}

	private void printLast15Transactions() {
		System.out.println("Last transactions: ");
		
		ArrayList<Transaction> trans = null;
		try {
			trans = server.getTransaction(transactionCount);
			
			for (Transaction t:trans) {
				System.out.println(t);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	

	private void printHelpMenu() {
		System.out.println(" s - list shares for sale." );
		System.out.println(" t - list last 15 shares." );
		System.out.println(" w - list wanted share.");
		System.out.println(" a - add shares to server");
		System.out.println(" h - print this help menu.");
		System.out.println(" q - quit.");
	}
}
