package com.ohgiraffers.chap08securitysession.user.dto;

public class SignupDTO {
    private String userId;

    private String userName;
    private String password;
    private String role;

    public SignupDTO(String userId, String userName, String userPass, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = userPass;
        this.role = role;
    }

    public SignupDTO() {
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

    public String getUserPass() {
        return password;
    }

    public void setUserPass(String userPass) {
        this.password = userPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SignupDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
