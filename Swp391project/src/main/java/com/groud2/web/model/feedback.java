/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author Admin
 */
public class feedback {
    private String No;
    private String name;
    private String Email;
    private String feedbacks;

    public feedback() {
    }

    public feedback(String No, String name, String Email, String feedbacks) {
        this.No = No;
        this.name = name;
        this.Email = Email;
        this.feedbacks = feedbacks;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String No) {
        this.No = No;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(String feedbacks) {
        this.feedbacks = feedbacks;
    }

   
    
    
     
}
