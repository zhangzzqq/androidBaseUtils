package com.example.imagebitmaptest;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import java.io.File;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imagebitmaptest.utils.dialog.ProgressDialog;
import com.example.imagebitmaptest.utils.dialog.StyledDialog;
import com.example.imagebitmaptest.utils.dialog.ThinkDriveProgressDialog;
import com.example.imagebitmaptest.utils.dialog.base.BaseActivity;
import com.example.imagebitmaptest.utils.dialog.interfaces.MyDialogListener;
import com.example.imagebitmaptest.utils.image.BitMapUtils;
import com.example.imagebitmaptest.utils.Constant;
import com.example.imagebitmaptest.utils.image.DataUtility;
import com.example.imagebitmaptest.utils.image.FileCacheUtil;
import com.example.imagebitmaptest.utils.file.FileUtils;

import static com.example.imagebitmaptest.utils.Constant.XYD_PHOTO_FILE_PATH;

public class MainActivity extends BaseActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView tv;
    private Button btn_text;
    Bitmap mBitmap;
    private static final String TAG = "MainActivity";
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StyledDialog.init(this);
        initView();


//        Dialog gloablDialog= StyledDialog.buildLoading( "加载中...").show();
////                startActivity(new Intent(getActivity(),demo1.class));
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                        StyledDialog.dismissLoading();
//                StyledDialog.dismiss(gloablDialog);
//            }
//        },3000);



//        StyledDialog.buildMdAlert("title", "msg",  new MyDialogListener() {
//            @Override
//            public void onFirst() {
//                showToast("onFirst");
//            }
//
//            @Override
//            public void onSecond() {
//                showToast("onSecond");
//            }
//
//            @Override
//            public void onThird() {
//                showToast("onThird");
//            }
//
//        })
//                .setBtnSize(20)
//                .setBtnText("i","b","3")
//                .show();



//        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,TestActivity.class);
//                startActivity(intent);
//            }
//        });


        ProgressDialog progressDialog = new ProgressDialog();
        progressDialog.init(MainActivity.this,"努力加载中");

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.start();//开始加载
                //     progressDialog.cancel();//结束加载

            }
        });


    }

    private void initView() {
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        btnSave = (Button) findViewById(R.id.btn_save);
        tv = (TextView) findViewById(R.id.tv);
        btn_text = (Button) findViewById(R.id.btn_text);


    }


    public void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

}