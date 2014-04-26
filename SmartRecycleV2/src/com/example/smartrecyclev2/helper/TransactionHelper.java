package com.example.smartrecyclev2.helper;

import com.example.smartrecyclev2.EventListener;

public class TransactionHelper {
	private EventListener<String> onTransactionMade;
	
	public void tryMakeTransaction(String id, String type,int amount){
		
	}

	public void setOnTransactionMade(EventListener<String> onTransactionMade) {
		this.onTransactionMade = onTransactionMade;
	}
}
