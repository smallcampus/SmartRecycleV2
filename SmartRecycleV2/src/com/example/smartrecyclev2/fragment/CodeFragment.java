package com.example.smartrecyclev2.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;

public class CodeFragment{
	
	static int code = 46332214;

	CodeFragment(){}
	
	public CodeFragment(boolean isWorker) {

		MainActivity.mDrawer.setContentView(R.layout.fragment_code);
	
		if(isWorker){
			((TextView) MainActivity.mDrawer.findViewById(R.id.code_title))
			.setText(MainActivity.mDrawer.getResources().getString(R.string.output_code_title));
			((EditText) MainActivity.mDrawer.findViewById(R.id.code)).setText(Integer.toString(code++));
			((Button) MainActivity.mDrawer.findViewById(R.id.btn_submit)).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					MainActivity.mainFragment = new RecordFragment();
				}
				
			});
		}else{
			((Button) MainActivity.mDrawer.findViewById(R.id.btn_submit)).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(((EditText) MainActivity.mDrawer.findViewById(R.id.code)).getText().toString().startsWith("4")){
						Toast.makeText(MainActivity.mDrawer.getContext(), "10 points has been added", Toast.LENGTH_LONG).show();
						MainActivity.point +=10;
						new CustomerMainFragment();
					}else{
						Toast.makeText(MainActivity.mDrawer.getContext(), "Invalid code", Toast.LENGTH_LONG).show();
					}
					
				}
			});
			((EditText) MainActivity.mDrawer.findViewById(R.id.code)).setText("");
		}
	}
	
}
