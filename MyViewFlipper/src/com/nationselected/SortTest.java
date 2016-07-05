package com.nationselected;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class SortTest  extends Activity{
	
	private List<String> list = new ArrayList<String>();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nation_selected_listview_item);
		TextView txt = (TextView) findViewById(R.id.nation_selected_item_name);
		
		list.add("dggdh");
		list.add("hgdhb");
		list.add("afghdg");
		list.add("llirnf");
		list.add("oonja");
		list.add("ceidn");
		list.add("daicje");
		list.add("dkioan");
		list.add("erev");
		//排序前
		for(String str : list){
			txt.append(str + "   ");
		}
		
		//排序后
		 MyComparator mc = new MyComparator() ;  
		 Collections.sort(list, mc) ; 
		 txt.append("\n");
		 txt.append("\n");
		 for(String str : list){
				txt.append(str + "   ");
			}
		 
		 //插入数据
		 list.add("A");
		 list.add("B");
		 list.add("C");
		 list.add("D");
		 list.add("E");
		 list.add("F");
		 list.add("G");
		 list.add("H");
		 list.add("I");
		 list.add("J");
		 list.add("K");
		// MyComparator mc2 = new MyComparator() ;  
		 Collections.sort(list, mc) ; 
		 txt.append("\n");
		 txt.append("\n");
		 for(String str : list){
				txt.append(str + "   ");
			}
		
		 
		 /*this.openFileInput(name);
		 this.openFileOutput(name, mode);*/
	}

}

class MyComparator implements Comparator{  
    
    public int compare(Object o1,Object o2) {  
    	String str1 = o1.toString().substring(0, 1).toLowerCase();
    	String str2 = o2.toString().substring(0, 1).toLowerCase();
    	int result = str1.compareTo(str2);
    	if(result == 0){
    		if(o1.toString().length() < o2.toString().length()){
    			return -1;
    		}
    		else if(o1.toString().length() > o2.toString().length()){
        		return 1;
        	}
        	else{
        		return 0;
        	}
    	}
    	
       return  result;
       }

}  
