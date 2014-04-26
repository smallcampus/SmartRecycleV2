package com.example.smartrecyclev2;

import com.example.smartrecyclev2.fragment.AbstractFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//set up Fragment manager
		changeFragmentHandler = new ChangeFragmentHandler(getSupportFragmentManager());

		//TODO changeFragmentHandler.changeFragment(IntroductionFragment.id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private static ChangeFragmentHandler changeFragmentHandler; 
	public static ChangeFragmentHandler getChangeFragmentHandler(){
		return changeFragmentHandler;

	}

	public class ChangeFragmentHandler{
		private FragmentManager manager;

		public ChangeFragmentHandler(FragmentManager fragmentManager) {
			manager = fragmentManager;
		}

		public void changeFragment(int fragmentId){
			AbstractFragment fragment = null;
			switch(fragmentId){
			//TODO case IntroductionFragment.id:
			}

			FragmentTransaction transaction = manager.beginTransaction();

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack so the user can navigate back
			//TODO transaction.replace(R.id.fragment_container, fragment);
			transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();
		}
	}

}