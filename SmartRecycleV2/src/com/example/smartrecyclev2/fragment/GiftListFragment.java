package com.example.smartrecyclev2.fragment;

import android.widget.GridView;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class GiftListFragment extends AbstractFragment{
	
	private GridView result_list;
	

	public GiftListFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_gift_list);
	}

	@Override
	protected void setUI() {
//		result_list = (GridView) findViewById(R.id.result_list);
	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
