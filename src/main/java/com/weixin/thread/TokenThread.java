package com.weixin.thread;

import com.weixin.entity.POJO.Token;
import com.weixin.service.TokenService;
import com.weixin.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenThread implements Runnable {
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);
    // 第三方用户唯一凭证
    public static String appid = "";
    // 第三方用户唯一凭证密钥
    public static String appsecret = "";
    public static Token accessToken = null;

    private static ApplicationContext ctx=null;

    private TokenService tokenService;

    public TokenThread(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public void run() {
        while (true) {
            try {
                accessToken = CommonUtil.getToken(appid, appsecret);
                if (null != accessToken) {
                    //调用存储到数据库
                    tokenService.saveToken(accessToken.getAccessToken(),accessToken.getExpiresIn(),new Date());

                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getAccessToken());
                    System.out.println("获取access_token成功，有效时长{}秒 token:{}"+accessToken.getExpiresIn()+"#####"+accessToken.getAccessToken());

                    // 休眠7000秒
                    Thread.sleep((accessToken.getExpiresIn() - 200)*1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
        }
    }

}
