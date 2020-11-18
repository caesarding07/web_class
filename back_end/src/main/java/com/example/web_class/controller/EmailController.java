package com.example.web_class.controller;

import com.example.web_class.domain.Mail;
import com.example.web_class.service.MailService;
import com.example.web_class.utils.JsonData;
import com.example.web_class.utils.Result;
import com.example.web_class.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/mail/")
public class EmailController {
    @Autowired
    private MailService mailService;

    @PostMapping("add")
    public Result add(@RequestBody Mail mail
    ){
        int code = mailService.addUserMail(mail);
        System.out.println("创建 code"+code);
        return code != 0?ResultGenerator.genSuccessResult("创建成功"):ResultGenerator.genFailResult("创建失败");
    }

    @PostMapping("/delete")
    public JsonData deleteMail(@RequestParam("mail_id") int mail_id){
        System.out.println(mail_id);
        int res=mailService.deleteMail(mail_id);
//        int res = 1;
        System.out.println(res);
        return res==1?JsonData.buildSuccess("注销成功!"):JsonData.buildError("注销失败!");
    }

    @PostMapping("logout")
    public Result logout(){
        return null;
    }

    @PostMapping("select")
    public Result select(@RequestParam("mail_name") String mail_name){
        List<Mail> list = mailService.select(mail_name);
        return list!=null?ResultGenerator.genSuccessResult(list):ResultGenerator.genFailResult("没有该邮箱！");
    }

    @PostMapping("modify")
    public Result modify(@RequestBody Mail mail){
        int code = mailService.modify(mail);
        System.out.println("修改 code"+code);
        return code != 0?ResultGenerator.genSuccessResult("修改成功"):ResultGenerator.genFailResult("修改失败");
    }

    @PostMapping("list")
    public Result list(){
        List<Mail> list = mailService.findAll();
        return list!=null?ResultGenerator.genSuccessResult(list):ResultGenerator.genFailResult("没有用户注册邮箱");
    }

}
