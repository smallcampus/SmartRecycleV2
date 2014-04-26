package com.example.smartrecyclev2.helper;

import com.example.smartrecyclev2.EventListener;
import com.example.smartrecyclev2.model.Gift;

public class GiftHelper {
	private EventListener<Gift[]> onGiftGetReturn;
	public void setOnGiftGetReturn(EventListener<Gift[]> onGiftGetReturn) {
		this.onGiftGetReturn = onGiftGetReturn;
	}
	
	void tryGetGifts(){
		
	}
}
