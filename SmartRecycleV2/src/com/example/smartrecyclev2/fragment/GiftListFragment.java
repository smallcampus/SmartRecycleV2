package com.example.smartrecyclev2.fragment;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class GiftListFragment extends AbstractFragment{
	
	

	public GiftListFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_gift_list);
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
