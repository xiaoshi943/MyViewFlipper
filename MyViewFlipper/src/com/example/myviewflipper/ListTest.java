package com.example.myviewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class ListTest extends Activity{
	
	private HorizontalListView  horizontalListView ;
	
	GridView gridView;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listtest);
		horizontalListView = (HorizontalListView)findViewById(R.id.listtest_listview);
		
		String[] arr = {"aaaa","aaaa","aaaa","aaaa","aaaa","aaaa","aaaa","aaaa","aaaa"
				,"aaaa","aaaa","aaaa","aaaa","aaaa","aaaa"};
		
		gridView = (GridView)findViewById(R.id.listtest_gridview);
				
				
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listtest_item,arr);
		horizontalListView.setAdapter(adapter);
	}
}
