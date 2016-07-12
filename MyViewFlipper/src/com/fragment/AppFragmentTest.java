package com.fragment;

import java.util.List;

import org.json.JSONArray;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class AppFragmentTest extends Activity{
	private List<Fragment> fragmentList;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pageview_main);
		
		/*fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new FragmentOne());
		fragmentList.add(new FragmentTwo());
		
		FragmentAdapter adapter = new FragmentAdapter(getFragmentManager() , fragmentList);
		
		ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
		viewpager.setAdapter(adapter);*/
		
		FragmentOne fragment = new FragmentOne();
		getFragmentManager().beginTransaction()
		.replace(R.id.fragment_layout, fragment)
		.commit();
		
		
		String content  = "入住人填写说明：\\n1.预订国内酒店需要提供入住人的姓名，该姓名需与入住时所持证件完全一致；\\n2.中文姓名中不能包含英文字母。";
		content = content.replaceAll("\\\\n", "\n");
		TextView tv = (TextView) findViewById(R.id.text);
		tv.setText(content);
		
		//测试checkout
	}
}
