package com.example.myviewflipper;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.data.HotelBookListItem;

public class HotelBookListTest extends Activity implements OnItemClickListener{
	
	ListView listview;
	List<HotelBookListItem> list = new ArrayList<HotelBookListItem>();
	HotelBookListAdapter adapter;
	View footerView;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hotelbook_list);
		
		for(int i = 0 ; i < 10 ; i++){
			HotelBookListItem item = new HotelBookListItem();
			item.name = "item"+i;
			if(i == 1 || i == 2 || i == 6 || i == 7){
				item.isVisible = true;
			}
			else{
				item.isVisible = false;
			}
			list.add(item);
		}
		
		//测试证明||是短路或
		String ss = null;
		if( ss == null || ss.equals("") ){
			Toast.makeText(this, "没问题", Toast.LENGTH_LONG).show();
		}
		
		
		
		adapter = new HotelBookListAdapter(this , list);
		listview = (ListView) findViewById(R.id.hotelbook_listview);

		
		
		footerView = this.getLayoutInflater().inflate(R.layout.hotelbook_list_foot, null);
		listview.addFooterView(footerView);
		listview.setOnItemClickListener(this);
		
		
		listview.setAdapter(adapter);
		
		listview.setSelection(-1);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		if(position == list.size()){
			if(adapter != null){
				//listview.smoothScrollToPosition(0);
				adapter.setOpen(true);
				listview.removeFooterView(footerView);
				adapter.notifyDataSetChanged();
				//listview.setSelection(0);
			}
		}
	}
}
