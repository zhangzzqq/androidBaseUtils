package com.example.imagebitmaptest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.imagebitmaptest.utils.dialog.base.BaseActivity;

import net.vidageek.mirror.dsl.Mirror;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author: steven
 * date: 2021/2/20
 * desc:
 */
public class MacAddress extends AppCompatActivity {

private static final String TAG =MacAddress.class.getSimpleName();
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Button btn = findViewById(R.id.btn);
        TextView tv = findViewById(R.id.tv);

        checkBlePermission();
        checkBleDevice();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bluetoothAddress = Settings.Secure.getString(getContentResolver(), "bluetooth_address");


                tv.setText( getBluetoothAddress());
            }
        });


    }

  
    /**
     * 检查蓝牙权限
     */
    public void checkBlePermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
        } else {
            Log.i("tag","已申请权限");
        }
    }




    /**
     * 获取本机蓝牙地址
     */
    /**
     * 获取本机蓝牙地址
     */
    private String getBluetoothAddress() {
        try {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            Field field = bluetoothAdapter.getClass().getDeclaredField("mService");
            // 参数值为true，禁用访问控制检查
            field.setAccessible(true);
            Object bluetoothManagerService = field.get(bluetoothAdapter);
            if (bluetoothManagerService == null) {
                return null;
            }
            Method method = bluetoothManagerService.getClass().getMethod("getAddress");
            Object address = method.invoke(bluetoothManagerService);
            if (address != null && address instanceof String) {
                return (String) address;
            } else {
                return null;
            }
            //抛一个总异常省的一堆代码...
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                // 如果请求被取消，则结果数组为空。
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i("tag", "同意申请");
                } else {
                    Log.i("tag", "拒绝申请");
                }
                break;
            }
        }
    }

    /**
     * 判断是否支持蓝牙，并打开蓝牙
     * 获取到BluetoothAdapter之后，还需要判断是否支持蓝牙，以及蓝牙是否打开。
     * 如果没打开，需要让用户打开蓝牙：
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void checkBleDevice() {
        //首先获取BluetoothManager
        BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        //获取BluetoothAdapter
        if (bluetoothManager != null) {
            BluetoothAdapter mBluetoothAdapter = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
                mBluetoothAdapter = bluetoothManager.getAdapter();
            }
            if (mBluetoothAdapter != null) {
                if (!mBluetoothAdapter.isEnabled()) {
                    //调用enable()方法直接打开蓝牙
                    if (!mBluetoothAdapter.enable()){
                        Log.i("tag","蓝牙打开失败");
                    }
                    else{
                        Log.i("tag","蓝牙已打开");
                    }
                    //该方法也可以打开蓝牙，但是会有一个很丑的弹窗，可以自行尝试一下
//                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                    enableBtIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(enableBtIntent);
                }
            } else {
                Log.i("tag","同意申请");
            }
        }
    }


}
