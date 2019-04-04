package com.ServerCloud.service.impl;

import com.ServerCloud.dao.IGraduation_userDao;
import com.ServerCloud.model.Graduation_user;
import com.ServerCloud.service.IGraduation_userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.DoubleSummaryStatistics;

@Service("userService")
public class Graduation_userServiceImpl implements IGraduation_userService {

    @Resource
    private IGraduation_userDao userDao;

    public Graduation_user selectUser(String username) {
        return this.userDao.selectUser(username);
    }

    @Override
    public Graduation_user selectUserid(String userid) {
        return userDao.selectUserid(userid);
    }

    @Override
    public boolean updatebalance(Graduation_user graduation_user) {
        Graduation_user u=selectUserid(graduation_user.getUserid());
        float d=Float.valueOf(graduation_user.getBalance())+Float.valueOf(u.getBalance());
        u.setBalance(String.format("%1.2f",d));
        return userDao.updatebalance(u);
    }

    @Override
    public boolean updatepassword(Graduation_user graduation_user) {
        return userDao.updatepassword(graduation_user);
    }

    public boolean login(String username, String password){
        Graduation_user user = userDao.selectUser(username);
        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    @Override
    public boolean insertUser(Graduation_user graduation_user) {
        return this.userDao.insertUser(graduation_user);
    }
}
