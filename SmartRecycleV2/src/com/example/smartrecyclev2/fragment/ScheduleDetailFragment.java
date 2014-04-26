package com.example.smartrecyclev2.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.model.Schedule;

public class ScheduleDetailFragment extends AbstractFragment{
	
	private LinearLayout phone_bar, company_bar;
	
	private Schedule item;

	public ScheduleDetailFragment(int i) {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_detail);
		item=ScheduleListFragment.getDefaultScheduleList().get(i);
		setUI();
		
	}

	@Override
	protected void setUI() {
		phone_bar = (LinearLayout) MainActivity.mDrawer.findViewById(R.id.phone_bar);
		phone_bar.setVisibility(View.VISIBLE);
		company_bar = (LinearLayout) MainActivity.mDrawer.findViewById(R.id.company_bar);
		company_bar.setVisibility(View.VISIBLE);
		
		((EditText)MainActivity.mDrawer.findViewById(R.id.time_start)).setText(item.getStartTime());
		((EditText)MainActivity.mDrawer.findViewById(R.id.time_end)).setText(item.getEndTime());
		((EditText)MainActivity.mDrawer.findViewById(R.id.address)).setText(item.getLocation());
		((EditText)MainActivity.mDrawer.findViewById(R.id.company)).setText(item.getCompany());
		((EditText)MainActivity.mDrawer.findViewById(R.id.phone)).setText(item.getPhone());
		
		((Button) MainActivity.mDrawer.findViewById(R.id.btn_more)).setOnClickListener(
				new OnClickListener(){

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
