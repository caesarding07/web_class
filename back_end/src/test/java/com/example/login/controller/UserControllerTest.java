package com.example.login.controller;

import com.example.login.LoginApplication;
import com.example.login.domain.User;
import com.example.login.service.UserService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
/*不加这两个注解会出现空指针异常*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LoginApplication.class})
class UserControllerTest {
    @Autowired
    private UserService userService;

    @Test
    public void testLoginFail(){
        User user=new User();
        user.setUsername("feifangg");
        user.setPassword("654321");
        String token=userService.login(user);
        TestCase.assertTrue(token==null);
    }
    @Test
    public void testLoginSuccess(){
        User user=new User();
        user.setUsername("feifan");
        user.setPassword("12345");
        String token=userService.login(user);
        TestCase.assertTrue(token!=null);
    }
}
