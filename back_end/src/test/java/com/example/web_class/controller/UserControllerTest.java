package com.example.web_class.controller;

import com.example.web_class.WebClassApplication;
import com.example.web_class.domain.User;
import com.example.web_class.service.UserService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*不加这两个注解会出现空指针异常*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebClassApplication.class})
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
