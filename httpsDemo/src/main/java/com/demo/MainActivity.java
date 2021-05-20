package com.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.demo.TrustAllCerts.createSSLSocketFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = findViewById(R.id.tx);
        findViewById(R.id.btn).setOnClickListener((View v) -> request());


    }

    private void request() {

        //双向认证
//        normalTwoCheck();

        // 单向认证
        check12306();


    }

     /**
      * desc:  双向认证
      *
      */
    private void normalTwoCheck() {
        String requestUrl = "https://192.168.0.156:8888/demo/test";
        Request request = new Request.Builder().url(requestUrl).get().build();

        OkHttpInstance.getmOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String bodyStr = responseBody.string();
                    OkHttpInstance.getMainThreadHandler().post(() -> tx.setText(bodyStr));
                    Log.e(TAG, "responseBody: " + bodyStr);
                }
            }


        });
    }

     /**
      * desc:  单向认证
      *
      */
    private void check12306(){
        String requestUrl = "https://kyfw.12306.cn/otn/";
        Request request = new Request.Builder().url(requestUrl).get().build();
//        OkHttpClient okHttpClient = setCard(OkHttpInstance2.ROOT_CA_CERT2);
        OkHttpClient okHttpClient = setCard("12306-cn.pem");
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                Log.d(TAG,e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String bodyStr = responseBody.string();
                    OkHttpInstance.getMainThreadHandler().post(() -> tx.setText(bodyStr));
                    Log.e(TAG, "responseBody: " + bodyStr);
                }
            }
        });



    }

    /**
     * app带证书验证的方法,使用是修改一下zhaoapi_server.cer即可,其他都是固定的模式,直接拷贝
     */
    public OkHttpClient setCard(String zhenshu) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            //https固定模式,X.509是固定的模式
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            //关联证书的对象
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            String certificateAlias = Integer.toString(0);
            //核心逻辑,信任什么证书,从Assets读取拷贝进去的证书
            keyStore.setCertificateEntry(certificateAlias, certificateFactory
                    .generateCertificate(getAssets().open(zhenshu)));
            SSLContext sslContext = SSLContext.getInstance("TLS");
            //信任关联器
            final TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            //初始化证书对象
            trustManagerFactory.init(keyStore);
            sslContext.init
                    (
                            null,
                            trustManagerFactory.getTrustManagers(),
                            new SecureRandom()
                    );
            builder.sslSocketFactory(sslContext.getSocketFactory());
//            builder.addInterceptor(new LogInterceptor());
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
        } catch (Exception e) {
            Log.e(TAG,e.toString());
            e.printStackTrace();

        }
        return builder.build();
    }

    /**
     * 信任所有证书
     *
     */

    private void allCer(){

        OkHttpClient mClient0 = new OkHttpClient.Builder()
//                .connectTimeout(Constant.DEFAULT_NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
//                .readTimeout(Constant.DEFAULT_IO_TIMEOUT, TimeUnit.MILLISECONDS)
//                .writeTimeout(Constant.DEFAULT_IO_TIMEOUT, TimeUnit.MILLISECONDS)
//            .sslSocketFactory(getSLLContext().getSocketFactory())
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .addInterceptor(chain -> {
                    Request.Builder builder = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json");
//                    User user = AppGlobal.getUserInfo();
//                    String uuid = user.getUid();
//                    String token = user.getToken();
//                    if (!"".equals(uuid) &&
//                            uuid != null &&
//                            !"".equals(token) &&
//                            token != null) {
//                        builder.addHeader("uid", uuid);
//                        builder.addHeader("token", token);
//                    }
                    return chain.proceed(builder.build());
                })
                .build();





    }


    public static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }




}
