package com.example.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {

    private int id;
    @NotNull(message = "メールアドレスを入力してください。")
    private String emailAddress;
    @NotNull(message = "パスワードを入力してください。")
    private String password;
}
