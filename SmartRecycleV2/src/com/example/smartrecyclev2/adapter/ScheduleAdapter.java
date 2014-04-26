package com.example.smartrecyclev2.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.model.Schedule;

public class ScheduleAdapter extends BaseAdapter{
	private List<Schedule> schedules;
	private Context context;
	private OnScheduleSelectedListener mOnScheduleSelectedListener;
	
	
	
	public ScheduleAdapter(Context context, List<Schedule> schedules,
			OnScheduleSelectedListener mOnScheduleSelectedListener) {
		super();
		this.schedules = schedules;
		this.context = context;
		this.mOnScheduleSelectedListener = mOnScheduleSelectedListener;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return schedules.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View view, ViewGroup arg2) {
		View rowView = view; 
        ViewHolder holder;
        if(rowView==null){  
            holder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              rowView = inflater.inflate(R.layout.schedule_card_item, arg2, false); 
              holder.map = (ImageView)rowView.findViewById(R.id.map);
              holder.startTime=(EditText)rowView.findViewById(R.id.time_start);
              holder.endTime=(EditText)rowView.findViewById(R.id.time_end);
              holder.location=(EditText)rowView.findViewById(R.id.address);
              holder.company=(EditText)rowView.findViewById(R.id.company);
              holder.phone = (EditText)rowView.findViewById(R.id.phone);
              holder.type = (EditText)rowView.findViewById(R.id.type);
              rowView.setTag(holder);
        }
        else{
            holder=(ViewHolder) rowView.getTag();
        }
        
        holder.map.setVisibility(View.GONE);
        holder.startTime.setText(schedules.get(position).getStartTime());
        holder.endTime.setText(schedules.get(position).getEndTime());
        holder.location.setText(schedules.get(position).getLocation());
        holder.phone.setText(schedules.get(position).getPhone());
        holder.company.setText(schedules.get(position).getCompany());
        
//        holder.startTime.(false);
//        holder.endTime.setEnabled(false);
//        holder.location.setEnabled(false);
//        holder.phone.setEnabled(false);
//        holder.company.setEnabled(false);
        
        
		return rowView;
	}
	
	

	public interface OnScheduleSelectedListener{
		public void onScheduleSelected(View view, int position);
	}
	
	private class ViewHolder {
		public ImageView map;
		public EditText startTime;
		public EditText endTime;
		public EditText company;
		public EditText phone;
		public EditText location;
		public EditText type;
	}
}
