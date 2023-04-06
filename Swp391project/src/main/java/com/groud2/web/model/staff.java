/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author Ao
 */
public class staff extends user{
    String citizenID, dateStart, educationLevel, salary;

    public staff(String citizenID, String dateStart, String educationLevel, String salary, String userId, String fullname, String account, String password, String phonenumber, String address, String email, String gender, String bod, String userimages) {
        super(userId, fullname, account, password, phonenumber, address, email, gender, bod, userimages);
        this.citizenID = citizenID;
        this.dateStart = dateStart;
        this.educationLevel = educationLevel;
        this.salary = salary;
    }
    
    
}
