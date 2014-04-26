package com.example.smartrecyclev2.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class RecordFragment extends AbstractFragment{
	
	

	public RecordFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_record);
		
		((Button) MainActivity.mDrawer.findViewById(R.id.btn_end)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				new CodeFragment(true);
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
