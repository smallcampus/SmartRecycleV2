package com.example.smartrecyclev2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TextViewManager{

	private View view;
	private int id;

	public TextViewManager(View view, int id){
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
			final TextView text = (TextView) view.findViewById(id);

			text.setHint(hint);
		}
	};

}