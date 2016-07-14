package com.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class Rotate3DAnimation extends  Animation{
	private  float  centerX;
	private  float  centerY;
	//定义动画的持续时间
	private  int  duration;
	private  Camera  camera = new  Camera();

	public  Rotate3DAnimation(float  x , float  y , int  duration){
		this.centerX = x;
		this.centerY = y;
		this.duration = duration;
	}
	@Override
	public  void  initialize(int  width , int  height , int  parentWidth , int  parentHeight){
		super.initialize(width , height , parentWidth , parentHeight);
		//设置动画的持续时间
		setDuration(duration);
		//设置动画结束后效果保留
		setFillAfter(true);
		setInterpolator(new  LinearInterpolator());
	}

	/*该方法的interpolatedTime代表抽象的动画持续时间，不管动画的实际时间多长，		 *	interpolatedTime总是从0到1变化。
	 *Transformation参数代表对目标组件所做的改变
	 */
	@Override
	protected  void  applyTransformation(float  interpolatedTime , Transformation  t){
		
		Log.w("my", "interpolatedTime:"+interpolatedTime);
		
		camera.save();
		//根据intentpolatedTime时间来控制X,Y,Z上的偏移
		camera.translate(100.0f - 100.0f*interpolatedTime , 
						150.0f*interpolatedTime - 150.0f , 
						80.0f - 80.0f*interpolatedTime);
		//根据interpolatedTime时间在Y轴上旋转不同的角度
		camera.rotateY(360*(interpolatedTime));
		//根据interpolatedTime时间在X轴上旋转不同的角度
		camera.rotateX(360*(interpolatedTime));
		//获取Transformation参数的Matrix对象
		Matrix  matrix = t.getMatrix();
		camera.getMatrix(matrix);
		matrix.preTranslate(-centerX , -centerY);
		matrix.postTranslate(centerX , centerY);
		camera.restore();
	}
}

