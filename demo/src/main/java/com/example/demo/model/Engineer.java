package com.example.demo.model;

import lombok.Data;

@Data
public class Engineer {
    private int id;

    private int userId;

    private String name;

    private int age;

    private String address;

    private String phoneNumber;

    private Boolean isDeleted;
}
