package com.niit.userlogindetails.service;

import com.niit.userlogindetails.domain.User;

import java.util.List;

public interface IUserService {

    User register(User user);
    List<User> getAllUser();
    User login(String userId, String userPassword);
    boolean deleteUser(String id);

}
