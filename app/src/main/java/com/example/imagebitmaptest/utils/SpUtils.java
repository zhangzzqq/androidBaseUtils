package com.example.imagebitmaptest.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
    private final static String SHARED_PREFERENCE_FILE_NAME = "information";
    //********通过SharedPreference保存数据，保存路径为/data/data/包名/XX
    public static boolean saveDataWithSharedPreference(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static boolean saveDataWithSharedPreference(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static boolean saveDataWithSharedPreference(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    //*******通过SharedPreference读取数据
    public static String readDataWithSharedPreference(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, null);
        return value;
    }

    public static int readDataWithSharedPreference(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        int value = sharedPreferences.getInt(key, defaultValue);
        return value;
    }

    public static boolean readDataWithSharedPreference(Context context, String key, boolean flag) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        boolean value = sharedPreferences.getBoolean(key, flag);
        return value;
    }


}
