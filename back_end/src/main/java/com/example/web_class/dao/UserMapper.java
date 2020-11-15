package com.example.web_class.dao;

import com.example.web_class.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {
    User selectByUsernameAndPassword(User user);
}
