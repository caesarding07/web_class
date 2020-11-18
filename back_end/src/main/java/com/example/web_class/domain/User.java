package com.example.web_class.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
//无参构造器
@NoArgsConstructor
//全参构造器
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String mobile;
    //这里里面存储和user有关的邮箱信息
    private List<Mail> userMailList;
}
