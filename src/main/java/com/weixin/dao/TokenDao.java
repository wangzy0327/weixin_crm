package com.weixin.dao;

import com.weixin.entity.POJO.Token;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.Date;
@Resource
public interface TokenDao {
    /**
     * 保存token
     * @return
     */
    Token getToken();

    /**
     * 获取token
     * @param accessToken
     * @param expiresIn
     * @param createTime
     * @return
     */
    int saveToken(@Param("accessToken")String accessToken, @Param("expiresIn")int expiresIn, @Param("createTime")Date createTime);

}
