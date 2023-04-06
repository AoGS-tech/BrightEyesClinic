/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author anhha
 */
public class payment{
    String BillId,userId,bookingId,service,amount;

    public payment() {
    }

    public payment(String BillId, String userId, String bookingId, String service, String amount) {
        this.BillId = BillId;
        this.userId = userId;
        this.bookingId = bookingId;
        this.service = service;
        this.amount = amount;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String BillId) {
        this.BillId = BillId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
}
