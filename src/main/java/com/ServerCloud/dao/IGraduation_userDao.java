package com.ServerCloud.dao;

import com.ServerCloud.model.Graduation_user;

public interface IGraduation_userDao {

    public Graduation_user selectUser(String username);
    public Graduation_user selectUserid(String userid);
    public boolean insertUser(Graduation_user graduation_user);
    public boolean updatebalance(Graduation_user graduation_user);
    public boolean updatepassword(Graduation_user graduation_user);
}
