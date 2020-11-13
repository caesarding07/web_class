package com.example.login.controller;

import com.example.login.domain.User;
import com.example.login.service.UserService;
import com.example.login.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

//    响应用户对于页面的get请求，去掉以后无法显示页面
    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
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
}
