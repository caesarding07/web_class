package com.example.web_class.service;

import com.example.web_class.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String login(User user);
}
