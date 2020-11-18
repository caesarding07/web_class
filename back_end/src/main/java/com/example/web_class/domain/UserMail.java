package com.example.web_class.domain;

import lombok.Data;

/**
 * @ClassName: UserMail
 * @Description:
 * @Author CaesarDing
 * @Date 2020/11/18
 * @Version 1.0.0
 */
@Data
public class UserMail {
    private int id;
    private String mailName;
    private int userId;
    private int isUsed;
}
