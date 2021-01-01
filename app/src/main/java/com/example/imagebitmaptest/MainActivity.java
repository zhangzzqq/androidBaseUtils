package com.example.imagebitmaptest;

import android.content.Context;
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

import com.example.imagebitmaptest.utils.dialog.ThinkDriveProgressDialog;
import com.example.imagebitmaptest.utils.dialog.base.BaseActivity;
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
        initView();
//        showProgressDialog(null,null);
//       new Handler().postDelayed(new Runnable() {
//           @Override
//           public void run() {
//               runOnUiThread(new Runnable() {
//                   @Override
//                   public void run() {
//                       hiddenProgressDialog();
//                   }
//               });
//           }
//       },5000);
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



}