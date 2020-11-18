package com.example.web_class.dao;

import com.example.web_class.domain.Mail;

import java.util.List;

/**
 * @ClassName: mailMapper
 * @Description: mail接口
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */
public interface MailMapper {
    //TODO 接口需要定义一下
    List<Mail> findAll();
    List<Mail> selectByMailName(String mail_name);
    int addUserMail(Mail mail);
    int deleteMail(int mail_id);
    int modifyMail(Mail mail);
}
