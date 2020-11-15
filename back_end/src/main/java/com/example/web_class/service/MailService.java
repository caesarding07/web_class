package com.example.web_class.service;


import com.example.web_class.domain.Mail;

import java.util.List;

/**
 * @ClassName: MailService
 * @Description: 邮箱服务
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */

public interface MailService {
    String add(Mail mail);
    String select(Mail mail);
    String modify(Mail mail);
    String logout(Mail mail);
    List<Mail> findAll();
}
