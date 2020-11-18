package com.example.web_class.domain;

import lombok.*;

@Data
@Builder
//无参构造器
@NoArgsConstructor
//全参构造器
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String mobile;
}
