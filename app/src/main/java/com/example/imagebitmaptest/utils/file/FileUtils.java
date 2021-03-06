package com.example.imagebitmaptest.utils.file;

 /* 描述:工具类，用于文件的保存，读取
         * 创建人:菜籽
         * 创建时间:2017/7/26 下午5:36
         * 备注:
         */

import android.content.Context;
import android.content.SharedPreferences;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    private final static String SHARED_PREFERENCE_FILE_NAME = "information";

    /**
     * 将文件保存到APP安装目录下的缓存中
     * 从安卓整洁度考虑，不要把缓存文件放到公共路径下，
     * 说实话，我很鄙视这种在SD卡根目录建立文件夹的行为
     * 如果要长久保存，则放在getExternalFilesDir(null)中
     * 如果是作为缓存，则放在getExternalCacheDir()中
     * 保存到私有存储的话，不需要申请额外权限
     *
     * context.getExternalFilesDir(null)————/storage/emulated/0/Android/包名/files
     *
     * context.getExternalCacheDir()————————/storage/emulated/0/Android/包名/cache
     *
     * context.getFilesDir()————————————————/data/data/包名/files
     *
     * context.getCacheDir()————————————————/data/data/包名/cache
     *
     * context.getExternalFilesDir(null)————共有存储目录，跟SD卡中Android目录同级，需要申请读写权限
     *
     * 注意：调用以上接口保存的数据，在APP下载之后，数据会随之删除，不留垃圾
     * 注意：data 分区十分有限，不建议把大型数据保存在 data 分区下
     * 注意：Google建议把数据保存在/storage/emulated/0/Android/包名/files下
     * 注意：上面方法中需要填写参数的接口，内部的参数可以指定子文件夹，参数可以放Environment.DIRECTORY_PICTURES之类的
     *      比如context.getExternalFilesDir(Environment.DIRECTORY_DCIM)
     *
     *
     * @param fileName ： 保存之后的文件名字
     * @param bytes    ： 要保存的文件的字节流
     * @return
     */
    public static boolean saveFileToInnerStorage(Context context, String fileName, byte[] bytes) {
        File file = new File(context.getExternalCacheDir(), fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);

            outputStream.flush();
            outputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 从APP安装目录下的缓存中获取保存的文件
     *
     * @param context
     * @param fileName
     * @return
     */
    public static byte[] readFileFromInnerStorage(Context context, String fileName) {
        File file = new File(context.getExternalCacheDir(), fileName);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            byte[] array = outputStream.toByteArray();
            return array;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    public static byte[] strToByteArray(String str) {
        if (str == null) {
            return null;
        }
        byte[] byteArray = str.getBytes();
        return byteArray;
    }

    public static String byteArrayToStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        String str = new String(byteArray);
        return str;
    }


}