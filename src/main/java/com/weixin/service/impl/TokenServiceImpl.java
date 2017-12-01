package com.weixin.service.impl;

import com.weixin.dao.TokenDao;
import com.weixin.entity.POJO.Token;
import com.weixin.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    private TokenDao tokenDao;

    public Token getToken() {
        if(tokenDao != null){
            System.out.println("service 注入");
        }
        return tokenDao.getToken();
    }

    public int saveToken(String accessToken, int expiresIn,  Date createTime){
        return tokenDao.saveToken(accessToken,expiresIn,createTime);
    }

}
