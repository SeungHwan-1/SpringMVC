package com.ohgiraffers.chap08securitysession.user.dto;

import com.ohgiraffers.chap08securitysession.common.UserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginUserDTO {

    private int userCode;

    private String userId;
    private String userName;
    private String password;
    private UserRole role;

    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "userCode=" + userCode +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return role;
    }

    //이건 설명이필요함
    public List<String> getRole(){
        if(this.role.getRole().length() > 0){
            return Arrays.asList(this.role.getRole().split(","));
        }
        return new ArrayList<>();
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LoginUserDTO(int userCode, String userId, String userName, String password, UserRole role) {
        this.userCode = userCode;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public LoginUserDTO() {
    }
}
