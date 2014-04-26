package com.example.smartrecyclev2.fragment;

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
		
		final float[] points = new float[1];
		points[0] = -1f;
		
		pointHelper.setOnPointGetReturn(new EventListener<float[]>(){
			@Override
			public void perform(float[] args) {
				// TODO Auto-generated method stub
				points[0] = args[0];
				new TextViewManager(MainActivity.mDrawer,R.id.point).changeHint(Float.toString(points[0])+" pts");
				int cost = GiftListFragment.getDefaultFavGift().getCost();
				new TextViewManager(MainActivity.mDrawer,R.id.point_remain).changeHint(""+(int) (points[0]-cost)+ " pts");
			}
		});
		
		pointHelper.tryGetPoint(MainActivity.user.loginID);
		
		new ButtonManager(MainActivity.mDrawer,R.id.bnt_gift_suggest).changeText(GiftListFragment.getDefaultFavGift().getTitle());
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
