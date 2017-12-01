package com.weixin.web;

import com.weixin.entity.POJO.Token;
import com.weixin.service.TokenService;
import com.weixin.thread.TokenThread;
import com.weixin.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
@Controller
public class InitServlet extends HttpServlet {
    /*
            InitServlet类只重写了init()方法，并没有重写doGet()和doPost()两个方法，
            因为我们并不打算让 InitServlet来处理访问请求。
            init()方法的实现也比较简单，先获取在web.xml中配置的参数appid和appsecret，
            再启动 线程TokenThread定时获取access_token
     */
    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public void init() throws ServletException {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:/spring/spring-dao.xml");
        TokenService tokenService = (TokenService) app.getBean("tokenService");
        // 获取web.xml中配置的参数
        TokenThread.appid = getInitParameter("appid");
        TokenThread.appsecret = getInitParameter("appsecret");
        log.info("weixin api appid:{}", TokenThread.appid);
        log.info("weixin api appsecret:{}", TokenThread.appsecret);
//        ServletContext servletContext = this.getServletContext();

        if (tokenService != null) {
            System.out.println("tokenService is not null");
        } else {
            System.out.println("tokenService is null");
        }
        Token token = tokenService.getToken();
        System.out.println("token = " + token);
        // 未配置appid、appsecret时给出提示
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
            log.error("appid and appsecret configuration error, please check carefully.");
        } else {
            // 启动定时获取access_token的线程
            new Thread(new TokenThread(tokenService)).start();
        }
    }
}

