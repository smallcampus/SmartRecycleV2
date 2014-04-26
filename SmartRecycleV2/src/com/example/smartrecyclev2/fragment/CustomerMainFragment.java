package com.example.smartrecyclev2.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.helper.GiftHelper;
import com.example.smartrecyclev2.helper.PointHelper;

public class CustomerMainFragment{

	public CustomerMainFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_main_customer);
		
		final TextView point = (TextView) MainActivity.mDrawer.findViewById(R.id.point);
		final TextView remain = (TextView) MainActivity.mDrawer.findViewById(R.id.point_remain);
		
		point.setText(""+MainActivity.point+" points");
		
		remain.setText(""+(-MainActivity.point+GiftListFragment.getDefaultFavGift().getCost()) + " points");
		
		Button submit = ((Button) MainActivity.mDrawer.findViewById(R.id.bnt_gift_suggest));
		submit.setText(GiftListFragment.getDefaultFavGift().getTitle());
		submit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new GiftListFragment();
			}
		});

		((Button) MainActivity.mDrawer.findViewById(R.id.btn_get_point)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new CodeFragment(false);
			}
			
		});
	}

}
