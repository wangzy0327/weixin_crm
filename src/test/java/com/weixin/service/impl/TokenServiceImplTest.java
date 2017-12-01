package com.weixin.service.impl;

import com.weixin.entity.POJO.Token;
import com.weixin.service.TokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TokenServiceImplTest {

    @Autowired
    private TokenService tokenService;
    @Test
    public void getToken() throws Exception {
        Token token = tokenService.getToken();
        System.out.println(token);
    }

    @Test
    public void main() throws Exception {
    }

}