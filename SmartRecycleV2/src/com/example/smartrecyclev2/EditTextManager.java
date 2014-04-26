package com.example.smartrecyclev2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

public class EditTextManager{

	private View view;
	private int id;

	public EditTextManager(View view, int id){
		this.view = view;
		this.id = id;
	}

	public void changeHint(String text){
		//create a message from global message pool and send it
		handler.obtainMessage(0, text).sendToTarget();
	}

	private final Handler handler = new Handler(Looper.getMainLooper()) {
		@Override
		public void handleMessage(Message msg){
			String hint = (String) msg.obj;
			final EditText hostname = (EditText) view.findViewById(id);

			hostname.setHint(hint);
		}
	};

	public void changeText(String tcpHistory) {
		textHandler.obtainMessage(0, tcpHistory).sendToTarget();
	}

	private final Handler textHandler = new Handler(Looper.getMainLooper()) {
		@Override
		public void handleMessage(Message msg){
			String text = (String) msg.obj;
			final EditText hostname = (EditText) view.findViewById(id);

			hostname.setText(text);
		}
	};
}