package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1);
        user.setEmailAddress("test@example.com");
        user.setPassword("password123");

        when(userMapper.selectUserById(1)).thenReturn(user);

        User result = userService.getUserById(1);
        assertEquals(user, result);
    }

    @Test
    public void testLogin() {
        User user = new User();
        user.setEmailAddress("test@example.com");
        user.setPassword("password123");

        when(userMapper.login(Map.of("email_address", "test@example.com", "password", "password123"))).thenReturn(user);

        User result = userService.login("test@example.com", "password123");
        assertEquals(user, result);
    }
}
