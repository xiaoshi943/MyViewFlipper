package com.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myviewflipper.R;

public class FragmentTwo extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater , ViewGroup container , 
			Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.fragment2, null);
		
		return view;
	}
}