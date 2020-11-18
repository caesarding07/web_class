package com.example.web_class.service.impl;

import com.example.web_class.dao.MailMapper;
import com.example.web_class.domain.Mail;
import com.example.web_class.service.MailService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName: MailServiceImpl
 * @Description: mail接口实现
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */
@Service
public class MailServiceImpl implements MailService {
    //获取sqlSession的工具类
    String resource= "config/mybatis-config.xml";
    //    JAVA中getResourceAsStream这个方法是用来获取配置文件
    InputStream inputStream= Resources.getResourceAsStream((resource));
    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession=sqlSessionFactory.openSession(true);
    MailMapper mailMapper = sqlSession.getMapper(MailMapper.class);

    public MailServiceImpl() throws IOException {
    }

    @Override
    public int addUserMail(Mail mail) {
        mail.setIs_used(1);
        int code = mailMapper.addUserMail(mail);
        return code;
    }

    @Override
    public int deleteMail(int mail_id) {
        int code = mailMapper.deleteMail(mail_id);
        return code;
    }

    @Override
    public List<Mail> select(String mail_name) {
        List<Mail> list = mailMapper.selectByMailName(mail_name);
        return list;
    }

    @Override
    public int modify(Mail mail) {
        int code = mailMapper.modifyMail(mail);
        return code;
    }

    @Override
    public String logout(Mail mail) {
        return null;
    }

    @Override
    public List<Mail> findAll() {
        List<Mail> list = mailMapper.findAll();
        return list;
    }
}
