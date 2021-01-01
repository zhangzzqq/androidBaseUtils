# 1  等待框   ThinkDriveProgressDialog  
## 1.1用法 
```
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
```

# 2 用法 

 //注册一下，要在哪个页面上显示
 ##2.1    StyledDialog.init(this);
 
 ##2.2 使用
 第一种dialog
 ```
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

```

#3 用法
第二种dialog
```
 StyledDialog.init(this);
  Dialog gloablDialog = StyledDialog.buildMdLoading("客官不要急吗，正在加载中").
                setMsgColor(R.color.colorPrimaryDark).show();
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                StyledDialog.dismiss(gloablDialog);
            }
        },3000);
 ```
#其他用法

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn_common_progress)
    Button btnCommonProgress;
    @Bind(R.id.btn_context_progress)
    Button btnContextProgress;
    @Bind(R.id.btn_material_alert)
    Button btnMaterialAlert;
    @Bind(R.id.btn_multichoose)
    Button btnMultichoose;
    @Bind(R.id.btn_singlechoose)
    Button btnSinglechoose;
    @Bind(R.id.btn_ios_alert)
    Button btnIosAlert;
    @Bind(R.id.btn_ios_alert_vertical)
    Button btnIosAlertVertical;
    @Bind(R.id.btn_input)
    Button btnInput;
    @Bind(R.id.btn_ios_bottom_sheet)
    Button btnIosBottomSheet;
    @Bind(R.id.btn_ios_center_list)
    Button btnIosCenterList;
    @Bind(R.id.btn_md_bs)
    Button btnMdBs;
    @Bind(R.id.btn_md_bs_listview)
    Button btnMdBsListview;
    @Bind(R.id.btn_md_bs_Gridview)
    Button btnMdBsGridview;
    Dialog gloablDialog;

    String msg = "如果你有心理咨询师般的敏锐，你会进一步发现——这个姑娘企图用考研来掩饰自己对于毕业的恐惧";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StyledDialog.init(this);
//        new Thread(networkTask).start();
    }
    
    public void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
    
    @OnClick({R.id.btn_common_progress, R.id.btn_context_progress,
            R.id.btn_material_alert, R.id.btn_multichoose, R.id.btn_singlechoose,
            R.id.btn_ios_alert, R.id.btn_ios_alert_vertical,
            R.id.btn_input, R.id.btn_ios_bottom_sheet, R.id.btn_ios_center_list,
            R.id.btn_md_bs, R.id.btn_md_bs_listview, R.id.btn_md_bs_Gridview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_common_progress:
//                StyledDialog.init(getActivity());
                gloablDialog= StyledDialog.buildLoading( "加载中...").show();
//                startActivity(new Intent(getActivity(),demo1.class));
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        StyledDialog.dismissLoading();
                        StyledDialog.dismiss(gloablDialog);
                    }
                },3000);
                break;
            case R.id.btn_context_progress:
                gloablDialog = StyledDialog.buildMdLoading("客官不要急吗，正在加载中")
                        .setMsgColor(R.color.colorPrimaryDark).show();
                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        StyledDialog.dismiss(gloablDialog);
                    }
                },3000);
                break;
            case R.id.btn_material_alert:
                StyledDialog.buildMdAlert("title", msg,  new MyDialogListener() {
                    @Override
                    public void onFirst() {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond() {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird() {
                        showToast("onThird");
                    }

                })
                        .setBtnSize(20)
                        .setBtnText("i","b","3")
                        .show();
                break;
            case R.id.btn_ios_alert:
                StyledDialog.buildIosAlert( "title", msg,  new MyDialogListener() {
                    @Override
                    public void onFirst() {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond() {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird() {
                        showToast("onThird");
                    }


                }).setBtnText("sure","cancle","hhhh").show();
                break;
            case R.id.btn_ios_alert_vertical:
                StyledDialog.buildIosAlertVertical( "title", msg,  new MyDialogListener() {
                    @Override
                    public void onFirst() {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond() {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird() {
                        showToast("onThird");
                    }

                }).show();
                break;
            case R.id.btn_ios_bottom_sheet: {
                final List<String> strings = new ArrayList<>();
                strings.add("1");
                strings.add("2");
                strings.add(msg);
                strings.add("4");
                strings.add("5");
                strings.add("6");
                strings.add("7");
                strings.add(msg);
                strings.add("8");
                strings.add("9");
                strings.add(msg);

                StyledDialog.buildBottomItemDialog( strings, "cancle",  new MyItemDialogListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text);
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("onItemClick");
                    }
                }).show();
            }
            break;
            case R.id.btn_ios_center_list:

                final List<String> strings = new ArrayList<>();
                strings.add("1");
                strings.add("2");
                strings.add(msg);
                strings.add("4");
                strings.add("5");
                strings.add(msg);
                strings.add("6");
                strings.add("7");
                strings.add(msg);
                strings.add("8");
                strings.add("9");
                strings.add(msg);

                strings.add("10");
                strings.add("11");
                strings.add(msg);
                strings.add("12");
                strings.add("13");
                strings.add(msg);

                StyledDialog.buildIosSingleChoose(strings, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text);
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("onItemClick");
                    }
                }).show();

                break;
            case R.id.btn_input:
                StyledDialog.buildNormalInput("登录", "请输入用户名", "请输入密码", "登录", "取消",  new MyDialogListener() {
                    @Override
                    public void onFirst() {

                    }

                    @Override
                    public void onSecond() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        super.onGetInput(input1, input2);
                        showToast("input1:"+ input1 +"--input2:"+input2);
                    }
                }).show();

                break;
            case R.id.btn_multichoose:
                final String[] words = new String[]{"12","78","45","89","88","00"};
                boolean[] choseDefault = new boolean[]{false,false,false,false,true,false};

                StyledDialog.buildMdMultiChoose( "多选", words, choseDefault,  new MyDialogListener() {
                    @Override
                    public void onGetChoose(boolean[] states) {
                       String str="";
                        for (int a =0;a<states.length;a++){
                           if (states[a]){
                               str=words[a]+","+str;  
                           }
                       }
                        showToast(str);
                    }

                    @Override
                    public void onFirst() {
                        
                    }

                    @Override
                    public void onSecond() {

                    }
                }).show();
                break;
            case R.id.btn_singlechoose:
                String[] words2 = new String[]{"12","78","45","89","88","00"};
                StyledDialog.buildMdSingleChoose("单选", 2, words2,  new MyItemDialogListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "--" + position);
                    }
                }).setBtnText("sure","cancle","hhhh").show();

                break;
            case R.id.btn_md_bs:
                String[] words3 = new String[]{"12","78","45","89","11","00"};
                List<String> datas = Arrays.asList(words3);

                // final BottomSheetDialog dialog = new BottomSheetDialog(this);
                RecyclerView recyclerView = new RecyclerView(this);
                recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                SuperRcvAdapter adapter = new SuperRcvAdapter(this) {
                    @Override
                    protected SuperRcvHolder generateCoustomViewHolder(int viewType) {

                        return new SuperRcvHolder<String>(inflate(R.layout.item_text)) {

                            Button mButton;
                            @Override
                            public void assignDatasAndEvents(Activity context, final String data) {
                                if (mButton==null){
                                    mButton = (Button) itemView.findViewById(R.id.btnee);
                                }
                                mButton.setText(data);
                                mButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        showToast(data);
                                    }
                                });
                            }
                        };
                    }
                };
                recyclerView.setAdapter(adapter);
                adapter.addAll(datas);
                adapter.addAll(datas);
                adapter.addAll(datas);

                StyledDialog.buildCustomBottomSheet(recyclerView).show();//不好建立回调





                break;

            case R.id.btn_md_bs_listview:{
                List<BottomSheetBean> datas2 = new ArrayList<>();

                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"1"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"222"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"333333"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"444"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"55"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"666"));

                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"7777"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"fddsf"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"67gfhfg"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"oooooppp"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"fddsf"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"67gfhfg"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"oooooppp"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"fddsf"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"67gfhfg"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"oooooppp"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"fddsf"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"67gfhfg"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"oooooppp"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher, "fddsf"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher, "67gfhfg"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher, "oooooppp"));




                StyledDialog.buildBottomSheetLv("拉出来溜溜", datas2, "this is cancle button", new MyItemDialogListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "---" + position);
                    }
                }).show();}
            break;

            case R.id.btn_md_bs_Gridview:
                List<BottomSheetBean> datas2 = new ArrayList<>();

                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"1"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"222"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"333333"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"444"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"55"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"666"));

                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"7777"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"fddsf"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"67gfhfg"));
                datas2.add(new BottomSheetBean(R.mipmap.ic_launcher,"oooooppp"));




                StyledDialog.buildBottomSheetGv( "拉出来溜溜", datas2, "this is cancle button",3, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text+"---"+position);
                    }
                }).show();
                break;
        }
    }
}

<https://dl-download.csdn.net/down11/20170713/f5a1c5efb3bf5a3ab938734806acdb81.rar?response-content-disposition=attachment%3Bfilename%3D%22Demo.rar%22&security-token=CAISgwJ1q6Ft5B2yfSjIr5eGJtfZuup52vWTYWX611cvecNOrYDatzz2IHxFf3FoCOEYv%2Fk1nWlU6%2FoTlqF%2FTIBDQUvNYZOvWRvWckXzDbDasumZsJYw6vT8a1fxZjf%2F2MjNGaCbKPrWZvaqbX3diyZ32sGUXD6%2BXlujQ%2BDr6Zl8dYY4UxX6D1tBH8wEAgp5tI1gQhm3D%2Fu2NQPwiWf9FVdhvhEG6Vly8qOi2MaRmHG85R%2FYsrZJ%2FtuvecD%2FMJI3Z8kvC4uPsbYoJvab4kl58ANX8ap6tqtA9Arcs8uVa1sruEnXaLKMo4wxfVIjP%2FFmRvIVtprnieY9tuiWkJ%2Fs25qImF%2BBkY61GoABp7tOCLMUgoXqd8bEYTvHAu90tZsCQzq30NTHvbVvTdWpqwRYdQxkw82BJK79GMqLcaeUrM9TVOIXzyo52YYXaBt01olEapwBRv9aKyfTl9nwnFRBvKMRMuMkZN%2FstVXvnmZID2jJkt9nJSsz7wDX%2BUS%2Bep8ZfIXbPBeaZ24qO7Q%3D&OSSAccessKeyId=STS.NT3mmmW5Xm7xcCK3WzuLbBEqU&Expires=1609489159&Signature=3zbxVVymFbyhwnmVdloJSbavUGk%3D>

#5 dialog 

## 简单使用 dialog没有阴影 
```
    ProgressDialog progressDialog = new ProgressDialog();
        progressDialog.init(MainActivity.this,"努力加载中");

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.start();//开始加载
                //     progressDialog.cancel();//结束加载

            }
        });
        
```

布局 
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:background="@drawable/ic_loading_bg"
              android:gravity="center"
              android:orientation="vertical"
              android:padding="16.0dip" >

    <ProgressBar
            android:layout_width="30.0dip"
            android:layout_height="30.0dip"
            android:indeterminateDrawable="@drawable/progress_drawable_white" />

    <TextView
            android:id="@+id/id_tv_loadingmsg"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_vertical"
            android:layout_marginTop="8.0dip"
            android:textColor="#fff"
            android:textSize="16.0dip" />

</LinearLayout>
```
 #5 官方的
 ```
 ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("loading...");
        progressDialog.setCancelable(false);


 progressDialog.show();

```
#6 框架
https://github.com/Blankj/AndroidUtilCode




     


 