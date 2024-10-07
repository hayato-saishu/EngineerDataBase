package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/user/login")
    public User login(HttpSession session, @RequestParam String emailAddress, @RequestParam String password) {
        User user = service.login(emailAddress, password);
        if(user == null) {
            return null;
        }
        session.setAttribute("user", user);
        return user;
    }
}
