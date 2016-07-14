package com.example.myviewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class AminTest extends Activity{
	
	private FrameLayout hotelorder_success_hongbao_sendfriend;
	private ImageView hotelorder_success_hongbao_sendfriend_flag;
	private TextView test3;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.amin_test);
		hotelorder_success_hongbao_sendfriend = (FrameLayout)
				findViewById(R.id.hotelorder_success_hongbao_sendfriend);
		hotelorder_success_hongbao_sendfriend_flag = (ImageView)
				findViewById(R.id.hotelorder_success_hongbao_sendfriend_flag);
		
		// 启动分享按钮处的一系列动画，由于使用动画集会出现卡顿现象，所以采用这种处理方式
		Animation upAnimation = AnimationUtils.loadAnimation(this, R.anim.hotel_order_slide_up_in);
		hotelorder_success_hongbao_sendfriend.startAnimation(upAnimation);
		handler.sendEmptyMessageDelayed(0, 2000);
	}

	int animCount = 0 ;
	private Handler handler =new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0){
				if(animCount<3){
					animCount++;
					final Animation ratoteAnimation = AnimationUtils.loadAnimation(AminTest.this,
							R.anim.rotate_center);
					hotelorder_success_hongbao_sendfriend_flag.startAnimation(ratoteAnimation);
					ratoteAnimation.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {
						}

						@Override
						public void onAnimationRepeat(Animation animation) {
						}

						@Override
						public void onAnimationEnd(Animation animation) {
							handler.sendEmptyMessageDelayed(0, 2000);
						}
					});
				}	
			}
		};
	};
}
