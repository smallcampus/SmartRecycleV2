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

public class LoginFragment extends AbstractFragment{
	

	public LoginFragment(){
		MainActivity.mDrawer.setContentView(R.layout.fragment_login);
		
		final EditText id = (EditText) MainActivity.mDrawer.findViewById(R.id.username);
		final EditText pw = (EditText) MainActivity.mDrawer.findViewById(R.id.password);
		
		Button LoginBtn = (Button) MainActivity.mDrawer.findViewById(R.id.login);
		
		LoginBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				
				MainActivity.login.setOnLoginReturn(new EventListener<String>(){
					@Override
					public void perform(String args) {
						if(args.equals("true")){
							Toast.makeText(MainActivity.mDrawer.getContext(), "Login success", Toast.LENGTH_LONG).show();
							MainActivity.mainFragment = new CustomerMainFragment();							
						}else{
							Toast.makeText(MainActivity.mDrawer.getContext(), "Login fail", Toast.LENGTH_LONG).show();
						}
					}
				});
				
				//TODO
				MainActivity.login.tryLogin("", id.getText().toString(), pw.getText().toString());				

			}
		});
		
		((Button) MainActivity.mDrawer.findViewById(R.id.register)).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.mDrawer.getContext(), "Register Completed", Toast.LENGTH_LONG).show();
				MainActivity.mainFragment = new CustomerMainFragment();
			}
		});
	}
	
	@Override
	protected void setUI() {

	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_login;
	}

}