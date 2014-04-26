package com.example.smartrecyclev2.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartrecyclev2.ButtonManager;
import com.example.smartrecyclev2.EditTextManager;
import com.example.smartrecyclev2.EventListener;
import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.TextViewManager;
import com.example.smartrecyclev2.helper.GiftHelper;
import com.example.smartrecyclev2.helper.PointHelper;
import com.example.smartrecyclev2.model.Gift;

public class CustomerMainFragment extends AbstractFragment{

	GiftHelper giftHelper = new GiftHelper();
	PointHelper pointHelper = new PointHelper();
	public CustomerMainFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_main_customer);
		
		final TextView point = (TextView) MainActivity.mDrawer.findViewById(R.id.point);
		final TextView remain = (TextView) MainActivity.mDrawer.findViewById(R.id.point_remain);
		
		point.setText(""+MainActivity.point+" points");
		
		remain.setText(""+(MainActivity.point-GiftListFragment.getDefaultFavGift().getCost()) + " points");
		
		Button submit = ((Button) MainActivity.mDrawer.findViewById(R.id.btn_submit));
		submit.setText(GiftListFragment.getDefaultFavGift().getTitle());
		submit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new GiftListFragment();
			}
		});

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
