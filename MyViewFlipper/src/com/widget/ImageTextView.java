package com.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class ImageTextView extends LinearLayout{

	public ImageTextView(Context context) {
		super(context);
	}
	
	public ImageTextView(Context context , AttributeSet attrs) {
		super(context , attrs);
		int resourceId = -1;
		TypedArray typedArray = context.obtainStyledAttributes(attrs , R.styleable.ImageTextView);;
		ImageView iv = new ImageView(context);
		TextView tv = new TextView(context);
		int N = typedArray.getIndexCount();
		for(int i = 0 ; i < N ; i++){
			int attr = typedArray.getIndex(i);
			switch(attr){
			case R.styleable.ImageTextView_Oriental :
				resourceId = typedArray.getInt(R.styleable.ImageTextView_Oriental ,  0);
				this.setOrientation(resourceId == 1 ? LinearLayout.HORIZONTAL :
					 LinearLayout.VERTICAL);
				break;
			case R.styleable.ImageTextView_Text :
				resourceId = typedArray.getResourceId(R.styleable.ImageTextView_Text, 0);
				tv.setText(resourceId > 0 ? typedArray.getResources().getText(resourceId) :
					 typedArray.getString(R.styleable.ImageTextView_Text));
				break;
			case R.styleable.ImageTextView_Src :
				resourceId = typedArray.getResourceId(R.styleable.ImageTextView_Src, 0);
				iv.setImageResource(resourceId > 0 ? resourceId : R.drawable.ic_launcher);
				break;
			}
		}
		addView(iv);
		addView(tv);
		typedArray.recycle();
	}

}
