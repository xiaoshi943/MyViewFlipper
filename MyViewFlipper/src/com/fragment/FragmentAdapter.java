package com.fragment;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;




public class FragmentAdapter extends FragmentPagerAdapter{

	private List<Fragment> fragmentList;
	
	public FragmentAdapter(FragmentManager fm , List<Fragment> list){
		super(fm);
		this.fragmentList = list;
	}
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragmentList.size();
	}

}
