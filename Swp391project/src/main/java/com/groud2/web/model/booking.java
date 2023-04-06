/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author asus
 */
public class booking {

    private String bookingId;
    private String name;
    private String phone;
    private String email;
    private String day;
    private String time;
    private String medical;
    private String payment;
    private String sbtime;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public booking(String bookingId, String name, String phone, String email, String day, String time, String medical, String payment, String sbtime, String status) {
        this.bookingId = bookingId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.day = day;
        this.time = time;
        this.medical = medical;
        this.payment = payment;
        this.sbtime = sbtime;
        this.status = status;
    }
    
    public booking() {
    }

    public booking(String bookingId, String name, String phone, String day, String time, String medical, String payment, String sbtime) {
        this.bookingId = bookingId;
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.time = time;
        this.medical = medical;
        this.payment = payment;
        this.sbtime = sbtime;
    }
    

   
    public booking(String bookingId, String name, String phone, String email, String day, String time, String medical, String payment, String sbtime) {
        this.bookingId = bookingId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.day = day;
        this.time = time;
        this.medical = medical;
        this.payment = payment;
        this.sbtime = sbtime;
    }
    public String getSbtime() {
        return sbtime;
    }

    public void setSbtime(String sbtime) {
        this.sbtime = sbtime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}
