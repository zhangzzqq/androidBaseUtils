package com.example.imagebitmaptest.utils.file;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件工具类
 *
 * Created by lxb on 2017/6/5.
 */

public class FileUtils1 {


    public static String SDCardRoot = Environment.getExternalStorageDirectory() + File.separator;   //根目录
    public static String SDCardRoot2 = Environment.getExternalStorageDirectory() + File.separator;   //根目录

    public static String APPDIR = "baize";              //一级目录
    public static String APPINFOFILENAME = "appinfo.json";  //文件名
    public static String APPINFOPATH = SDCardRoot + APPDIR + File.separator + APPINFOFILENAME;          //全路径名


    /**
     * 判断文件是否存在
     *
     * @param filePath
     * @return
     */
    public static boolean isFileExists(String filePath) {

        File file = new File(filePath);
        return file.exists();
    }

    /**
     * 在SD卡上创建目录
     *
     * @param dir
     * @return
     * @throws IOException
     */
    public static File createSDDir(String dir) throws IOException {
        File dirFile = new File(SDCardRoot + dir);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        return dirFile;
    }

    /**
     * 在SD卡上创建文件
     *
     * @param fileName :文件名
     * @param dir      :目录名
     * @return
     * @throws IOException
     */
    public static File createFileInSDCard(String fileName, String dir) throws IOException {
        File file = new File(SDCardRoot + dir + File.separator + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /**
     * 向文件中写入字符串String类型的内容
     *
     * @param fileName 文件名
     * @param content  文件内容
     * @param charset  写入时候所使用的字符集
     */
    public static void writeString2File(String fileName, String content, String charset) {

        try {
            createSDDir(APPDIR);
            createFileInSDCard(fileName, APPDIR);
            byte[] data = content.getBytes(charset);
            writeBytes(APPINFOPATH, data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * 向文件中写入数据
     *
     * @param filePath 目标文件全路径
     * @param data     要写入的数据
     * @return true表示写入成功  false表示写入失败
     */
    public static boolean writeBytes(String filePath, byte[] data) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(data);
            fos.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    /**
     * 从文件中读取数据
     *
     * @param file
     * @return
     */
    public static byte[] readBytes(String file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            int len = fis.available();
            byte[] buffer = new byte[len];
            fis.read(buffer);
            fis.close();
            return buffer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;

    }


    /**
     * 从文件中读取数据，返回类型是字符串String类型
     *
     * @param file    文件路径
     * @param charset 读取文件时使用的字符集，如utf-8、GBK等
     * @return
     */
    public static String readString(String file, String charset) {
        byte[] data = readBytes(file);
        String ret = null;

        try {
            ret = new String(data, charset);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ret;
    }


    /**
     * 根据文件路径读取文件
     *
     * @param filePath
     * @param charsetName
     * @return
     */
    public static StringBuilder readFile(String filePath, String charsetName) {
        File file = new File(filePath);
        return readFile(file, charsetName);
    }

    /**
     * 根据文件，读取文件
     *
     * @param file
     * @param charsetName
     * @return
     */
    public static StringBuilder readFile(File file, String charsetName) {

        StringBuilder fileContent = new StringBuilder("");
        if (file == null || !file.isFile()) {
            return null;
        }

        BufferedReader reader = null;
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(file), charsetName);
            reader = new BufferedReader(is);
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!fileContent.toString().equals("")) {
                    fileContent.append("\r\n");
                }
                fileContent.append(line);
            }
            reader.close();
            return fileContent;
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred. ", e);
        }

    }
}





