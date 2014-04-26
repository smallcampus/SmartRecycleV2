package com.example.smartrecyclev2.fragment;


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.smartrecyclev2.Constants;
import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class LoginFragment extends AbstractFragment{
	

	public LoginFragment(){
		MainActivity.mDrawer.setContentView(R.layout.fragment_login);
	}
	
	@Override
	protected void setUI() {
		Button LoginBtn = (Button) mView.findViewById(R.id.login);
		
		LoginBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				
			}
		});
	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_login;
	}

}