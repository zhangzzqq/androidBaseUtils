package com.demo;

/**
 * author: steven
 * date: 2021/1/19
 * desc: 信任所有证书
 */
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class TrustAllCerts implements X509TrustManager {
    public TrustAllCerts() {
    }

    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory factory = null;

        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init((KeyManager[])null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            factory = context.getSocketFactory();
        } catch (Exception var2) {
        }

        return factory;
    }

    public static class TrustAllHostnameVerifier implements HostnameVerifier {
        public TrustAllHostnameVerifier() {
        }

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}

