package com.niit.userlogindetails.service;

import com.niit.userlogindetails.domain.User;

import java.util.Map;

public interface ISecurityGenerator {

    Map<String, String> tockenGenerator(User user);

}
