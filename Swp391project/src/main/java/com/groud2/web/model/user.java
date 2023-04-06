/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

public class user {

    public String userId;
    public String fullname;
    public String account;
    public String password;
    public String phonenumber;
    public String address;
    public String email;
    public String gender;
    public String bod;
    public String userimages;
    public String role;

    public user(String account) {
        this.account = account;
    }

    public String getUserimages() {
        return userimages;
    }

    public void setUserimages(String userimages) {
        this.userimages = userimages;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public user() {

    }

    public user(String account, String password) {
        this.account = account;
        this.password = password;
    }

    // this generate not include user role
    public user(String userId, String fullname, String account, String password, String phonenumber, String address, String email, String gender, String bod, String userimages) {
        this.userId = userId;
        this.fullname = fullname;
        this.account = account;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.bod = bod;
        this.userimages = userimages;
        this.gender = gender;
    }

    //this generate include user role
    public user(String userId, String fullname, String account, String password, String phonenumber, String address, String email, String gender, String bod, String userimages, String role) {
        this.userId = userId;
        this.fullname = fullname;
        this.account = account;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.bod = bod;
        this.userimages = userimages;
        this.role = role;
    }

    //this generate include user role
  
    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
