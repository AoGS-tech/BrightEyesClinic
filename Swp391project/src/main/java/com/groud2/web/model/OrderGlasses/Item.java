/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model.OrderGlasses;

import com.groud2.web.model.glasses;

/**
 *
 * @author anhha
 */
public class Item {
    private glasses glass;
    private int quantity;
    private double price;

    public Item() {
    }

    public Item(glasses glass, int quantity, double price) {
        this.glass = glass;
        this.quantity = quantity;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        
    }
    
}
