package com.example.smartrecyclev2;

import net.simonvt.menudrawer.MenuDrawer;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.smartrecyclev2.fragment.AbstractFragment;
import com.example.smartrecyclev2.fragment.LoginFragment;
import com.example.smartrecyclev2.helper.LoginHelper;
import com.example.smartrecyclev2.model.CompanyUser;
import com.example.smartrecyclev2.model.User;

public class MainActivity extends Activity {

	public static MenuDrawer mDrawer;
	public static User user = new User();
	public static CompanyUser cUser = new CompanyUser();
	
	public static int point = 400;
	
	public static AbstractFragment mainFragment;
	public static LoginHelper login = new LoginHelper();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        mDrawer = MenuDrawer.attach(this);
        
        mDrawer.setContentView(R.layout.fragment_login);
        mDrawer.setMenuView(R.layout.menu_user);
        
        mainFragment = new LoginFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}