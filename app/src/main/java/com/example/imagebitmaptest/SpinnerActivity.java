package com.example.imagebitmaptest;

import android.support.v7.app.AppCompatActivity;

/**
 * Date：2021/5/20
 * Time：17:38
 * author:Stenven
 **/

import android.os.Bundle;


import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_icon);
        initSpinnerForSimpleAdapter();
    }


    // 初始化下拉框，演示简单适配器
    private void initSpinnerForSimpleAdapter() {
        // 声明一个映射对象的队列，用于保存行星的图标与名称配对信息
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        // iconArray是行星的图标数组，starArray是行星的名称数组
        for (int i = 0; i < iconArray.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("icon", iconArray[i]);
            item.put("name", starArray[i]);
            // 把一个行星图标与名称的配对映射添加到队列当中
            list.add(item);
        }
        // 声明一个下拉列表的简单适配器，其中指定了图标与文本两组数据
        SimpleAdapter starAdapter = new SimpleAdapter(this, list,
                R.layout.item_simple, new String[]{"icon", "name"},
                new int[]{R.id.iv_icon, R.id.tv_name});
        // 设置简单适配器的布局样式
        starAdapter.setDropDownViewResource(R.layout.item_simple);
        // 从布局文件中获取名叫sp_icon的下拉框
        Spinner sp = findViewById(R.id.sp_icon);
        // 设置下拉框的标题
        sp.setPrompt("请选择行星");
        // 设置下拉框的简单适配器
        sp.setAdapter(starAdapter);
        // 设置下拉框默认显示第一项
        sp.setSelection(0);
        // 给下拉框设置选择监听器，一旦用户选中某一项，就触发监听器的onItemSelected方法
        sp.setOnItemSelectedListener(new MySelectedListener());
    }

    // 定义下拉列表需要显示的行星图标数组
    private int[] iconArray = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
    // 定义下拉列表需要显示的行星名称数组
    private String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};

    // 定义一个选择监听器，它实现了接口OnItemSelectedListener
    class MySelectedListener implements AdapterView.OnItemSelectedListener {
        // 选择事件的处理方法，其中arg2代表选择项的序号
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Toast.makeText(SpinnerActivity.this, "您选择的是" + starArray[arg2], Toast.LENGTH_LONG).show();
        }

        // 未选择时的处理方法，通常无需关注
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//            int id = item.getItemId();
//
//            //noinspection SimplifiableIfStatement
//            if (id == R.id.action_settings) {
//                return true;
//            }
//
//            return super.onOptionsItemSelected(item);
    }
}
