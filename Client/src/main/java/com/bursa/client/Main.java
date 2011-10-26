package com.bursa.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bursa.client.gui.MainFrame;

public class Main {
	
	public static void main(String[] args) {
		if (args.length == 0 || args[0].equals("-g")) {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		} else if (args[0].equals("-c")){
			Main m = new Main();
			m.startCommandMode();
		}
	}

	/**
	 * Read commands from terminals.
	 */
	private void startCommandMode() {
		System.out.println("This is the terminal mode. Press h for help");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true){
				System.out.print(" >$ " );
				String option = input.readLine();

				// eclipse throws an error.(java 7)
				// if compiled with maven it works!
				switch (option.toLowerCase()) {
					case "s":
						this.printSharesForSale();
						break;
					case "w":
						this.printWantedShare();
						break;
					case "a":
						this.addSharesToServer();
						break;
					case "t":
						this.printLast15Transactions();
					case "h": 
						printHelpMenu(); 
						break;
					case "q":
						System.out.println("Will now exit!");
						Thread.sleep(500);
						System.exit(0);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printSharesForSale() {
		System.out.println("Shares for sale: TODO");
	}

	private void printWantedShare() {
		System.out.println("Shares other people want to buy: TODO");
	}
	
	private void addSharesToServer() {
		System.out.print("Buy or sell shares? ");
		System.out.print("Company: ");
		System.out.print("Number of shares: ");
		System.out.print("Value of one share: ");
		
		System.out.println("Done! TODO");
	}

	private void printLast15Transactions() {
		System.out.println("Last 15 transactions: TODO");
	}

	private void printHelpMenu() {
		System.out.println(" s - list shares for sale." );
		System.out.println(" w - list wanted share.");
		System.out.println(" a - add shares to server");
		System.out.println(" h - print this help menu.");
		System.out.println(" q - quit.");
	}
}
