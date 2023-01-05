package com.niit.userlogindetails.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userLoginTable")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private int userPhoneNo;

    public User(String userId, String userName, String userPassword, int userPhoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhoneNo = userPhoneNo;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(int userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNo=" + userPhoneNo +
                '}';
    }
}
