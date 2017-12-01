package com.weixin.service;

import com.weixin.entity.Token;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface TokenService {
    /**
     * 获取token
     * @return
     */
    Token getToken();

    int saveToken(String accessToken,int expiresIn, Date createTime);

}
