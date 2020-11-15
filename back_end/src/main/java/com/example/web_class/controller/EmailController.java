package com.example.web_class.controller;

import com.example.web_class.domain.Mail;
import com.example.web_class.service.MailService;
import com.example.web_class.utils.JsonData;
import com.example.web_class.utils.Result;
import com.example.web_class.utils.ResultGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private MailService mailService;

    @PostMapping("add")
    public Result add(
    ){
        return null;
    }

    @PostMapping("logout")
    public Result logout(){
        return null;
    }

    @PostMapping("select")
    public Result select(){
        return null;
    }

    @PostMapping("modify")
    public Result modify(){
        return null;
    }

    @PostMapping("list")
    public Result list(){
        List<Mail> list = mailService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }

}
