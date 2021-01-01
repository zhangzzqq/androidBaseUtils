package com.example.imagebitmaptest;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.imagebitmaptest.utils.dialog.StyledDialog;


public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        StyledDialog.init(this);


        Dialog gloablDialog= StyledDialog.buildLoading( "加载中...").show();
//                startActivity(new Intent(getActivity(),demo1.class));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                        StyledDialog.dismissLoading();
                StyledDialog.dismiss(gloablDialog);
            }
        },3000);


    }


}
