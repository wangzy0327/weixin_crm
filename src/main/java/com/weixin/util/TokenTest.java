package com.weixin.util;

import com.weixin.entity.Token;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class TokenTest {
    public static void main(String[] args) throws Exception {
        String appId = "wx280016301ed1f819";
        String appSecret = "ea98a31c29e3495b44e91e0eab8c08a1";
        Token token = CommonUtil.getToken(appId,appSecret);
        System.out.println(token);

//        //修改appID，secret
//        String tokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx280016301ed1f819&secret=ea98a31c29e3495b44e91e0eab8c08a1";
//        //建立连接
//        URL url = new URL(tokenUrl);
//        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
//
//        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
//        TrustManager[] tm = { new MyX509TrustManager() };
//        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
//        sslContext.init(null, tm, new java.security.SecureRandom());
//        // 从上述SSLContext对象中得到SSLSocketFactory对象
//        SSLSocketFactory ssf = sslContext.getSocketFactory();
//
//        httpUrlConn.setSSLSocketFactory(ssf);
//        httpUrlConn.setDoOutput(true);
//        httpUrlConn.setDoInput(true);
//
//        // 设置请求方式（GET/POST）
//        httpUrlConn.setRequestMethod("GET");
//
//        // 取得输入流
//        InputStream inputStream = httpUrlConn.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        //读取响应内容
//        StringBuffer buffer = new StringBuffer();
//        String str = null;
//        while ((str = bufferedReader.readLine()) != null) {
//            buffer.append(str);
//        }
//        bufferedReader.close();
//        inputStreamReader.close();
//        // 释放资源
//        inputStream.close();
//        httpUrlConn.disconnect();
//        //输出返回结果
//        System.out.println(buffer);
        //结果
        /*
        {"access_token":"hQzuLokk5Hetr9l5umWLJf7W7M-CWzxjOujOZbBuud9R1k1AqUmws-rpLfSMQWJXiNQ43iru8OSYwyWjCCyHthBnEGbJ0wXbBi4S2MgLmRGXxqMCuEWrjZSi8ywOkc3CGXIbAAAOFQ","expires_in":7200}
        **/
    }
}
