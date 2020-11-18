package com.example.web_class.service;


import com.example.web_class.domain.Mail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MailService
 * @Description: 邮箱服务
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */
@Service
public interface MailService {
    int addUserMail(Mail mail);
    int deleteMail(int mail_id);
    List<Mail> select(String mail_name);
    int modify(Mail mail);
    String logout(Mail mail);
    List<Mail> findAll();
}
