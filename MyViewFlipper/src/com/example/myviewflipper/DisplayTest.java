package com.example.myviewflipper;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayTest extends Activity{
	
	private TextView test1;
	private TextView test2;
	private TextView test3;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.display_test);
		
		test1 = (TextView) findViewById(R.id.dispaly_1);
		test2 = (TextView) findViewById(R.id.dispaly_2);
		test3 = (TextView) findViewById(R.id.dispaly_3);
		
		findViewById(R.id.dotted).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		
		
		 // 方法1 Android获得屏幕的宽和高    
        WindowManager windowManager = getWindowManager();    
        Display display = windowManager.getDefaultDisplay();    
        int screenWidth = screenWidth = display.getWidth();    
        int screenHeight = screenHeight = display.getHeight();
        test1.setText(screenWidth+"x"+screenHeight);
        
     // 方法2（点数，用长和宽分别乘上密度）   
        DisplayMetrics dm = new DisplayMetrics();  
        getWindowManager().getDefaultDisplay().getMetrics(dm);  
        float width=dm.widthPixels*dm.density;   
        float height=dm.heightPixels*dm.density;   
        test2.setText(width+"x"+height);
        
     // 方法3(宽高) 
        DisplayMetrics dm2 = new DisplayMetrics();  
        getWindowManager().getDefaultDisplay().getMetrics(dm2);  
        float width2=dm2.widthPixels;   
        float height2=dm2.heightPixels;   
        String str = width2+"x"+height2;
        //test3.setText(width2+"x"+height2);
        
        //测试
        String test = "红色";
        SpannableString spanString = new SpannableString(test);  
	    ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);  
	    spanString.setSpan(span, 0, test.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  
	    
	    str = str.replace("x", spanString);
	    test3.append(str);
	    test3.append(spanString);
	}
}
