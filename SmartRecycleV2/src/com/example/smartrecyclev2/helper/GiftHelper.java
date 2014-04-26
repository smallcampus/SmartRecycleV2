package com.example.smartrecyclev2.helper;

import com.example.smartrecyclev2.EventListener;
import com.example.smartrecyclev2.model.Gift;

public class GiftHelper {
	private EventListener<Gift[]> onGiftGetReturn;
	public void setOnGiftGetReturn(EventListener<Gift[]> onGiftGetReturn) {
		this.onGiftGetReturn = onGiftGetReturn;
	}
	
	private EventListener<Gift> onFavGiftGetReturn;
	public void setOnFavGiftGetReturn(EventListener<Gift> eventListener) {
		this.onFavGiftGetReturn = eventListener;
	}
	
	boolean getFlag = false;
	public void tryGetGifts(){
		getFlag = true;
	
	}
	
	boolean getFavFlag = false;
	public void tryGetFavGift(String id){
		getFavFlag = true;
		
	}
	
	
}
