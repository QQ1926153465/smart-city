package com.briup.smartcity.bean;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class BaseUser {
    private Integer userId;

    private String username;

    private String password;

    private String telephone;

    private String realname;

    private String icon;

    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;

    private Integer status;

    private Integer role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


    public BaseUser(Integer userId,
                    String username,
                    String password,
                    String telephone,
                    String realname,
                    String icon,
                    Integer gender,
                    Date dob,
                    String email,
                    Date registerTime,
                    Integer status,
                    Integer role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.realname = realname;
        this.icon = icon;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.registerTime = registerTime;
        this.status = status;
        this.role = role;
    }

    public BaseUser() {
    }
}