package com.example.web_class.controller;

import com.example.web_class.dao.MailMapper;
import com.example.web_class.domain.Mail;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: EmailControllerTest
 * @Description:
 * @Author CaesarDing
 * @Date 2020/11/19
 * @Version 1.0.0
 */
class EmailControllerTest {

    //获取sqlSession的工具类
    String resource= "config/mybatis-config.xml";
    //    JAVA中getResourceAsStream这个方法是用来获取配置文件
    InputStream inputStream= Resources.getResourceAsStream((resource));
    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession=sqlSessionFactory.openSession(true);
    MailMapper mailMapper = sqlSession.getMapper(MailMapper.class);

    EmailControllerTest() throws IOException {
    }

    @Test
    void add() {
        Mail mail = new Mail();
        mail.setMail_name("feifanf");
        mail.setIs_used(1);
        int code = mailMapper.addUserMail(mail);
        assertEquals(code,1);
    }

    @Test
    void deleteMail() {
        Mail mail = new Mail();
        mail.setId(1);
        int code = mailMapper.addUserMail(mail);
        assertEquals(code,1);
    }

    @Test
    void logout() {
    }

    @Test
    void select() {
        Mail mail = new Mail();
        mail.setMail_name("zjvivi");
        List<Mail> list = mailMapper.selectByMailName("zjvivi");
        TestCase.assertTrue(list!=null);
    }

    @Test
    void modify() {
        Mail mail = new Mail();
        mail.setId(3);
        mail.setMail_name("zjvivi");
        int code = mailMapper.modifyMail(mail);
        TestCase.assertTrue(code==1);
    }

    @Test
    void list() {
        List<Mail> list = mailMapper.findAll();
        TestCase.assertTrue(list!=null);
    }
}