package com.weixin.dao;

import com.weixin.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    //注入Dao实现类依赖
    @Resource
    private UserDao userDao;
    @Test
    public void queryById() throws Exception {
        User user = userDao.queryById(1000);
        System.out.println(user);
    }

}