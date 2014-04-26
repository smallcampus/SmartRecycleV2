package com.example.smartrecyclev2.fragment;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.smartrecyclev2.MainActivity;
import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.adapter.ScheduleAdapter;
import com.example.smartrecyclev2.adapter.ScheduleAdapter.OnScheduleSelectedListener;
import com.example.smartrecyclev2.model.Schedule;

public class ScheduleListFragment extends AbstractFragment{
	private static List<Schedule> d_scheduleList;
	public static List<Schedule> getDefaultScheduleList() {
		if(d_scheduleList==null){
			d_scheduleList = new ArrayList<Schedule>();
			
			for (int i=0; i<10; i++) {
				Schedule item = new Schedule();
				item.setId(i);
				item.setStartTime((i+8)+":00");
				item.setEndTime((i+10)+":00");
				item.setLocation("HKUST");
				item.setPhone("12345678");
				item.setCompany("ABC company");
				d_scheduleList.add(item);
			}
		}
		return d_scheduleList;
	}
	
	private ListView result_list;
	private ScheduleAdapter adapter;
	
	private List<Schedule> scheduleList;

	public ScheduleListFragment() {
		super();
		MainActivity.mDrawer.setContentView(R.layout.fragment_result);
		setUI();
	}

	@Override
	protected void setUI() {
		result_list = (ListView) MainActivity.mDrawer.findViewById(R.id.result_list);
		
		init();
		
		adapter = new ScheduleAdapter(
				MainActivity.mDrawer.getContext(), scheduleList, 
				null);
		
		result_list.setAdapter(adapter);
		
		result_list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				new ScheduleDetailFragment(position);
			}});
	}
	
	public void init() {
		scheduleList = new ArrayList<Schedule>();
			
			for (int i=0; i<10; i++) {
				Schedule item = new Schedule();
				item.setId(i);
				item.setStartTime((i+8)+":00");
				item.setEndTime((i+10)+":00");
				item.setLocation("HKUST");
				item.setPhone("12345678");
				item.setCompany("ABC company");
				scheduleList.add(item);
				
				Log.d("test", "i="+i+"|time="+item.getStartTime());
			}
		
	}

	@Override
	public int getFragmentLayoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
