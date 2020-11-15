package com.example.web_class.controller;

import com.example.web_class.utils.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EmailController
 * @Description: 邮箱控制层
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/api/email/")
public class EmailController {

    @PostMapping("insert")
    public JsonData insert(
    ){
        return null;
    }


}
