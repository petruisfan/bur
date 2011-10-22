package com.bursa.server;

import com.bursa.interfata.Share;

public class ShareIdentifier {
	private Share share;
	
	private static int id = 0;	// the id of the last share action
	private final int shareId;	// unique id for each share action

	public ShareIdentifier() {
		shareId = incrementId(); 
	}
	
	private static int incrementId(){
		return ++id;
	}
}
