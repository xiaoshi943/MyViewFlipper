package com.dialog;

import java.lang.reflect.Field;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class TabHomeDialog extends Dialog{

	private Context mContext;
	private View mContentView;
	private ImageView close;
	private Button upgrade;
	private ListView listView;

	public TabHomeDialog(Context context) {
		super(context);
		mContext = context;
	}

	public TabHomeDialog(Context context, int themeResId) {
		super(context, themeResId);
		mContext = context;
	}

	/**
	 * 设置布局
	 */
	@Override
	public void setContentView(View layout){
		super.setContentView(layout);

		mContentView = layout;
		if(mContentView != null){
			initView();
		}
	}

	private void initView(){
		listView = (ListView) mContentView.findViewById(R.id.tabhome_dialog_list);
		close = (ImageView) mContentView.findViewById(R.id.tabhome_dialog_close);
		upgrade = (Button) mContentView.findViewById(R.id.tabhome_dialog_upgrade);
		close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TabHomeDialog.this.dismiss();
			}

		});
	}

	/**
	 * 设置点击事件监听
	 * @param onClickListener
	 */
	public void setPositiveButtonListener(View.OnClickListener onClickListener){
		if(upgrade != null){
			upgrade.setOnClickListener(onClickListener);
		}
	}

	public void setDialogSize(int width , int height){
		
		//填充整个屏幕
		/*WindowManager.LayoutParams params = this.getWindow()  
				.getAttributes();  
		params.width = width;  
		params.height = height;  
		this.getWindow().setAttributes(params); */
		

		WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metric = new DisplayMetrics();  
		wm.getDefaultDisplay().getMetrics(metric);  
		int wHeight = metric.heightPixels;   // 屏幕高度（像素） 
		int wWidth = metric.widthPixels;     // 屏幕宽度（像素）  
		
		WindowManager.LayoutParams params = this.getWindow()  
				.getAttributes();  
		if(width == LayoutParams.MATCH_PARENT && height == LayoutParams.MATCH_PARENT){
			params.width = wWidth;  
			params.height = wHeight - getStatusBarHeight(mContext);  
		}
		else{
			params.width = width;  
			params.height = height;  
		}
		this.getWindow().setAttributes(params); 
	}
	
	public static int getStatusBarHeight(Context context){
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, statusBarHeight = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			statusBarHeight = context.getResources().getDimensionPixelSize(x);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return statusBarHeight;
	}


	/**
	 * 设置Dialog的内容，内容的布局为一个ListView
	 * datas必须是一个List<String>对象
	 */
	public void setDialogMessage(Activity context , List<String> datas){
		DialogAdapter adapter = new DialogAdapter( context ,  datas);
		if(listView != null){
			listView.setAdapter(adapter);
		}

	}


	/**
	 * 
	 * @param context
	 * @param datas
	 * @return
	 */
	public DialogAdapter getDialogAdapter(Activity context , List<String> datas){
		return new DialogAdapter( context ,  datas);
	}


	class DialogAdapter extends BaseAdapter{
		private Activity context ;
		private List<String> datas;
		private View layout;

		public DialogAdapter(Activity context , List<String> datas){
			this.context = context;
			this.datas = datas;
		}

		public DialogAdapter(Activity context , List<String> datas , View layout){
			this.context = context;
			this.datas = datas;
			this.layout = layout;
		}

		@Override
		public int getCount() {
			if(datas != null){
				return datas.size();
			}
			return 0;
		}

		@Override
		public Object getItem(int position) {
			if(datas != null){
				return datas.get(position);
			}
			return null;
		}

		@Override
		public long getItemId(int position) {
			if(datas != null){
				return position;
			}
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = layout;
			if(convertView == null){
				convertView = context.getLayoutInflater().inflate(R.layout.tabhome_dialog_item_layout, null);

				TextView content = (TextView) convertView.findViewById(R.id.tabhome_dialog_item_content);
				content.setText(datas.get(position));
			}

			return convertView;
		}
	}
}

/**
 * 自定义ListView
 * @author jinyi.shi
 *
 */
class LimitMaxHeightListView extends ListView{
	private int mMaxHeight = 400; //最大高度

	public LimitMaxHeightListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public LimitMaxHeightListView(Context context , AttributeSet attrs) {
		super(context , attrs);
		mMaxHeight = attrs.getAttributeIntValue(null, "maxHeight", 400);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		if (heightMode == MeasureSpec.EXACTLY) {
			heightSize = heightSize <= mMaxHeight ? heightSize
					: (int) mMaxHeight;
		}

		if (heightMode == MeasureSpec.UNSPECIFIED) {
			heightSize = heightSize <= mMaxHeight ? heightSize
					: (int) mMaxHeight;
		}
		if (heightMode == MeasureSpec.AT_MOST) {
			heightSize = heightSize <= mMaxHeight ? heightSize
					: (int) mMaxHeight;
		}
		int maxHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
				heightMode);
		super.onMeasure(widthMeasureSpec, maxHeightMeasureSpec);
	}
}
