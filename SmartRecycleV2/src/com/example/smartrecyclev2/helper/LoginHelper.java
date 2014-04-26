package com.example.smartrecyclev2.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

import com.example.smartrecyclev2.EventListener;

public class LoginHelper {
	public EventListener<String> onLoginReturn;
	public EventListener onLoginfail;
	public void setOnLoginReturn(EventListener<String> onLoginReturn) {
		this.onLoginReturn = onLoginReturn;
	}
	
	public void setOnLoginfail(EventListener onLoginfail) {
		this.onLoginfail = onLoginfail;
	}

	String url;
	String id;
	String password;
	public boolean isLoaggedIn = false;
	
	public void tryLogin(String url, String id, String password){
		this.id = id;
		this.password = password;
		this.url = url;
		Thread loginThread = new Thread(new LoginProcess());
		loginThread.start();
	}
	
	class LoginProcess implements Runnable{
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
		 
				onLoginReturn.perform(in.readLine());
		      
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				onLoginfail.perform(null);
			}
		}
	}
}
