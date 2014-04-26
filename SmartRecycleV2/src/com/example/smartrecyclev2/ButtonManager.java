package com.example.smartrecyclev2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ButtonManager{

	private View view;
	private int id;

	public ButtonManager(View view, int id){
		this.view = view;
		this.id = id;
	}

	public void changeText(String text){
		//create a message from global message pool and send it
		handler.obtainMessage(0, text).sendToTarget();
	}

	private final Handler handler = new Handler(Looper.getMainLooper()) {
		@Override
		public void handleMessage(Message msg){
			String hint = (String) msg.obj;
			final Button text = (Button) view.findViewById(id);

			text.setText(hint);
		}
	};

}