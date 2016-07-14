package com.nationselected;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myviewflipper.R;

public class SideBar extends View {
	private String[] l;
	private LetterSelectedListener sectionIndexter = null;
	private ListView list;
	private TextView mDialogText;
	private Bitmap mbitmap;
	private int type = 1;
	private int color = 0xFF757575;// xff007AFF;
	private View head;
	private Context context;

	public SideBar(Context context) {
		super(context);
		init(context);
	}

	public SideBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		this.context = context;
		l = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
				"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	}

	public SideBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public void setLetterList(String[] l) {
		this.l = l;
		this.invalidate();
	}

	public void setListView(ListView _list, LetterSelectedListener adapter) {
		list = _list;
		sectionIndexter = adapter;
	}

	public void setTextView(TextView mDialogText) {
		this.mDialogText = mDialogText;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		super.onTouchEvent(event);
		int i = (int) event.getY();

		int idx = i / (getMeasuredHeight() / l.length);
		if (idx >= l.length) {
			idx = l.length - 1;
		} else if (idx < 0) {
			idx = 0;
		}
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
			}
			setBackgroundResource(R.drawable.scrollbar_bg);
			if (mDialogText == null) {
				return false;
			}
			mDialogText.setVisibility(View.VISIBLE);
			/*
			 * if (idx == 0) { mDialogText.setText("热门"); } else {
			 */
			mDialogText.setText(l[idx]);
			// }
			if (sectionIndexter == null) {
				sectionIndexter = (LetterSelectedListener) list.getAdapter();
			}
			int position = sectionIndexter.getPositionForSection(l[idx]);

			if (position == -1) {
				return true;
			}
			list.setSelection(position);
		} else {
			mDialogText.setVisibility(View.INVISIBLE);
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {

			setBackgroundDrawable(new ColorDrawable(0x00000000));
		}
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);

		paint.setTextSize(DensityUtil.sp2px(context, 9));
		paint.setStyle(Style.FILL);
		paint.setTextAlign(Paint.Align.CENTER);
		float widthCenter = getMeasuredWidth() / 2;
		
		
		FontMetrics fontMetrics = paint.getFontMetrics(); 
		float  fontHeight = fontMetrics.bottom - fontMetrics.top;
		
		if (l.length > 0) {
			float height = getMeasuredHeight() / l.length;
			for (int i = 0; i < l.length; i++) {
				//canvas.drawText(String.valueOf(l[i]), widthCenter, (i + 1) * height, paint);
				canvas.drawText(String.valueOf(l[i]), widthCenter, (i + 0.8f) * height, paint);
			}
		}
		this.invalidate();
		super.onDraw(canvas);
	}
}
