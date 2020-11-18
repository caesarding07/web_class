package com.example.web_class.domain;


import lombok.*;

/**
 * @ClassName: Mail
 * @Description: 邮箱
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */

@Data
@Builder
//无参构造器
@NoArgsConstructor
//全参构造器
@AllArgsConstructor
public class Mail {
    private int id;
    private String mail_name;
    private int user_id;
    private int is_used;
}
