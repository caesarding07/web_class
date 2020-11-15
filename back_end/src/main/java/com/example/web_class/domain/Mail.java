package com.example.web_class.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: Mail
 * @Description: 邮箱
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */

@Setter
@Getter
@ToString
public class Mail {
    private int id;
    private String mailName;
    private int userId;
    private int isUsed;
}
