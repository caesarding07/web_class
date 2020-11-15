package com.example.web_class.controller;

import com.example.web_class.domain.User;
import com.example.web_class.service.UserService;
import com.example.web_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

//    响应用户对于页面的get请求，去掉以后无法显示页面
    @GetMapping("api/user/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("web_class");
        return modelAndView;
    }

    @PostMapping("api/user/login")
    public JsonData login(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password,
            ModelAndView modelAndView){
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        String token=userService.login(user);
        System.out.println(username+":"+password+"==="+token);
        return token != null ? JsonData.buildSuccess(token):JsonData.buildError("error");
    }
    @PostMapping("api/user/register")
    public JsonData register(){
        User user = new User();
        return null;
    }
}
