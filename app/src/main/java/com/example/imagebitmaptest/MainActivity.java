package com.example.imagebitmaptest;

import android.content.Context;
import android.os.Bundle;


import java.io.File;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imagebitmaptest.utils.image.BitMapUtils;
import com.example.imagebitmaptest.utils.Constant;
import com.example.imagebitmaptest.utils.image.DataUtility;
import com.example.imagebitmaptest.utils.image.FileCacheUtil;
import com.example.imagebitmaptest.utils.file.FileUtils;

import static com.example.imagebitmaptest.utils.Constant.XYD_PHOTO_FILE_PATH;

public class MainActivity extends Activity {
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

        FileCacheUtil.getInstance(MainActivity.this).write("123");
        FileUtils.saveFileToInnerStorage(MainActivity.this,
                "test", FileUtils.strToByteArray("123456"));

    }

    private void initView() {
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        btnSave = (Button) findViewById(R.id.btn_save);
        tv = (TextView) findViewById(R.id.tv);
        btn_text = (Button) findViewById(R.id.btn_text);
        //读取资源图片
        mBitmap = readBitMap();
        int width = mBitmap.getWidth() / 1;
        int height = mBitmap.getHeight() / 1;

        Log.e(TAG, "width2==" + width + ",height2==" + height);


        Log.e(TAG, "width3==" + px2dip(MainActivity.this, width) +
                ",height3==" + px2dip(MainActivity.this, height));

        /**
         *  前提 ：同一张图片
         *  已dp为单位，即225 225的图片（75dp 75dp ）一比一缩放之后，会显示为75dp 75dp大小
         *
         *  如果在xml文件中写入warp_content wrap_content ，放入225px*225px的图片，显示的会比较大
         *  (好像直接把图片像素按照dp单位展示（图片拉大会有些模糊），没有自动转化为dp再展示)
         */
        //对资源图片进行缩放
        imageView2.setImageBitmap(zoomBitmap(mBitmap, width, height));

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               String a =  FileCacheUtil.getInstance(MainActivity.this).read();
                byte[] vale = FileUtils.readFileFromInnerStorage(MainActivity.this, "test");
                String a = FileUtils.byteArrayToStr(vale);
                tv.setText(a);

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                base64ToUri(Constant.base64Url3);
            }
        });


        readBitMap(Constant.base64Url3);
//      imageView3.setImageBitmap(base64ToBitmap(Constant.base64Url3));
        int width2 = mBitmap.getWidth() / 1;
        int height2 = mBitmap.getHeight() / 1;

        Bitmap bitmap3 = base64ToBitmap(Constant.base64Url3);
        int width3 = bitmap3.getWidth() / 2;
        int height3 = bitmap3.getHeight() / 2;
        Bitmap bitmapModify = zoomBitmap(bitmap3, width3, height3);

        String base64Str = BitMapUtils.bitmapToBase64(bitmapModify);

//        ByteArrayOutputStream bbb = new ByteArrayOutputStream();
//        bitmapModify.compress(Bitmap.CompressFormat.JPEG, 100, bbb);
//        byte[] bit = bbb.toByteArray();
//        String s2 = Base64.encodeBase64String(bytes1);
//        String abc = Base64.encodeBytes(b);
//        String imgToString = Base.encodeBytes(bit);
//
//
//        bitmapModify.compress(Bitmap.CompressFormat.JPEG, 100, bbb);

        //        imageView4.setImageBitmap(bitmapModify);
//        String base64Str = DataUtility.bitmapToBase64(bitmapModify);
        imageView3.setImageBitmap(BitMapUtils.base64ToBitmap(base64Str));

//      Bitmap bitmap =  readBitMap(Constant.base64Url3);
//        imageView3.setImageBitmap(bitmap);
        imageView4.setImageBitmap(base64ToBitmap(Constant.base64Url3));
    }


    /* 读取资源图片
     * @return
     */
    private Bitmap readBitMap() {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        /*
         * 设置让解码器以最佳方式解码
         */
        opt.inPreferredConfig = Bitmap.Config.ARGB_8888;
        //下面两个字段需要组合使用
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        /*
         * 获取资源图片
         */
        InputStream is = this.getResources().openRawResource(R.drawable.mei3);
        return BitmapFactory.decodeStream(is, null, opt);
    }


    /* 缩放图片
     * @param bitmap
     * @param w
     * @param h
     * @return
     */
    public Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidht = ((float) w / width);
        float scaleHeight = ((float) h / height);
        /*
         * 通过Matrix类的postScale方法进行缩放
         */
        matrix.postScale(scaleWidht, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return newbmp;
    }

    /**
     * 放大缩小图片
     *
     * @param bitmap
     * @param w
     * @param h
     * @return
     */
    public static Bitmap zoomBitmap2(Bitmap bitmap, int w, int h) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidht = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidht, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height,
                matrix, true);
        return newbmp;
    }


    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public void base64ToUri(String base64Str) {
        String dirPath = XYD_PHOTO_FILE_PATH;
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String photoName = System.currentTimeMillis() + ".png";
        File file = new File(dir, photoName);
        try {
            DataUtility.decoderBase64File(base64Str, file);
            Log.i(TAG, "base64ToUri---------->>>" + file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /* 读取资源图片
     * @return
     */
    private void readBitMap(String result) {
//
//        InputStream is = new ByteArrayInputStream(result.getBytes());
//
//
//        BitmapFactory.Options opt = new BitmapFactory.Options();
//        /*
//         * 设置让解码器以最佳方式解码
//         */
//        opt.inPreferredConfig = Bitmap.Config.ARGB_8888;
//        //下面两个字段需要组合使用
//        opt.inPurgeable = true;
//        opt.inInputShareable = true;
//        /*
//         * 获取资源图片
//         */
//        InputStream is1 = this.getResources().openRawResource(R.drawable.mei3);
//        Bitmap bitmap1 = BitmapFactory.decodeStream(is1, null, opt);
//        imageView4.setImageBitmap(bitmap1);
//        Bitmap bitmap = BitmapFactory.decodeStream(is, null, opt);
//
//        imageView3.setImageBitmap(bitmap);
//        try {
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bitmap;
    }

    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }




}