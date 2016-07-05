package com.example.myviewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.widget.Rotate3DAnimation;

public class Rotate3DAnimationTest extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rotate_3d_animation);
		ImageView  image = (ImageView) findViewById(R.id.image);
		//获取屏幕 宽高
		WindowManager  wm = (WindowManager)getSystemService(WINDOW_SERVICE);
		Display  display = wm.getDefaultDisplay();
		DisplayMetrics  metrice = new  DisplayMetrics();
		display.getMetrics(metrice);
		//设置动画
		image.setAnimation(new  Rotate3DAnimation(metrice.xdpi/2 , metrice.ydpi/2 , 3500));

	}
}
