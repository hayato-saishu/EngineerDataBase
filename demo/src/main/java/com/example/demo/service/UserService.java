package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserService {

    @Autowired
    UserMapper mapper;

    public User getUserById(int id) {
        return mapper.selectUserById(id);
    }

    public User login(String emailAddress, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("email_address", emailAddress);
        params.put("password", password);
        return mapper.login(params);
    }
}
