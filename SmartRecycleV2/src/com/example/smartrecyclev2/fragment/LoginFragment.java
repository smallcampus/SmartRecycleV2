package com.example.smartrecyclev2.fragment;


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartrecyclev2.Constants;
import com.example.smartrecyclev2.EventListener;
import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class LoginFragment{
	

	public LoginFragment(boolean isWorker){
		MainActivity.mDrawer.setContentView(R.layout.fragment_login);
		
		final boolean _isWorker = isWorker;
		final EditText id = (EditText) MainActivity.mDrawer.findViewById(R.id.username);
		final EditText pw = (EditText) MainActivity.mDrawer.findViewById(R.id.password);
		
		Button LoginBtn = (Button) MainActivity.mDrawer.findViewById(R.id.login);
		
		LoginBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				
				//MainActivity.login.setOnLoginReturn(new EventListener<String>(){
				//	@Override
				//	public void perform(String args) {
				//		if(args.equals("true")){
							MainActivity.user.loginID = id.getText().toString();
							//Toast.makeText(MainActivity.mDrawer.getContext(), "Login success", Toast.LENGTH_LONG).show();
							if(MainActivity.user.loginID.startsWith("M")){
								new RecordFragment();
							}else{
								new CustomerMainFragment();
							}
				//		}else{
							//Toast.makeText(MainActivity.mDrawer.getContext(), "Login fail", Toast.LENGTH_LONG).show();
				//		}
				//	}
				//});
				
				//TODO
				//MainActivity.login.tryLogin("", id.getText().toString(), pw.getText().toString());				

			}
		});
		
		((Button) MainActivity.mDrawer.findViewById(R.id.register)).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				MainActivity.user.loginID = id.getText().toString();
				MainActivity.login.isLoaggedIn = true;
				
				Toast.makeText(MainActivity.mDrawer.getContext(), "Register Completed", Toast.LENGTH_LONG).show();
//				MainActivity.mainFragment = new CustomerMainFragment();
				MainActivity.mainFragment = new GiftListFragment();
			}
		});
	}

}