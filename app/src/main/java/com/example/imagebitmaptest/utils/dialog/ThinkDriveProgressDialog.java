/**
 * Title: ThinkDriveProgressDialog.java
 * Description:
 * Copyright: Copyright (c) 2008
 * Company:深圳彩讯科技有限公司
 * Author 罗旭东 (hi@luoxudong.com)
 * Date 2013-8-16 下午3:54:35
 * Version 1.0
 */
package com.example.imagebitmaptest.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imagebitmaptest.R;
import com.example.imagebitmaptest.utils.Constant;


/** 
 * ClassName: ThinkDriveProgressDialog
 * Description:自定义等待框
 * Create by 罗旭东
 * Date 2013-8-16 下午3:54:35
 */
public class ThinkDriveProgressDialog extends Dialog {
    private TextView msgTextView = null;
    private ImageView imageView = null;
    
	public ThinkDriveProgressDialog(Context context) {
		super(context, R.style.ThinkDriveProgressDialog);
		setContentView(R.layout.loading_layout);
		msgTextView = (TextView)findViewById(R.id.tv_progress_dialog_msg);
		//imageView = (ImageView)findViewById(R.id.pb_progressbar);
		//AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
		//animationDrawable.start();
		//getWindow().getAttributes().gravity = Gravity.CENTER;
	}

	public ThinkDriveProgressDialog(Context context, String type) {
		super(context, R.style.ThinkDriveProgressDialog);
		if(type.equals("PROGRESSDIALOGSMALL")){
			setContentView(R.layout.loading_layout_small);
		}else {
			setContentView(R.layout.loading_layout);
		}

		msgTextView = (TextView)findViewById(R.id.tv_progress_dialog_msg);
		//imageView = (ImageView)findViewById(R.id.pb_progressbar);
		//AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
		//animationDrawable.start();
		//getWindow().getAttributes().gravity = Gravity.CENTER;
	}



	protected ThinkDriveProgressDialog(Context context, boolean cancelable,
                                       OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}
	
	public ThinkDriveProgressDialog(Context context, int theme) {
		super(context, theme);
	}
	
	public ThinkDriveProgressDialog setMessage(String msg)
	{
		if (msgTextView != null)
		{
			msgTextView.setText(msg);
		}
		return this;
	}
	
	public ThinkDriveProgressDialog setMessage(int msgResId)
	{
		if (msgTextView != null)
		{
			msgTextView.setText(msgResId);
		}
		return this;
	}
}
