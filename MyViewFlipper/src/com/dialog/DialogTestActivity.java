package com.dialog;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.myviewflipper.R;

public class DialogTestActivity extends Activity{
		
	PopupWindow popu;
	ImageView img ;
	
		@Override
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			img = (ImageView) findViewById(R.id.imageView1);
			
			View popuLayout = this.getLayoutInflater().inflate(R.layout.fragment1, null);
			/*popu = new PopupWindow(popuLayout ,LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			//popu.setContentView(popuLayout);
			
			img.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					popu.showAtLocation(img, Gravity.CENTER,10,10);
					
				}
			});
			
			//
			TextView txt = (TextView) popuLayout.findViewById(R.id.fragment1_text);
			txt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					popu.dismiss();
				}
			});*/
			
			//======推荐====================
			/*View layout = this.getLayoutInflater().inflate(R.layout.tabhome_dialog_main, null);
			final Dialog d = new Dialog(this , R.style.dialog);
			d.setContentView(layout);
			d.show();
			//填充整个屏幕
			WindowManager.LayoutParams params = d.getWindow()  
                    .getAttributes();  
            params.width = LayoutParams.MATCH_PARENT;  
            params.height = LayoutParams.MATCH_PARENT;  
            d.getWindow().setAttributes(params); */
            
	        //---------自定义封装----------------------------------
			List<String> list = new ArrayList<String>();
			for(int i =0 ; i<10 ; i++){
				String ss = ".发掘的三分球我今儿阿斯蒂芬奇偶去我家饿哦\n";
				ss = ss.replace("\n", "");
				list.add(i+ss);
			}
			
			TabHomeDialog d = new TabHomeDialog(this , R.style.dialog);
			View layout = getLayoutInflater().inflate(R.layout.tabhome_dialog_main, null);
			d.setContentView(layout);
			d.setDialogMessage(this, list);
			d.show();
			d.setDialogSize(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            d.setPositiveButtonListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					//TODO
					View dd = v;
					Rect outRect = new Rect();  
					DialogTestActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);  
					int appH = outRect.height();
					int appW = outRect.width();
					int apptop = outRect.top;
					
					Rect dRect = new Rect();  
					DialogTestActivity.this.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(outRect);  
					int dH = dRect.height();
					int dW = dRect.width();
				}
			});
			
			//============================
			/*AlertDialog.Builder builder = new AlertDialog.Builder(this);
			AlertDialog ad = builder.create();
			ad.setTitle(null);
			ad.setView(popuLayout, 0, 0, 0, 0);  
			
			WindowManager.LayoutParams params = ad.getWindow()  
                    .getAttributes();  
            params.width = LayoutParams.MATCH_PARENT;  
            params.height = LayoutParams.MATCH_PARENT;  
            ad.getWindow().setAttributes(params); 
            
			ad.show();*/
		}

}
