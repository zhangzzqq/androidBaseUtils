package com.example.imagebitmaptest.utils.dialog.base;

import android.support.v7.app.AppCompatActivity;

import com.example.imagebitmaptest.R;
import com.example.imagebitmaptest.utils.dialog.ThinkDriveProgressDialog;

public class BaseActivity extends AppCompatActivity {


    /**
     * 等待框
     */
    private ThinkDriveProgressDialog progressDialog = null;

    /**
     * 是否隐藏等待框
     */
    private boolean isHiddenProgressDialog = false;


    /**
     * 设置等待框状态
     *
     * @param isHide
     */
    protected void setHideProgressDialog(boolean isHide) {
        this.isHiddenProgressDialog = isHide;
    }

    /**
     * 显示等待框
     *
     * @param title
     * @param msg
     */
    protected void showProgressDialog(String title, String msg) {
        if (!isHiddenProgressDialog) {
            progressDialog = new ThinkDriveProgressDialog(BaseActivity.this);

            if (msg == null) {
                msg = getResources().getString(R.string.msg_loading);
            }
            progressDialog.setMessage(msg);
            progressDialog.show();
        }
    }

    /**
     * 隐藏等待框
     */
    protected void hiddenProgressDialog() {
        if (!isHiddenProgressDialog && progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
