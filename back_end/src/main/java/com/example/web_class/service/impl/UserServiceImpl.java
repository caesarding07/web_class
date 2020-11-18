package com.example.web_class.service.impl;

import com.example.web_class.dao.UserMapper;
import com.example.web_class.domain.User;
import com.example.web_class.service.UserService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    public static Map<String, User> sessionMap=new HashMap<>();
            //获取sqlSession的工具类
    String resource= "config/mybatis-config.xml";
    //    JAVA中getResourceAsStream这个方法是用来获取配置文件
    InputStream inputStream= Resources.getResourceAsStream((resource));
    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession=sqlSessionFactory.openSession(true);
    UserMapper userMapper =sqlSession.getMapper(UserMapper.class);

    public UserServiceImpl() throws IOException {
    }

    @Override
    public String login(User user){
        System.out.println("====正在查询数据库====");
        // String result = "";
        User result = userMapper.selectByUsernameAndPassword(user);
        System.out.println("查询结果:"+result);
        if (result==null){
            return null;
        }else {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token,user);
            return token;
        }
    }

}
