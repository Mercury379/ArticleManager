package com.example.loginproject.mapper;

import com.example.loginproject.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    User loginUser(String name,String password);
    void addUser(User u);
    void updateUser(User u);
    User getUserInfo(String name);
    void addMoney(String name,int money);
}
