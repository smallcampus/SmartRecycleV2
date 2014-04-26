package com.example.smartrecyclev2.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.smartrecyclev2.EventListener;
import com.example.smartrecyclev2.helper.LoginHelper.LoginProcess;

public class SearchHelper {

	public EventListener<String> onSearchComplete;
	public EventListener onSearchFail;
	
	public String location;
	public String date;
	public String type;
	
	public void trySearch(String location, String date, String type){
		this.location = location;
		this.date = date;
		this.type = type;
		Thread searchThread = new Thread(new SearchProcess());
		searchThread.start();
	}
	

	class SearchProcess implements Runnable{
		@Override
		public void run() {
			URL url;
			try {
				//TODO set up URL
				url = new URL("");
				
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				
				connection.setDoInput(true); 
		        connection.setDoOutput(true); 
				connection.connect();
			 
				connection.getOutputStream().flush(); 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection 
		          .getInputStream())); 
		 
				onSearchComplete.perform(in.readLine());
		      
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				onSearchFail.perform(null);
			}
		}
	}
	
}
