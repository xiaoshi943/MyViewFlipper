package com.example.myviewflipper;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.data.HotelBookListItem;

public class HotelBookListAdapter  extends BaseAdapter{

	private Activity context;
	private List<HotelBookListItem> hotelBookList;
	private boolean isOpen = false;
	
	public HotelBookListAdapter(Activity context , 
			List<HotelBookListItem> hotelBookList){
		this.context = context;
		this.hotelBookList = hotelBookList;
	}
	
	@Override
	public int getCount() {
		return hotelBookList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View converView, ViewGroup parent) {
		View layout = LayoutInflater.from(context).inflate(R.layout.hotelbook_list_item, null);
		if(!isOpen && !hotelBookList.get(position).isVisible){
			layout.setVisibility(View.GONE);
			
		}
		else{
			TextView text = (TextView) layout.findViewById(R.id.hotelbook_list_name);
			text.setText(hotelBookList.get(position).name);
		}
		return layout;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
}
