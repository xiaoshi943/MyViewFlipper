package com.example.myviewflipper;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnGestureListener{

	private GestureDetector gestureDetector;
	private	ViewFlipper	flipper;
	private	LinearLayout	layout;
	private	Context	context;
	private	int	now	=	0;
	private	int	pictureCounts	=	6;	//因为只有六张图片滑动,所以定义为6
	
	static Handler handler;
	private Timer timer;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        
        handler = new Handler(){
        	 @Override
             public void handleMessage(Message msg) {
        		 switch(msg.what){
	        		 case 0x100 :
	        			 changeImg();
	        			 break;
        		 }
        	 }
        };
    }

    /**
     * 初始化UI和一些属性
     * */
    private	void	init(){
    	gestureDetector=new GestureDetector(this);
    	flipper	=	(ViewFlipper) findViewById(R.id.viewFlipper1);
    	flipper.setDisplayedChild(now);	//	开始先显示第一张
    	layout	=	(LinearLayout) findViewById(R.id.linearLayout);   	
    	generatePageControl();
    	
    	timer = new Timer();
    	timer.schedule(new TimerTask(){
			@Override
			public void run() {
				if(handler == null){
					return;
				}
				handler.sendEmptyMessage(0x100);
			}
    		
    	},0, 1000);
    }
    
    /**
     * 初始化滑动小白点
     * */
    private void generatePageControl() {
    	layout.removeAllViews();

        for (int i = 0; i < pictureCounts; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setPadding(0, 0, 6, 0);
                if (now  == i) {
                        imageView.setImageResource(R.drawable.page00);//选中的圆点图片下面的反之
                } else {
                        imageView.setImageResource(R.drawable.page01);
                }
                this.layout.addView(imageView);
        }
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e2.getX() - e1.getX() > 120) {	// 从左向右滑动（左进右出）
			//加载图片进入时的动画资源
			Animation rInAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.push_right_in); 	// 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
			//加载图片退出时的动画资源
			Animation rOutAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

			//设置图片进入动画
			flipper.setInAnimation(rInAnim);
			//设置图片退出动画
			flipper.setOutAnimation(rOutAnim);
			flipper.showPrevious();
			now--;
			if(now	<	0){
				now	=	pictureCounts	-	1;
			}
			generatePageControl();
			return true;
		} else if (e2.getX() - e1.getX() < -120) {		 // 从右向左滑动（右进左出）
			
			changeImg();
			
			return true;
		}
		return true;
	}
	
	/*
	 *图片从从右向左滑动（右进左出）
	 *因为有两个地方使用，所以单独提出来 */
	protected void changeImg(){
		Animation lInAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.push_left_in);		// 向左滑动左侧进入的渐变效果（alpha 0.1  -> 1.0）
		Animation lOutAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.push_left_out); 	// 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

		flipper.setInAnimation(lInAnim);
		flipper.setOutAnimation(lOutAnim);
		flipper.showNext();
		now++;
		if(now	>	pictureCounts	-	1){
			now	=	0;
		}
		generatePageControl();
	}
	

	@Override
	public void onLongPress(MotionEvent e) {
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		Toast.makeText(this, "你点重美女:"	+	now, Toast.LENGTH_SHORT).show();
		return false;
	}
	
}
