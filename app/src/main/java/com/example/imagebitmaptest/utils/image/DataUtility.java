package com.example.imagebitmaptest.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

import sun.misc.BASE64Decoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.imagebitmaptest.utils.Constant.XYD_PHOTO_FILE_PATH;


/**
 * package: com.framework.utilities
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 2017/2/16 上午11:42
 * desc:
 */

public class DataUtility {

    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    /* 图片质量 */
    public static final int PHOTO_QUALITY = 10;
    /* 缩略图质量 */
    public static final int THUMBNAIL_QUALITY = 5;
    private static final String TAG ="DataUtility";

    /**
    /** 合成的图片 Bitmap */
    private static Bitmap bitmap;

    public static String getCurrentTime() {
        return fmt.format(new Date());
    }

    public static String getCurrentDate() {
        return format.format(new Date());
    }

    public static String bitmapString(String photoPath) {
        String result = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(photoPath);
            Bitmap bitmap = BitmapFactory.decodeStream(fis);
            result = bitmapToBase64(bitmap);
            if (bitmap != null) bitmap.recycle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 把图片路径先转为Bitmap，然后再将Bitmap转换为Base64字符串
     *
     * @param photoPath 图片路径
     * @param type 类型：1.原图；2.缩略图
     * @return
     */
    public static String bitmapString(String photoPath, int type) {
        String result = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(photoPath);
            if (type == 1) {
                Bitmap bitmap = BitmapFactory.decodeStream(fis);
                result = bitmapToBase64(bitmap);
                if (bitmap != null) bitmap.recycle();
            } else if (type == 2) {
                result = compressPicture(photoPath);
            } else if (type == 3) {
                Bitmap bitmap = BitmapFactory.decodeStream(fis);
                result = bitmapToBase64(bitmap, THUMBNAIL_QUALITY);
                if (bitmap != null) bitmap.recycle();
            } else if (type == 4) {
                result = compressPicture2(photoPath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 压缩图片
     * @param srcPath 图片路径
     */
    public static String compressPicture(String srcPath) {
        FileOutputStream fos = null;
        BitmapFactory.Options op = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        op.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, op);
        op.inJustDecodeBounds = false;
        // 缩放图片的尺寸
        float w = op.outWidth;
        float h = op.outHeight;
        float hh = 60f;//
        float ww = 60f;//
        // 最长宽度或高度1024
        float be = 2.0f;
        if (w > h && w > ww) {
            be = (float) (w / ww);
        } else if (w < h && h > hh) {
            be = (float) (h / hh);
        }
        if (be <= 0) {
            be = 1.0f;
        }
        op.inSampleSize = (int) be;// 设置缩放比例,这个数字越大,图片大小越小.
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, op);
        int desWidth = (int) (w / be);
        int desHeight = (int) (h / be);
        bitmap = Bitmap.createScaledBitmap(bitmap, desWidth, desHeight, true);
        String result = bitmapToBase64(bitmap);
        if (bitmap != null) bitmap.recycle();
        return result;
    }



    /**
     * 压缩图片
     * @param srcPath 图片路径
     */
    public static String compressPicture2(String srcPath) {
        FileOutputStream fos = null;
        BitmapFactory.Options op = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        op.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, op);
        op.inJustDecodeBounds = false;
        // 缩放图片的尺寸
        float w = op.outWidth;
        float h = op.outHeight;
        float hh = 320f;//
        float ww = 320f;//
        // 最长宽度或高度1024
        float be = 2.0f;
        if (w > h && w > ww) {
            be = (float) (w / ww);
        } else if (w < h && h > hh) {
            be = (float) (h / hh);
        }
        if (be <= 0) {
            be = 1.0f;
        }
        op.inSampleSize = (int) be;// 设置缩放比例,这个数字越大,图片大小越小.
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, op);
        int desWidth = (int) (w / be);
        int desHeight = (int) (h / be);
        bitmap = Bitmap.createScaledBitmap(bitmap, desWidth, desHeight, true);
        String result = bitmapToBase64(bitmap);
        if (bitmap != null) bitmap.recycle();
        return result;
    }

    /**
     * 压缩图片
     * @param srcPath 图片路径
     */
    public static String compressPicture3(String srcPath) {
        FileOutputStream fos = null;
        BitmapFactory.Options op = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        op.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, op);
        op.inJustDecodeBounds = false;
        // 缩放图片的尺寸
        float w = op.outWidth;
        float h = op.outHeight;
        float hh = 2432f;//
        float ww = 2432f;//
        // 最长宽度或高度1024
        float be = 2.0f;
        if (w > h && w > ww) {
            be = (float) (w / ww);
        } else if (w < h && h > hh) {
            be = (float) (h / hh);
        }
        if (be <= 0) {
            be = 1.0f;
        }
        op.inSampleSize = (int) be;// 设置缩放比例,这个数字越大,图片大小越小.
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, op);
        int desWidth = (int) (w / be);
        int desHeight = (int) (h / be);
        bitmap = Bitmap.createScaledBitmap(bitmap, desWidth, desHeight, true);
        String result = bitmapToBase64(bitmap);
        if (bitmap != null) bitmap.recycle();
        return result;
    }

    /**
     * bitmap转为base64
     * @param bitmap
     */
    public static String bitmapToBase64(Bitmap bitmap) {
        return bitmapToBase64(bitmap, PHOTO_QUALITY);
    }

    /**
     *
     * bitmap转为base64
     *
     * @param bitmap
     */
    public static String bitmapToBase64(Bitmap bitmap, int quality) {
        if (bitmap == null) { return null; }

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
            baos.flush();
            baos.close();

            byte[] bitmapBytes = baos.toByteArray();
            Log.d(TAG,"==== bitmapBytes ====>>>>> " + bitmap.getByteCount());
            result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            Log.d(TAG,"==== bitmapString ====>>>>> " + result.length());
            bitmap.recycle();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    /**
     * 开始拼接照片
     */
//    public static void jointToImage(Context context, String firstPhotoPath, String secondPhotoPath, MyOnCompressListener myOnCompressListener) {
//        String base641 = compressPicture3(firstPhotoPath);
//        String base642 = compressPicture3(secondPhotoPath);
//        Bitmap bit1 = base64ToBitmap(base641);
//        Bitmap bit2 = base64ToBitmap(base642);
////        Bitmap bit1 = BitmapFactory.decodeByteArray(firstPhotoPath, 0, firstPhotoPath.length); ;
////        Bitmap bit2 = BitmapFactory.decodeByteArray(secondPhotoPath, 0, secondPhotoPath.length); ;
//        if (null != com.framework.utilities.DataUtility.bitmap) {
//            com.framework.utilities.DataUtility.bitmap.recycle();
//        }
//        // 纵向拼接照片
//        com.framework.utilities.DataUtility.bitmap = addBitmap(bit1, bit2);
//
//        JLog.d("拼接图片成功");
//        final File saveFile = saveImage(context, com.framework.utilities.DataUtility.bitmap);
//        myOnCompressListener.onSuccess(saveFile);
////        String photoPath = saveFile.getAbsolutePath();
////        JLog.d("拼接图片成功后保存的路径为======" + photoPath);
////        Luban.with(context)
////                .load(photoPath)
////                .ignoreBy(100)
////                .setTargetDir(getPath(context))  // 设置压缩图片后的保存路径
////                .setCompressListener(new OnCompressListener() {
////                    @Override
////                    public void onStart() {
////                    }
////
////                    @Override
////                    public void onSuccess(File file) {
////                        myOnCompressListener.onSuccess(file);
////                        new Thread(() -> {
////                            if (null != saveFile && saveFile.exists()) {
//////                                    saveFile.delete();
////                                JLog.d("删除拼接的图片成功=======" + saveFile.getAbsolutePath());
////                            }
////                            JLog.d("保存的压缩图片的路径=======" + file.getAbsolutePath());
////                            // 删除拍照的两张照片
////                            deleteDir(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
////                        }).start();
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////                        myOnCompressListener.onError(e);
////                    }
////                }).launch();
//    }

    /**
     * 纵向拼接照片
     */
    private static Bitmap addBitmap(Bitmap first, Bitmap second) {
        int width = Math.max(first.getWidth(), second.getWidth());
        int height = first.getHeight() + second.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444); // ARGB_4444  RGB_565
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(first, 0, 0, null);
        canvas.drawBitmap(second, 0, first.getHeight(), null);
        return result;
    }

    /**
     * 保存拼接图片( 未压缩 )的路径
     *
     * @param bmp 传过来的 Bitmap
     * @return
     */
    public static File saveImage(Context context, Bitmap bmp) {
        // 获取保存的路径
        String cachePath = context.getFilesDir().getAbsolutePath()+"/jointImage";
        File appDir = new File(cachePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 获取压缩图片后的保存路径---即压缩图片后保存的文件夹
     *
     * @param context
     */
    private static String getPath(Context context) {
        String path = Environment.getExternalStorageDirectory() + "/Luban/compressImage/";
//        String path = context.getFilesDir().getAbsolutePath()+"/compressImage";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }



    /**
     * 将base64字符解码保存文件
     * @param base64Code
     * @param targetFile
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code, File targetFile) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetFile);
        out.write(buffer);
        out.close();

    }

    /**
     * encodeBase64File:(将文件转成base64 字符串). <br/>
     * @author guhaizhou@126.com
     * @param path 文件路径
     * @return
     * @throws Exception
     * @since JDK 1.6
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return Base64.encodeToString(buffer, Base64.DEFAULT);
    }

    /**
     * 删除文件夹和文件夹里面的文件
     * @param pPath  注意：这里是文件夹，文件不起作用
     */
    public static void deleteDir(final String pPath) {
        File dir = new File(pPath);
        deleteDirWihtFile(dir);
    }

    /**
     * 删除文件夹和文件夹里面的文件
     */
    private static void deleteDirWihtFile(File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return;
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDirWihtFile(file); // 递规的方式删除文件
        }
        dir.delete();// 删除目录本身
    }

    public interface MyOnCompressListener {
        void onSuccess(File file);

        void onError(Throwable e);
    }

    /**
     * 压缩图片
     * @param srcPath 图片路径
     */
    public static String compressPictureToUri(String srcPath) {
        FileOutputStream fos = null;
        BitmapFactory.Options op = new BitmapFactory.Options();
        // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
        op.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, op);
        op.inJustDecodeBounds = false;
        // 缩放图片的尺寸
        float w = op.outWidth;
        float h = op.outHeight;
        float hh = 720f;//
        float ww = 1280f;//
        // 最长宽度或高度1024
        float be = 2.0f;
        if (w > h && w > ww) {
            be = (float) (w / ww);
        } else if (w < h && h > hh) {
            be = (float) (h / hh);
        }
        if (be <= 0) {
            be = 1.0f;
        }
        op.inSampleSize = (int) be;// 设置缩放比例,这个数字越大,图片大小越小.
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, op);
        int desWidth = (int) (w / be);
        int desHeight = (int) (h / be);
        bitmap = Bitmap.createScaledBitmap(bitmap, desWidth, desHeight, true);
        byte[] bitmapBytes = compressImage(bitmap);
        String result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
        if (bitmap != null) bitmap.recycle();
        return base64ToUri(result);
    }

    /** 
     * 质量压缩方法 
     * @param image 
     * @return 
     */  
    public static byte[] compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 90;  
        while (baos.toByteArray().length / 1024 > 180) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩  
            baos.reset(); // 重置baos即清空baos  
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;// 每次都减少10  
        }  
//        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
//        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
        return baos.toByteArray();
    }

    public static String base64ToUri(String b64Str){
        String dirPath = XYD_PHOTO_FILE_PATH + "loan/";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String photoName = System.currentTimeMillis() + ".jpg";
        File file = new File(dir, photoName);
        try{
            decoderBase64File(b64Str, file);
        }catch (Exception e){

        }
        return file.getPath();
    }

}
