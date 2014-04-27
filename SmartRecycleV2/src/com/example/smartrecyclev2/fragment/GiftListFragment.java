package com.example.smartrecyclev2.fragment;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.adapter.GiftAdapter;
import com.example.smartrecyclev2.adapter.GiftAdapter.OnGiftSelectedListener;
import com.example.smartrecyclev2.model.Gift;

public class GiftListFragment extends AbstractFragment{
	private static List<Gift> d_giftList;
	public static List<Gift> getDefaultGiftList() {
		if(d_giftList==null){
			d_giftList = new ArrayList<Gift>();
			
			for (int i=0; i<10; i++) {
				Gift item = new Gift();
				item.setCost((i+1)*50);
				item.setTitle("LOL RP Card #"+i);
				item.setTargetFlag(false);
				d_giftList.add(item);
			}
		}
		return d_giftList;
	}
	public static Gift getDefaultFavGift(){
		return getDefaultGiftList().get(0);
	}
	
	private List<Gift> giftList;
	private GridView result_list;
	private GiftAdapter adapter;
	

	public GiftListFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_gift_list);
		setUI();
	}

	@Override
	protected void setUI() {
		result_list = (GridView) MainActivity.mDrawer.findViewById(R.id.result_list);
		
		initGiftList();
		
		adapter = new GiftAdapter(MainActivity.mDrawer.getContext(), 
				giftList, new OnGiftSelectedListener(){

			@Override
			public void onGiftSelected(View view, int position) {
				adapter.bookmarkGift(position);
			}});
		
		result_list.setAdapter(adapter);
		
		result_list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				MainActivity.mainFragment = new GiftDetailFragment(position);
			}});
	}
	
	private void initGiftList(){
		giftList = new ArrayList<Gift>();
		
		for (int i=0; i<10; i++) {
			Gift item = new Gift();
			item.setCost((i+1)*50);
			item.setTitle("Coupon #"+i);
			item.setTargetFlag(false);
			giftList.add(item);
		}
	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
