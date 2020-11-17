package com.example.web_class.controller;

import com.example.web_class.domain.Mail;
import com.example.web_class.service.MailService;
import com.example.web_class.utils.JsonData;
import com.example.web_class.utils.Result;
import com.example.web_class.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: EmailController
 * @Description: 邮箱控制层
 * @Author CaesarDing
 * @Date 2020/11/15
 * @Version 1.0.0
 */
//origins:允许可访问的域列表 maxAge:准备响应前的缓存持续的最大时间
@CrossOrigin(origins = "*",maxAge = 3600)
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
