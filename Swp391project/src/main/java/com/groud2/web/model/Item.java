/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author anhha
 */
public class Item {
    private int id;
    private glasses glass;
    private int quantity;
    private String price;

    public Item() {
    }

    public Item(int id, glasses glass, int quantity, String price) {
        this.id = id;
        this.glass = glass;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(glasses glass, int quantity) {
        this.glass = glass;
        this.quantity = quantity;
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public glasses getGlass() {
        return glass;
    }

    public void setGlass(glasses glass) {
        this.glass = glass;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
