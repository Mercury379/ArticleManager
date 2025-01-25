package com.example.loginproject.service;

import com.example.loginproject.entity.User;

import java.util.Date;

public interface UserService {
    public User Login(String name,String password);
    public User changePassword(String name,String oldPassword,String newPassword);
    public User register(String name, String password, String email, Date birthday, String portrait);
    public User getUserInfo(String name);
    public void updateUser(User user);
    public void addMoney(String name,int money);
}
