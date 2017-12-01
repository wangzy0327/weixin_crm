package com.weixin.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

//模仿https请求,获取token
//对于https请求，需要一个证书信任管理器，这个管理类需要自己定义，但需要实现X509TrustManager接口
public class MyX509TrustManager implements X509TrustManager {
    //检查客户端证书
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }
    //检查服务器端证书
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }
    //返回受信任的x509证书数组
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
