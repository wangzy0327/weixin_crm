package com.weixin.dao;

import com.weixin.entity.Token;
import com.weixin.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TokenDaoTest {

    @Autowired
    private TokenDao tokenDao;

    @Test
    public void getToken() throws Exception {
        Token token = tokenDao.getToken();
        System.out.println(token);
    }

    @Test
    public void saveToken() throws Exception {
        Token token = CommonUtil.getToken("wx280016301ed1f819", "ea98a31c29e3495b44e91e0eab8c08a1");
        System.out.println(token);
        tokenDao.saveToken(token.getAccessToken(),token.getExpiresIn(),new Date());
    }

}