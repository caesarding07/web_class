package com.example.login.service.impl;

import com.example.login.dao.UserMapper;
import com.example.login.domain.User;
import com.example.login.service.UserService;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.lf5.util.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    public static Map<String, User> sessionMap=new HashMap<>();

//        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
    //        获取sqlSession的工具类
    String resource= "/config/mybatis-config.xml";
    //    JAVA中getResourceAsStream这个方法是用来获取配置文件
    InputStream inputStream= Resource.class.getResourceAsStream((resource));
    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession=sqlSessionFactory.openSession();
    UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
    @Override
    public String login(User user){
        System.out.println("====正在查询数据库====");
        User result = userMapper.selectByUsernameAndPassword(user);
        System.out.println("返回结果:"+result);
//        int result = 1;
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
