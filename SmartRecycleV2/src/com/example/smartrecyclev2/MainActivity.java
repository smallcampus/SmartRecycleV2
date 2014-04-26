package com.example.smartrecyclev2;

import net.simonvt.menudrawer.MenuDrawer;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.smartrecyclev2.fragment.AbstractFragment;
import com.example.smartrecyclev2.fragment.CustomerMainFragment;
import com.example.smartrecyclev2.fragment.GiftListFragment;
import com.example.smartrecyclev2.fragment.LoginFragment;
import com.example.smartrecyclev2.fragment.ScheduleListFragment;
import com.example.smartrecyclev2.fragment.SearchFragment;
import com.example.smartrecyclev2.helper.LoginHelper;
import com.example.smartrecyclev2.model.CompanyUser;
import com.example.smartrecyclev2.model.User;

public class MainActivity extends Activity {

	public static MenuDrawer mDrawer;
	public static User user = new User();
	public static CompanyUser cUser = new CompanyUser();
	
	public static int point = 10;
	
	public static AbstractFragment mainFragment;
	public static LoginHelper login = new LoginHelper();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        mDrawer = MenuDrawer.attach(this);
        
        mDrawer.setContentView(R.layout.fragment_login);
        mDrawer.setMenuView(R.layout.menu_user);
        
        final TextView m1 =(TextView) mDrawer.findViewById(R.id.item1);
        final TextView m2 =(TextView) mDrawer.findViewById(R.id.item2);
        final TextView m3 =(TextView) mDrawer.findViewById(R.id.item3);
        
        final OnClickListener menuOnClickListener = new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(arg0.equals(m1)){
					new CustomerMainFragment();
				}else if(arg0.equals(m2)){
					if (user.role==1)
					new ScheduleListFragment();
					else
						new SearchFragment();
				}else if(arg0.equals(m3)){
					new GiftListFragment();
				}
			}
        	
        };
        
        m1.setOnClickListener(menuOnClickListener);
        m2.setOnClickListener(menuOnClickListener);
        m3.setOnClickListener(menuOnClickListener);
        
        new LoginFragment(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}