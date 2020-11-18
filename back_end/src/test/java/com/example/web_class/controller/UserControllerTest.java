package com.example.web_class.controller;

import com.example.web_class.WebClassApplication;
import com.example.web_class.dao.MailMapper;
import com.example.web_class.domain.User;
import com.example.web_class.service.UserService;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

/*不加这两个注解会出现空指针异常*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebClassApplication.class})
class UserControllerTest {
    //获取sqlSession的工具类
    String resource= "config/mybatis-config.xml";
    //    JAVA中getResourceAsStream这个方法是用来获取配置文件
    InputStream inputStream= Resources.getResourceAsStream((resource));
    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession=sqlSessionFactory.openSession(true);
    MailMapper mailMapper = sqlSession.getMapper(MailMapper.class);

    @Autowired
    private UserService userService;

    UserControllerTest() throws IOException {
    }


    @Test
    void login() {
        //正测试
        User user=new User();
        user.setUsername("dingtao");
        user.setPassword("12345");
        String token=userService.login(user);
        TestCase.assertTrue(token!=null);
        //反测试
        User user1=new User();
        user.setUsername("feifan");
        user.setPassword("12345");
        String token1=userService.login(user);
        TestCase.assertTrue(token1==null);
    }

    @Test
    void register() {
    }
}
