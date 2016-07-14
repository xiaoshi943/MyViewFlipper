package com.nationselected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class NationSekectedActivity extends Activity{
	
	private ListView nation_selected_listview;
	private SideBar nation_selected_sidebar;
	private TextView nation_selected__key;
	private List<String> item;
	private List<String> groups = new ArrayList<String>();
	private String[] str = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nation_selected);
		
		initData();
		
		nation_selected_listview = (ListView) findViewById(R.id.nation_selected_listview);
		nation_selected_sidebar = (SideBar) findViewById(R.id.nation_selected_sidebar);
		nation_selected__key = (TextView) findViewById(R.id.nation_selected__key);
		
		NationSelectedAdapter adapter = new NationSelectedAdapter(this,groups);
		nation_selected_listview.setAdapter(adapter);
		nation_selected_sidebar.setListView(nation_selected_listview, (NationSelectedAdapter)adapter);
		nation_selected_sidebar.setTextView(nation_selected__key);
		
		/*nation_selected_listview.sett
		NationSelectedAdapter adapter = new NationSelectedAdapter();*/
	}

	private void initData() {
		for(int i=0 ; i<26 ; i++){
			groups.add(str[i]);
			groups.add("item"+i);
			
		}
	}

}
