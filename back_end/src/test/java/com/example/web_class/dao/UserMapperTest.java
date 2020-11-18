package com.example.web_class.dao;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.ibatis.io.Resources;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: UserMapperTest
 * @Description:
 * @Author CaesarDing
 * @Date 2020/11/18
 * @Version 1.0.0
 */
class UserMapperTest {

    @Test
    void selectByUsernameAndPassword() {
        //            获取sqlSession的工具类
    String resource= "config/mybatis-config.xml";
//    //    JAVA中getResourceAsStream这个方法是用来获取配置文件
//    InputStream inputStream= Resource.class.getResourceAsStream((resource));
//    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//    SqlSession sqlSession=sqlSessionFactory.openSession(true);
//    UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
    }
}