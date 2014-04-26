package com.example.smartrecyclev2.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.model.Gift;

public class GiftDetailFragment extends AbstractFragment {

	private Gift item;
	
	public GiftDetailFragment(int position) {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_gift);
		item=GiftListFragment.getDefaultGiftList().get(position);
		setUI();
	}

	@Override
	protected void setUI() {
		((TextView)MainActivity.mDrawer.findViewById(R.id.point)).setText(item.getCost().toString());
		
		((Button)MainActivity.mDrawer.findViewById(R.id.btn_get)).setOnClickListener(
				
				new OnClickListener(){

			@Override
			public void onClick(View v) {
				new GiftListFragment();
				Toast.makeText(MainActivity.mDrawer.getContext(), 
						"Your will receive your reward soon!~", Toast.LENGTH_SHORT);
			}});
	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
