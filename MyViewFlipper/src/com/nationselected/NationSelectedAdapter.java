package com.nationselected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class NationSelectedAdapter extends BaseAdapter implements LetterSelectedListener{
	
	private Context context;
	private List<String> groups = new ArrayList<String>(); 
	private Map<String ,Integer> tmpMap = new HashMap<String,Integer>();

	public NationSelectedAdapter(Context context , List<String> groups){
		this.context =context;
		this.groups = groups;
	}
	
	
	@Override
	public int getCount() {
		if(groups.size() > 0){
			return groups.size();
		}
		return 0;
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
	public View getView(int position, View view, ViewGroup parent) {
		View tagLayout = LayoutInflater.from(context).inflate(R.layout.nation_selected_listview_tag, null);
		TextView item_tag_view = (TextView) tagLayout.findViewById(R.id.nation_selected_item_tag);
		TextView item_view = (TextView) tagLayout.findViewById(R.id.nation_selected_item);
		
		String item = groups.get(position);
		if(item.length() < 2){
			item_tag_view.setText(item);
			item_tag_view.setVisibility(View.VISIBLE);
		}
		else{
			item_view.setText(item);
			item_view.setVisibility(View.VISIBLE);
		}
		
		return tagLayout;
	}


	@Override
	public int getPositionForSection(String section) {
		
		/*if(tmpMap.get(section) != null){
			return (int)tmpMap.get(section) ;
		}*/
		
		
		for (int i = 0; i < groups.size(); i++) {
			String l = groups.get(i);
			if (l != null && l.length() >= 1) {
				char firstChar = l.toUpperCase().charAt(0);
				if (String.valueOf(firstChar).equals(section)) {
					return i;
				}
			}
		}
		return -1;
	}

}
