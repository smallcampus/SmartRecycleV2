package com.example.smartrecyclev2.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.model.Schedule;

public class CustomerMainFragment {
	
	private LinearLayout gift_point_bar, function_bar;
	private ScrollView schedule_suggest_card;

	public CustomerMainFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_main_customer);
		
		Schedule item = new Schedule();
		item.setStartTime("8:00");
		item.setEndTime("10:00");
		item.setLocation("HKUST");
		((EditText) MainActivity.mDrawer.findViewById(R.id.time_start)).setText(item.getStartTime());
		((EditText) MainActivity.mDrawer.findViewById(R.id.time_end)).setText(item.getEndTime());
		((EditText) MainActivity.mDrawer.findViewById(R.id.address)).setText(item.getLocation());

		if (MainActivity.user.role == 0) {
			//customer view
//			Schedule item=ScheduleListFragment.getDefaultScheduleList().get(0);
//			Schedule item = new Schedule();
//			item.setStartTime("8:00");
//			item.setEndTime("10:00");
//			item.setLocation("HKUST");
//			((EditText) MainActivity.mDrawer.findViewById(R.id.time_start)).setText(item.getStartTime());
//			((EditText) MainActivity.mDrawer.findViewById(R.id.time_end)).setText(item.getEndTime());
//			((EditText) MainActivity.mDrawer.findViewById(R.id.address)).setText(item.getLocation());
			
			final TextView point = (TextView) MainActivity.mDrawer
					.findViewById(R.id.point);
			final TextView remain = (TextView) MainActivity.mDrawer
					.findViewById(R.id.point_remain);

			point.setText("You have " + MainActivity.point + " " + MainActivity.mDrawer.getResources().getString(R.string.point));

			remain.setText(""
					+ (-MainActivity.point + GiftListFragment
							.getDefaultFavGift().getCost()) + " " + MainActivity.mDrawer.getResources().getString(R.string.to_go_for));

			Button submit = ((Button) MainActivity.mDrawer
					.findViewById(R.id.bnt_gift_suggest));
			submit.setText(GiftListFragment.getDefaultFavGift().getTitle());
			submit.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					new GiftListFragment();
				}
			});

			((Button) MainActivity.mDrawer.findViewById(R.id.btn_get_point))
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							new CodeFragment(false);
						}

					});
		}else {
			// worker view
			gift_point_bar = (LinearLayout) MainActivity.mDrawer.findViewById(R.id.gift_point_bar);
			gift_point_bar.setVisibility(View.GONE);
			
			function_bar = (LinearLayout) MainActivity.mDrawer.findViewById(R.id.function_bar);
			function_bar.setVisibility(View.VISIBLE);
			
			((Button) MainActivity.mDrawer.findViewById(R.id.btn_get_point)).setVisibility(View.GONE);
			
			
			schedule_suggest_card = (ScrollView) MainActivity.mDrawer.findViewById(R.id.schedule_suggest_scroll);
			schedule_suggest_card.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		
			((Button) MainActivity.mDrawer.findViewById(R.id.btn_start_sell)).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					new RecordFragment();
				}});
		}
	}

}
