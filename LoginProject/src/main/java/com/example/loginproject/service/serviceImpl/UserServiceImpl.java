package com.example.loginproject.service.serviceImpl;

import com.example.loginproject.entity.User;
import com.example.loginproject.mapper.UserMapper;
import com.example.loginproject.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User Login(String name, String password) {
        return userMapper.loginUser(name,password);
    }

    @Override
    public User changePassword(String name, String oldPassword, String newPassword) {
        User user=userMapper.loginUser(name,oldPassword);
        if(user!=null){
            user.setPassword(newPassword);
            userMapper.updateUser(user);
        }
        return user;
    }

    @Override
    public User register(String name, String password, String email, Date birthday, String portrait) {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setBirthday(birthday);
        user.setPortrait(portrait);
        userMapper.addUser(user);
        return user;
    }

    @Override
    public User getUserInfo(String name) {
        return userMapper.getUserInfo(name);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void addMoney(String name, int money) {
        userMapper.addMoney(name, money);
    }
}
