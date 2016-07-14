package com.example.myviewflipper;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class ConfigChangesLifecycle extends Activity{
	
	@Override
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		Log.w("tag", "tag"+" onCreate()");
	}
	
	@Override
	protected void onRestart (){
		super.onRestart();
		Log.w("tag", "tag"+" onRestart()");
	}
	
	@Override
	protected void onStart (){
		super.onStart();
		Log.w("tag", "tag"+" onStart()");
	}
	
	@Override
	protected void onRestoreInstanceState (Bundle savedInstanceState){
		super.onRestoreInstanceState(savedInstanceState);
		Log.w("tag", "tag"+" onRestoreInstanceState()");
	}
	
	@Override
	protected void onResume (){
		super.onResume();
		Log.w("tag", "tag"+" onResume()");
	}
	
	@Override
	protected void onSaveInstanceState (Bundle outState){
		super.onSaveInstanceState(outState);
		Log.w("tag", "tag"+" onSaveInstanceState()");
	}
	
	@Override
	protected void onPause (){
		super.onPause();
		Log.w("tag", "tag"+" onPause()");
	}
	
	@Override
	protected void onStop (){
		super.onStop();
		Log.w("tag", "tag"+" onStop()");
	}
	
	@Override
	protected void onDestroy (){
		super.onDestroy();
		Log.w("tag", "tag"+" onDestroy()");
	}
	
	
	@Override
	public void onConfigurationChanged (Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		Log.w("tag", "tag"+" onConfigurationChanged()");
		
	}
}
