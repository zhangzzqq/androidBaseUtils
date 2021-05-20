

#证书在浏览器中网页 点击域名左边安全进行查看和下载

OkHttpInstance2  单向认证
OkHttpInstance  双向认证




#单向认证 信任自签名证书 
 private SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext context = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = {new MyX509TrustManager()};
        context.init(null, trustManagers, new SecureRandom());
        return context.getSocketFactory();
    }
    
        private class MyX509TrustManager implements X509TrustManager {
     
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
     
            }
     
            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                if (chain == null) {
                    throw new CertificateException("checkServerTrusted: X509Certificate array is null");
                }
                if (chain.length < 1) {
                    throw new CertificateException("checkServerTrusted: X509Certificate is empty");
                }
                if (!(null != authType && authType.equals("ECDHE_RSA"))) {
                    throw new CertificateException("checkServerTrusted: AuthType is not ECDHE_RSA");
                }
     
                //检查所有证书
                try {
                    TrustManagerFactory factory = TrustManagerFactory.getInstance("X509");
                    factory.init((KeyStore) null);
                    for (TrustManager trustManager : factory.getTrustManagers()) {
                        ((X509TrustManager) trustManager).checkServerTrusted(chain, authType);
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (KeyStoreException e) {
                    e.printStackTrace();
                }
     
                //获取本地证书中的信息
                String clientEncoded = "";
                String clientSubject = "";
                String clientIssUser = "";
                try {
                    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                    InputStream inputStream = getAssets().open("baidu.cer");
                    X509Certificate clientCertificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
                    clientEncoded = new BigInteger(1, clientCertificate.getPublicKey().getEncoded()).toString(16);
                    clientSubject = clientCertificate.getSubjectDN().getName();
                    clientIssUser = clientCertificate.getIssuerDN().getName();
                } catch (IOException e) {
                    e.printStackTrace();
                }
     
                //获取网络中的证书信息
                X509Certificate certificate = chain[0];
                PublicKey publicKey = certificate.getPublicKey();
                String serverEncoded = new BigInteger(1, publicKey.getEncoded()).toString(16);
     
                if (!clientEncoded.equals(serverEncoded)) {
                    throw new CertificateException("server's PublicKey is not equals to client's PublicKey");
                }
                String subject = certificate.getSubjectDN().getName();
                if (!clientSubject.equals(subject)) {
                    throw new CertificateException("server's subject is not equals to client's subject");
                }
                String issuser = certificate.getIssuerDN().getName();
                if (!clientIssUser.equals(issuser)) {
                    throw new CertificateException("server's issuser is not equals to client's issuser");
                }
            }
     
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }
        
        builder.sslSocketFactory(getSSLSocketFactory(), new MyX509TrustManager())
        
        
https://blog.csdn.net/u010560898/article/details/80245887


https://blog.csdn.net/yukaihuaboke/article/details/78926166

https://juejin.cn/post/6844903793096687630
https://juejin.cn/post/6844903793096687630


# 信任所有证书


     /**
      * 默认信任所有的证书
      * TODO 最好加上证书认证，主流App都有自己的证书
      *
      * @return
      */
     @SuppressLint("TrulyRandom")
     private static SSLSocketFactory createSSLSocketFactory() {
         SSLSocketFactory sSLSocketFactory = null;
         try {
             SSLContext sc = SSLContext.getInstance("TLS");
             sc.init(null, new TrustManager[]{new TrustAllManager()},
                     new SecureRandom());
             sSLSocketFactory = sc.getSocketFactory();
         } catch (Exception e) {
         }
         return sSLSocketFactory;
     }

     private static class TrustAllManager implements X509TrustManager {
         @Override
         public void checkClientTrusted(X509Certificate[] chain, String authType)
                 throws CertificateException {
         }

         @Override
         public void checkServerTrusted(X509Certificate[] chain, String authType)
                 throws CertificateException {
         }

         @Override
         public X509Certificate[] getAcceptedIssuers() {
             return new X509Certificate[0];
         }
     }

     public static class TrustAllHostnameVerifier implements HostnameVerifier {
         @Override
         public boolean verify(String hostname, SSLSession session) {
             return true;
         }
     }
     
     
 ## 可行方案  信任所有证书
 
 private static OkHttpClient mClient0 = new OkHttpClient.Builder()
             .connectTimeout(Constant.DEFAULT_NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
             .readTimeout(Constant.DEFAULT_IO_TIMEOUT, TimeUnit.MILLISECONDS)
             .writeTimeout(Constant.DEFAULT_IO_TIMEOUT, TimeUnit.MILLISECONDS)
 //            .sslSocketFactory(getSLLContext().getSocketFactory())
             .sslSocketFactory(createSSLSocketFactory())
             .hostnameVerifier(new NetworkUtility.TrustAllHostnameVerifier())
             .addInterceptor(chain -> {
                 Request.Builder builder = chain.request()
                         .newBuilder()
                         .addHeader("Content-Type", "application/json");
                 User user = AppGlobal.getUserInfo();
                 String uuid = user.getUid();
                 String token = user.getToken();
                 if (!"".equals(uuid) &&
                         uuid != null &&
                         !"".equals(token) &&
                         token != null) {
                     builder.addHeader("uid", uuid);
                     builder.addHeader("token", token);
                 }
                 return chain.proceed(builder.build());
             })
             .build();
   
   
   ##  demo 
   
   
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
                       .generateCertificate(CQuinoxlessApplication.getContext().getAssets().open(zhenshu)));
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
           builder.connectTimeout(Constant.DEFAULT_NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
                   .readTimeout(Constant.DEFAULT_IO_TIMEOUT, TimeUnit.MILLISECONDS)
                   .writeTimeout(Constant.DEFAULT_IO_TIMEOUT, TimeUnit.MILLISECONDS)
   //            .sslSocketFactory(getSLLContext().getSocketFactory())
   //                .sslSocketFactory(createSSLSocketFactory())
   //                .hostnameVerifier(new NetworkUtility.TrustAllHostnameVerifier())
                   .addInterceptor(chain -> {
                       Request.Builder builder2 = chain.request()
                               .newBuilder()
                               .addHeader("Content-Type", "application/json");
                       User user = AppGlobal.getUserInfo();
                       String uuid = user.getUid();
                       String token = user.getToken();
                       if (!"".equals(uuid) &&
                               uuid != null &&
                               !"".equals(token) &&
                               token != null) {
                           builder2.addHeader("uid", uuid);
                           builder2.addHeader("token", token);
                       }
                       return chain.proceed(builder2.build());
                   });
   //                .build();
   
           return builder.build();
       }
       
       
   
   