package com.demo;

import android.os.Handler;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okio.Buffer;

public class OkHttpInstance2 {

    public static final String ROOT_CA_CERT =
            "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDSzCCAjMCFCWCftYFB2wpkryu35KGmWXLwKNmMA0GCSqGSIb3DQEBCwUAMGIx\n" +
                    "CzAJBgNVBAYTAkNOMRIwEAYDVQQIDAlHdWFuZ2RvbmcxEjAQBgNVBAcMCUd1YW5n\n" +
                    "emhvdTERMA8GA1UECgwIQ3JlZGl0ZnQxCzAJBgNVBAsMAklUMQswCQYDVQQDDAJX\n" +
                    "VDAeFw0xOTEyMTkwNzM4MDBaFw0yMDAxMTgwNzM4MDBaMGIxCzAJBgNVBAYTAkNO\n" +
                    "MRIwEAYDVQQIDAlHdWFuZ2RvbmcxEjAQBgNVBAcMCUd1YW5nemhvdTERMA8GA1UE\n" +
                    "CgwIQ3JlZGl0ZnQxCzAJBgNVBAsMAklUMQswCQYDVQQDDAJXVDCCASIwDQYJKoZI\n" +
                    "hvcNAQEBBQADggEPADCCAQoCggEBANrOVKqsJiVG+alUbauhiJj7wLq/zqAHrxhS\n" +
                    "8Ca6wJoBXMy32Hij33LmNPXS1VDjxcjkmxAhS/sueNt9oO8io6qtHGD/6ctbGlw3\n" +
                    "kfmHRZLPt4ZyNY6El06cItzvaX9CxsnwsLa5OPWmtDZ/iQSQvNF36js8DoV7U0+x\n" +
                    "rF+reS7RQLg3pGeBcHHNtQuGSZr4ISb+F9FsP09wkIn4/T8WWEXZT+a02U8QG605\n" +
                    "SCoZJuOVlLAtK4vIuMox82ddoDN7mL6MZ1zr9DamVTglzXoUQPwslaDHSpx7l83B\n" +
                    "EgR3bhjX11at7J44C7ZG5UEmfmDfvZnxZ5PHMAOsSKeWdBmBnbMCAwEAATANBgkq\n" +
                    "hkiG9w0BAQsFAAOCAQEA0Ezkq/WiMn92re/O5wvl7FxNmI0bleR5uZlvX0wA/Avq\n" +
                    "VEeHTvXzeGkE4UW6dtoNkhMzMexjIYO172mwDlaqNbN8Y1ywroqT/2awAv8GR1aI\n" +
                    "ync/I7/OsnbYLIwUt+CMvaQkjtEo/UV1Q4iQMZTL7LGCXPs2iveq/n6u/4IMwvyx\n" +
                    "EmUaw2FjJlMl5X+jeuWY65Z7d98tB+yg+Q6Kq+u8o2c+qwvxeEhvbZqrp/njvOPl\n" +
                    "f/NTFznroYCNm9MaNkiXTc3QZ9liUH0YWWKBbnRw5Y+6O1QpJbk9YnwjwMd8aPEH\n" +
                    "QzFYCZYIOVt/e3I4jrnMJRSlbLqrv46Nq10d7IbmlQ==\n" +
                    "-----END CERTIFICATE-----";

    public static final String ROOT_CA_CERT2 ="-----BEGIN CERTIFICATE-----\n" +
            "MIIGODCCBSCgAwIBAgIQBhck7QpKbK9+8ntG5QJstTANBgkqhkiG9w0BAQsFADBf\n" +
            "MQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\n" +
            "d3cuZGlnaWNlcnQuY29tMR4wHAYDVQQDExVEaWdpQ2VydCBDTiBSU0EgQ0EgRzEw\n" +
            "HhcNMjAxMjExMDAwMDAwWhcNMjIwMTA2MjM1OTU5WjBuMQswCQYDVQQGEwJDTjES\n" +
            "MBAGA1UECAwJ5YyX5Lqs5biCMTYwNAYDVQQKDC3kuK3lm73pk4HpgZPnp5Hlrabn\n" +
            "oJTnqbbpmaLpm4blm6LmnInpmZDlhazlj7gxEzARBgNVBAMMCiouMTIzMDYuY24w\n" +
            "ggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDPLIZws2ZoBa1w1OsnHPgR\n" +
            "Qmlj+zG7x4GK2B70cpTv1p/6WNK3+e09HDpqOE7U7tWDrveB4oGWeyHxMFkLbgl0\n" +
            "Tqy/ojgxp2ioIl6czbka0R6TLZD1CMAjQaddoRsSHq8T5wjzTDWioNc/YM4Q4Xqh\n" +
            "qWS3Hn4wm/oyjZRBzDRh9y5UlQRN+WUtARL2MnRn546DE02Yebux2brHQTYft9TE\n" +
            "APOgV1O97LDgTpE2nSoari/t4F0h2wgxsphtiwtgsnbzrQd7Vyi8qsibBfwT8gNr\n" +
            "LVg5xpj9JXIJ4BVVmWz+fszgZBJrzYI1EJ66MrfYHxLbD3eOn1svMUialc7gtPJV\n" +
            "AgMBAAGjggLfMIIC2zAfBgNVHSMEGDAWgBTvRQt4FZGlttFzpJJvY1pZ018+nTAd\n" +
            "BgNVHQ4EFgQUUQyLiMU9NZjq9EEV5TcJ45Ft1mMwHwYDVR0RBBgwFoIKKi4xMjMw\n" +
            "Ni5jboIIMTIzMDYuY24wDgYDVR0PAQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUF\n" +
            "BwMBBggrBgEFBQcDAjB1BgNVHR8EbjBsMDSgMqAwhi5odHRwOi8vY3JsMy5kaWdp\n" +
            "Y2VydC5jb20vRGlnaUNlcnRDTlJTQUNBRzEuY3JsMDSgMqAwhi5odHRwOi8vY3Js\n" +
            "NC5kaWdpY2VydC5jb20vRGlnaUNlcnRDTlJTQUNBRzEuY3JsMEwGA1UdIARFMEMw\n" +
            "NwYJYIZIAYb9bAEBMCowKAYIKwYBBQUHAgEWHGh0dHBzOi8vd3d3LmRpZ2ljZXJ0\n" +
            "LmNvbS9DUFMwCAYGZ4EMAQICMG8GCCsGAQUFBwEBBGMwYTAhBggrBgEFBQcwAYYV\n" +
            "aHR0cDovL29jc3AuZGNvY3NwLmNuMDwGCCsGAQUFBzAChjBodHRwOi8vY3JsLmRp\n" +
            "Z2ljZXJ0LWNuLmNvbS9EaWdpQ2VydENOUlNBQ0FHMS5jcnQwDAYDVR0TAQH/BAIw\n" +
            "ADCCAQMGCisGAQQB1nkCBAIEgfQEgfEA7wB2ACl5vvCeOTkh8FZzn2Old+W+V32c\n" +
            "YAr4+U1dJlwlXceEAAABdlCuUlgAAAQDAEcwRQIhAPuwbxvf7ygNlkuJQqX5YCtJ\n" +
            "fbjSv27Pp621CXAA/7Y8AiAdTivl7+y3kyPCiicutzl9I+ZvimNXI9c49ZmNtJpM\n" +
            "HwB1ACJFRQdZVSRWlj+hL/H3bYbgIyZjrcBLf13Gg1xu4g8CAAABdlCuUr8AAAQD\n" +
            "AEYwRAIgQpGXUut3/TlVbY2sypc4uE5Yu6x8byl9BPb/ddrs2aACIHz4tXylku6l\n" +
            "Yhh68Qf5NvM+8MDsCyCVZnwVawskmVNQMA0GCSqGSIb3DQEBCwUAA4IBAQC7RBvK\n" +
            "TvM3mHaJqWSHpm3VKBAItA4WLodjaWvi/tdXOBWv6Uk6Gpk6zFwXZjLz4kjeEIei\n" +
            "x7ugggp1ooqMgBINgJx2BlfiYXYoaR2ZVoS05LG5d10nCAHKZVjuPAy4Fcp/rXg5\n" +
            "BA+/muLlT1TzjWMa/f1HBERwesukCx9hsucZp5CvNSvtojGZIJszdDxhlAYYho2E\n" +
            "R2/8halLwJrOh1T0CJZRxxYhCBGK2v+wb58tn8l5py6Qe6YiaJm6f7edQISlHSeI\n" +
            "q+PxoLZTlh8Ax4S3jPA+d07/oanSlXm3fKNqETgpA9ftjGgG4F8jo4aJSH9du8G8\n" +
            "QHHbLMgbz1cjFqp1\n" +
            "-----END CERTIFICATE-----";


    private static volatile OkHttpInstance2 mInstance;

    private OkHttpClient mOkHttpClient;
    /**
     * 全局处理子线程和主线程通信
     */
    private Handler okHttpHandler;

    private OkHttpInstance2() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                    .retryOnConnectionFailure(false)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS);

            //TrustManager
            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(getKeyStore());

            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:"
                        + Arrays.toString(trustManagers));
            }
            X509TrustManager trustManager = (X509TrustManager) trustManagers[0];

            //双向认证服务端证书
//            KeyStore clientKeyStore = KeyStore.getInstance("BKS");
//            clientKeyStore.load(App.getApp().getAssets().open("final.bks"), "123456".toCharArray());
//            KeyManagerFactory keyManagerFactory =
//                    KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            keyManagerFactory.init(clientKeyStore, "123456".toCharArray());

            //SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new SecureRandom());
            builder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);

            // If unset, a default hostname verifier will be used.
            // 默认检测只会检测SubjectAltNames，也就是证书中可替换的域名
            // 这里实现验证请求host与证书内host是否相同
            builder.hostnameVerifier((String hostname, SSLSession session) -> {
                try {
                    final Certificate[] certs = session.getPeerCertificates();
                    final X509Certificate x509 = (X509Certificate) certs[0];
                    return verifyCn(hostname, x509);
                } catch (final SSLException ex) {
                    ex.printStackTrace();
                    return false;
                }
            });
            mOkHttpClient = builder.build();

            //可以验证证书内的host，也可以验证固定的host
            //private static String[] VERIFY_HOST_NAME_ARRAY = new String[]{};
            //
            //public static final HostnameVerifier createInsecureHostnameVerifier() {
            //     return new HostnameVerifier() {
            //         @Override
            //         public boolean verify(String hostname, SSLSession session) {
            //             if (TextUtils.isEmpty(hostname)) {
            //                 return false;
            //             }
            //             return !Arrays.asList(VERIFY_HOST_NAME_ARRAY).contains(hostname);
            //         }
            //     };
            // }

            okHttpHandler = new Handler(App.getApp().getMainLooper());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 这里手动验证CN与host是否相同
     *
     * @param hostname 请求的host
     * @param x509     服务器返回的证书
     * @return host是否合法
     */
    private boolean verifyCn(String hostname, X509Certificate x509) {
        if (hostname == null) {
            return false;
        }
        String name = x509.getSubjectDN().getName();
        if (name != null) {
            String temp = name.substring(name.indexOf("CN="));
            //"CN=XX"不是最后一个，所以后面一定有","
            String cn = temp.substring(3, temp.indexOf(","));
            if (cn.length() > 0) {
                return cn.equals(hostname);
            }
        }
        return false;
    }

    /**
     * 导入证书
     */
    private KeyStore getKeyStore() {
        // 添加https证书
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);

            // 从文件中获取
            // InputStream is = App.getApp().getAssets().open("rootCA.crt");
            // 从代码中获取
            InputStream is = new Buffer().writeUtf8(ROOT_CA_CERT).inputStream();
            // 签名文件设置证书
            keyStore.setCertificateEntry("0", certificateFactory.generateCertificate(is));
            is.close();
            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取单例引用
     */
    public static OkHttpInstance2 getInstance() {
        OkHttpInstance2 inst = mInstance;
        if (inst == null) {
            synchronized (OkHttpInstance2.class) {
                inst = mInstance;
                if (inst == null) {
                    inst = new OkHttpInstance2();
                    mInstance = inst;
                }
            }
        }
        return inst;
    }

    /**
     * 获取 OkHttp对象
     */
    public static OkHttpClient getmOkHttpClient() {
        return OkHttpInstance2.getInstance().mOkHttpClient;
    }

    /**
     * 获取主线程句柄
     */
    public static Handler getMainThreadHandler() {
        return OkHttpInstance2.getInstance().okHttpHandler;
    }
}
