package com.example.smartrecyclev2.fragment;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class CustomerMainFragment extends AbstractFragment{

	public CustomerMainFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_main_customer);
	}

	@Override
	protected void setUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
