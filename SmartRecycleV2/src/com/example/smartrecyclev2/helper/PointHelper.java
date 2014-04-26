package com.example.smartrecyclev2.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.smartrecyclev2.EventListener;

public class PointHelper {

	private EventListener<float[]> onPointGetReturn;
	private EventListener<String> onPointAddReturn;
	private EventListener<String> onPointMinusReturn;
	
	public void setOnPointGetReturn(EventListener<float[]> onPointGetReturn) {
		this.onPointGetReturn = onPointGetReturn;
	}

	public void setOnPointAddReturn(EventListener<String> onPointAddReturn) {
		this.onPointAddReturn = onPointAddReturn;
	}

	public void setOnPointMinusReturn(EventListener<String> onPointMinusReturn) {
		this.onPointMinusReturn = onPointMinusReturn;
	}

	public String id;
	public float point;
	
	boolean getFlag = false;
	public void tryGetPoint(String id){
		getFlag = true;
		
		//TODO
	}
	
	boolean addFlag = false;
	public void tryAddPoint(String id, float point){
		addFlag = true;
		
		//TODO
	}
	
	boolean minusFlag = false;
	public void tryMinusPoint(String id, float point){
		minusFlag = true;
		
		//TODO
	}
	
	class PointProcess implements Runnable{
		@Override
		public void run() {
			URL url;
			try {
				//TODO set up URL
				if(getFlag){
					
				}else if(addFlag){
					
				}else if(minusFlag){
				
				}
				
				url = new URL("");
				
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				
				connection.setDoInput(true); 
		        connection.setDoOutput(true); 
				connection.connect();
			 
				connection.getOutputStream().flush(); 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection 
		          .getInputStream())); 
				
				//TODO
				
				
				if(getFlag){
					getFlag = false;
					onPointGetReturn.perform(new float[1]);
				}else if(addFlag){
					addFlag=false;
					onPointAddReturn.perform(null);
				}else if(minusFlag){
					minusFlag=false;
					onPointMinusReturn.perform(null);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
		}
	}
}
