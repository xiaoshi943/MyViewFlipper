package com.dialog;

import android.app.Dialog;
import android.content.Context;

public class MyDialog extends Dialog{

	protected MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	public MyDialog(Context context) {
		super(context);
	}
	

}
