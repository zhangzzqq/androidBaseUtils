package com.example.imagebitmaptest.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.example.imagebitmaptest.R;

/**
 * Created by Code-Star on 2018/4/15.
 */
public class ProgressDialog {
    private Dialog progressDialog;

    public  void init(Context context, String message) {
        progressDialog = new Dialog(context, R.style.progress_dialog);
        progressDialog.setContentView(R.layout.dialog);
        progressDialog.setCancelable(true);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = (TextView) progressDialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText(message);

    }
    public void start(){
        progressDialog.show();
    }
    public void cancel(){
        progressDialog.dismiss();
    }
}
