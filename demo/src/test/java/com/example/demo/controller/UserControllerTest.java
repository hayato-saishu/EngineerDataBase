package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1);
        user.setEmailAddress("test@example.com");
        user.setPassword("password123");

        when(userService.getUserById(1)).thenReturn(user);

        mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.emailAddress").value("test@example.com"))
                .andExpect(jsonPath("$.password").value("password123"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testLogin() throws Exception {
        User user = new User();
        user.setEmailAddress("test@example.com");
        user.setPassword("password123");

        when(userService.login("test@example.com", "password123")).thenReturn(user);

        mockMvc.perform(get("/api/user/login")
                        .param("emailAddress", "test@example.com")
                        .param("password", "password123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.emailAddress").value("test@example.com"))
                .andExpect(jsonPath("$.password").value("password123"));
    }
}
