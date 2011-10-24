package com.bursa.server.objectIdentifier;

public class UserIdentifier {

	// name password id
	private static final String[][] credentials = {
		{"jon", "tiger", "12"},
		{"helen","pass", "13"},
		{"admin", "1234", "14"},
		{"guest", "guest", "15"}
	};

	public static int verifyCredentials(String user, String pass) {
		int result = -1;
		
		for (int i=0;i<credentials.length; i++) {
			if (credentials[i][0].equals(user)) {
				if (credentials[i][1].equals(pass)) {
					return Integer.parseInt(credentials[i][2]);
				}
			}
		}
		return result;
	}
}
