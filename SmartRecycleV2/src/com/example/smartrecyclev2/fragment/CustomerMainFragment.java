package com.example.smartrecyclev2.fragment;

import android.widget.EditText;

import com.example.smartrecyclev2.EditTextManager;
import com.example.smartrecyclev2.EventListener;
import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.helper.GiftHelper;
import com.example.smartrecyclev2.helper.PointHelper;
import com.example.smartrecyclev2.model.Gift;

public class CustomerMainFragment extends AbstractFragment{

	GiftHelper giftHelper = new GiftHelper();
	PointHelper pointHelper = new PointHelper();
	public CustomerMainFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_main_customer);
		
		final EditText point = (EditText) MainActivity.mDrawer.findViewById(R.id.point);
		final EditText remain = (EditText) MainActivity.mDrawer.findViewById(R.id.point_remain);
		
		final float[] points = new float[1];
		points[0] = -1f;
		
		pointHelper.setOnPointGetReturn(new EventListener<float[]>(){
			@Override
			public void perform(float[] args) {
				// TODO Auto-generated method stub
				points[0] = args[0];
				new EditTextManager(MainActivity.mDrawer,R.id.point).changeText(Float.toString(points[0])+" pts");
			}
		});
		
		giftHelper.setOnFavGiftGetReturn(new EventListener<Gift>(){
			@Override
			public void perform(Gift args) {
				//TODO
				
			}
		});
		giftHelper.tryGetFavGift(MainActivity.user.loginID);
		
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
