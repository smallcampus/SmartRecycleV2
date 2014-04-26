package com.example.smartrecyclev2.fragment;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class SearchFragment extends AbstractFragment{
	
	private Button search;

	public SearchFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_search);
		setUI();
	}

	@Override
	protected void setUI() {
		search = (Button) MainActivity.mDrawer.findViewById(R.id.search);
		search.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				new ScheduleListFragment();
			}});
	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
