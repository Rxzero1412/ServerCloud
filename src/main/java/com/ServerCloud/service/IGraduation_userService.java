package com.ServerCloud.service;

import com.ServerCloud.model.Graduation_user;

public interface IGraduation_userService {

    public Graduation_user selectUser(String username);
    public Graduation_user selectUserid(String userid);
    public boolean updatebalance(Graduation_user graduation_user);
    public boolean updatepassword(Graduation_user graduation_user);

    public boolean login(String username, String password);
    public boolean insertUser(Graduation_user graduation_user);
}
