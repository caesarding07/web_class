package com.example.web_class.controller;


import com.example.web_class.domain.User;
import com.example.web_class.service.UserService;
import com.example.web_class.utils.JsonData;
import com.example.web_class.utils.Result;
import com.example.web_class.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
*@ClassName: UserController
*@Description 用户控制层
*@Author CaesarDing
*@Date 2020/11/15
*@Version 1.0.0
*/

@CrossOrigin(origins = "*",maxAge = 3600)
@Api(value="用户controller",tags={"用户操作接口"})
@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户信息",tags={"获取用户信息"},notes="注意问题点")
    @PostMapping("login")
    public Result login(@RequestBody User user){
//        User user = User.builder().username(username).password(password).build();
        System.out.println(user);
        System.out.println(user.getUsername()+":"+user.getPassword());
        String data = userService.login(user);
        return data!=null? ResultGenerator.genSuccessResult(data):ResultGenerator.genFailResult("账号密码错误！");
    };

    @PostMapping("register")
    public JsonData register(){
        User user = new User();
        return null;
    }
}
