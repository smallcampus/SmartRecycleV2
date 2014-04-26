package com.example.smartrecyclev2.helper;

import com.example.smartrecyclev2.EventListener;

public class CodeHelper {

	private EventListener<String> onCodeUsed;
	
	public void setOnCodeUsed(EventListener<String> onCodeUsed) {
		this.onCodeUsed = onCodeUsed;
	}

	public void tryUseCode(String userId, String code){
		
	}
}
