package com.fragment;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class AppFragmentTest extends Activity{
	private List<Fragment> fragmentList;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pageview_main);
		int version=0;
		try {
			String packageName = getPackageName();
			version = getPackageManager().getPackageInfo(packageName, 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		AlertDialog.Builder dialog = new Builder(this);
		dialog.setTitle("试试");
		dialog.setMessage("可否？"+version);
		dialog.create().show();
		
		//gggadfa
		
		//gggadfa
		
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
		//一样一样
		//冲突
	}
}
