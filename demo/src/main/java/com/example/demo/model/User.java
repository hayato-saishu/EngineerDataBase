package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {

    private int id;
    @NotBlank(message = "メールアドレスを入力してください。")
    private String emailAddress;
    @NotBlank(message = "パスワードを入力してください。")
    private String password;
}
