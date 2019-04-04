package com.ServerCloud.controller;

import com.ServerCloud.model.Graduation_user;
import com.ServerCloud.service.IGraduation_userService;
import com.ServerCloud.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Controller
public class Graduation_userController {
    @Resource
    private IGraduation_userService GraduationuserService;
    //登陆
    @RequestMapping("/userlogin.do")
    @ResponseBody
    public String userlogin(Graduation_user user, Model model, HttpServletRequest request) {
        String Md5= null;
        try {
            Md5 = Utils.EncoderByMd5(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        boolean flag = GraduationuserService.login(user.getUsername(),Md5);
        if(flag){
            Graduation_user u=GraduationuserService.selectUser(user.getUsername());
            return u.getUserid();
        }else{
            return "false";
        }
    }
    //注册
    @RequestMapping("/usersign.do")
    @ResponseBody
    public String usersign(Graduation_user user, Model model, HttpServletRequest request) {
        String Md5= null;
        try {
            Md5 = Utils.EncoderByMd5(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        user.setUserid(Long.toString(date.getTime()));
        user.setBalance("0");
        user.setPassword(Md5);
        boolean flag =GraduationuserService.insertUser(user);
        if(flag){
            Graduation_user u=GraduationuserService.selectUser(user.getUsername());
            return u.getUserid();
        }else{
            return "false";
        }
    }

    //获取用户数据
    @RequestMapping("/getGuser.do")
    @ResponseBody
    public String getbalance(String userid, Model model, HttpServletRequest request) {
        Graduation_user u =GraduationuserService.selectUserid(userid);
        return u.getUserid()+","+u.getUsername()+","+u.getBalance();
    }

    //更新用户余额
    @RequestMapping("/updatebalance.do")
    @ResponseBody
    public String updatebalance(Graduation_user user, Model model, HttpServletRequest request) {
        boolean b=GraduationuserService.updatebalance(user);
        return String.valueOf(b);
    }


    //更新用户密码
    @RequestMapping("/updatepassword.do")
    @ResponseBody
    public String updatepassword(Graduation_user user, Model model, HttpServletRequest request) {
        String Md5= null;
        try {
            Md5 = Utils.EncoderByMd5(user.getPassword());
            user.setPassword(Md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            boolean b=GraduationuserService.updatepassword(user);
            return String.valueOf(b);
        }
    }
}
