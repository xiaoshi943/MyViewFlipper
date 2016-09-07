package com.example.myviewflipper;

import android.app.Activity;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyTestActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		RequestQueue mQueue = Volley.newRequestQueue(this);
		StringRequest request = new StringRequest("http://www.baidu.com" , 
				new Response.Listener<String>() {
			@Override
			public void onResponse(String response){

			} 
		} , 
		new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error){
				error.printStackTrace();
			}
		});
		
		mQueue.add(request);
		request.cancel();
	}
}
