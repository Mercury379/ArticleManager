package com.example.loginproject.Controller;

import com.example.loginproject.entity.User;
import com.example.loginproject.entity.Writer;
import com.example.loginproject.service.UserService;
import com.example.loginproject.service.WriterService;
import com.example.loginproject.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    /**
     * 登录数据验证
     */
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseData login(@RequestBody Map<String, String> loginInfo) {
        User user=this.userService.Login(loginInfo.get("username"),loginInfo.get("password"));
        ResponseData responseData;
        if(user!=null){
            responseData = new ResponseData(200,"登录成功");
            responseData.putDataValue("username",user.getName());
        }else{
            responseData = new ResponseData(401,"用户名或密码错误");
        }
        return responseData;
    }
    @PostMapping("/changePass")
    @ResponseBody
    public ResponseData changePassword(@RequestBody Map<String, String> userInfo) {
        User user=this.userService.changePassword(userInfo.get("username"),userInfo.get("password"),userInfo.get("newpassword"));
        ResponseData responseData;
        if(user!=null){
            responseData = new ResponseData(200,"修改密码成功");
            responseData.putDataValue("username",user.getName());
        }else{
            responseData = new ResponseData(401,"用户名或密码错误,无法修改密码！");
        }
        return responseData;
    }
    @PostMapping("/register")
    @ResponseBody
    public ResponseData register(@RequestBody Map<String, String> userInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(userInfo.get("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user=this.userService.register(userInfo.get("username"),userInfo.get("password"),userInfo.get("email"),date,userInfo.get("portrait"));
        ResponseData responseData = new ResponseData(200,"注册成功");
        responseData.putDataValue("username",user.getName());
        return responseData;
    }
    @PostMapping("/getUserInfo")
    @ResponseBody
    public ResponseData getUserInfo(@RequestBody Map<String, String> userInfo) {
        User user=this.userService.getUserInfo(userInfo.get("username"));
        ResponseData responseData;
        if(user!=null){
            responseData = new ResponseData(200,"获取用户信息成功");
            responseData.putDataValue("userInfo",user);
        }else{
            responseData = new ResponseData(401,"获取用户信息失败");
        }
        return responseData;
    }
    @PostMapping("/updateUser")
    @ResponseBody
    public ResponseData updateUser(@RequestBody Map<String, String> userInfo) {
        User user=userService.getUserInfo(userInfo.get("username"));
        user.setEmail(userInfo.get("email"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(userInfo.get("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirthday(date);
        userService.updateUser(user);
        ResponseData responseData = new ResponseData(200,"获取用户信息成功");
        return responseData;
    }
    @PostMapping("/addMoney")
    @ResponseBody
    public ResponseData addMoney(@RequestBody Map<String, String> moneyInfo) {
        userService.addMoney(moneyInfo.get("name"),Integer.parseInt(moneyInfo.get("money")));
        ResponseData responseData;
        responseData = new ResponseData(200,"充值成功！");
        return responseData;
    }
}
