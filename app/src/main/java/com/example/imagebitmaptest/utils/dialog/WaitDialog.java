package com.example.imagebitmaptest.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import com.example.imagebitmaptest.R;

/**
 * Description
 * Created by bing on 2015/10/10.
 */
public class WaitDialog extends Dialog {
    private TextView waitText;

    public WaitDialog(Context context) {
        super(context, R.style.WaitDialogStyle);
        setCanceledOnTouchOutside(false);
        getWindow().setGravity(Gravity.CENTER);
        setContentView(R.layout.dialog_wait_layout);
        waitText = (TextView) findViewById(R.id.tv_wait_dialog_text);
    }

    /**
     * 设置显示文字
     *
     * @param waitMsg
     */
    public void setText(CharSequence waitMsg) {
        waitText.setText(waitMsg);
    }

    /**
     * 设置文字
     *
     * @param resId
     */
    public void setText(int resId) {
        waitText.setText(resId);
    }
}
