package com.example.loginproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String name;
    private String password;
    private String money;
    private String email;
    private Date birthday;
    private String portrait;
}
