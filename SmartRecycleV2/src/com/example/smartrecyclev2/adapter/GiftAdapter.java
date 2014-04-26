package com.example.smartrecyclev2.adapter;

import java.util.List;
import java.util.zip.Inflater;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.smartrecyclev2.R;
import com.example.smartrecyclev2.model.Gift;

public class GiftAdapter extends BaseAdapter {

	private List<Gift> gifts;
	private Context context;
	private OnGiftSelectedListener mOnGiftSelectedListener;
	
	
	
	public GiftAdapter(Context context, List<Gift> gifts,
			OnGiftSelectedListener mOnGiftSelectedListener) {
		super();
		this.gifts = gifts;
		this.context = context;
		this.mOnGiftSelectedListener = mOnGiftSelectedListener;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return gifts.size();
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
              rowView = inflater.inflate(R.layout.gift_list_item, arg2, false);                  
              holder.base=(RelativeLayout)rowView.findViewById(R.id.base);
              holder.bookmark=(ImageView)rowView.findViewById(R.id.bookmark);
              holder.point=(TextView)rowView.findViewById(R.id.point);
              rowView.setTag(holder);
        }
        else{
            holder=(ViewHolder) rowView.getTag();
        }
        
        //base.setimage
        //if bookmarked, yellow star else hollow star
        holder.point.setText(gifts.get(position).getCost().toString()
        		+ " "+ context.getResources().getString(R.string.point));
        
        holder.bookmark.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				mOnGiftSelectedListener.onGiftSelected(v, position);
				
			}});
        
        
		return rowView;
	}
	
	public void bookmarkGift(int position){
		gifts.get(position).setTargetFlag(!gifts.get(position).isTargetFlag());
		notifyDataSetChanged();
	}

	public interface OnGiftSelectedListener{
		public void onGiftSelected(View view, int position);
	}
	
	private class ViewHolder {
		public RelativeLayout base;
		public ImageView bookmark;
		public TextView point;
	}
}
