package com.example.myviewflipper;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

public class TestActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try{
			System.out.println("try1=================");
			throwExcetion();
			System.out.println("try2=================");
			//return;
		}catch(Exception e){
			System.out.println("catch=================");
		}finally{
			System.out.println("finally=================");
		}
		
		System.out.println("last=================");
		
		String caheDir = this.getCacheDir() + "volley";
		System.out.println("caheDir:"+caheDir);
		
		
		SharedPreferences sharePreference = getSharedPreferences("myPreferences", MODE_PRIVATE);
		String time = sharePreference.getString("time", null);
		Editor editor = sharePreference.edit();
		editor.putString("time", "2016");
		editor.commit();
	}
	
	private void throwExcetion() throws Exception{
		System.out.println("throwExcetion=================");
	}

}
