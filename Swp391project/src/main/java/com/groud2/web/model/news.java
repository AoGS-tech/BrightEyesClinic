/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;



/**
 *
 * @author nguye
 */
public class news  {

    private String newsId, newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4;

    public news() {
    }

    public news( String newsname, String category, String authour, String datepublic, String images1, String images2, String images3, String images4, String newscontent1, String newscontent2, String newscontent3, String newscontent4, String issue1, String issue2, String issue3, String issue4) {
      
        this.newsname = newsname;
        this.category = category;
        this.authour = authour;
        this.datepublic = datepublic;
        this.images1 = images1;
        this.images2 = images2;
        this.images3 = images3;
        this.images4 = images4;
        this.newscontent1 = newscontent1;
        this.newscontent2 = newscontent2;
        this.newscontent3 = newscontent3;
        this.newscontent4 = newscontent4;
        this.issue1 = issue1;
        this.issue2 = issue2;
        this.issue3 = issue3;
        this.issue4 = issue4;
    }
    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthour() {
        return authour;
    }

    public void setAuthour(String authour) {
        this.authour = authour;
    }

    public String getDatepublic() {
        return datepublic;
    }

    public void setDatepublic(String datepublic) {
        this.datepublic = datepublic;
    }

    public String getImages1() {
        return images1;
    }

    public void setImages1(String images1) {
        this.images1 = images1;
    }

    public String getImages2() {
        return images2;
    }

    public void setImages2(String images2) {
        this.images2 = images2;
    }

    public String getImages3() {
        return images3;
    }

    public void setImages3(String images3) {
        this.images3 = images3;
    }

    public String getImages4() {
        return images4;
    }

    public void setImages4(String images4) {
        this.images4 = images4;
    }

    public String getNewscontent1() {
        return newscontent1;
    }

    public void setNewscontent1(String newscontent1) {
        this.newscontent1 = newscontent1;
    }

    public String getNewscontent2() {
        return newscontent2;
    }

    public void setNewscontent2(String newscontent2) {
        this.newscontent2 = newscontent2;
    }

    public String getNewscontent3() {
        return newscontent3;
    }

    public void setNewscontent3(String newscontent3) {
        this.newscontent3 = newscontent3;
    }

    public String getNewscontent4() {
        return newscontent4;
    }

    public void setNewscontent4(String newscontent4) {
        this.newscontent4 = newscontent4;
    }

    public String getIssue1() {
        return issue1;
    }

    public void setIssue1(String issue1) {
        this.issue1 = issue1;
    }

    public String getIssue2() {
        return issue2;
    }

    public void setIssue2(String issue2) {
        this.issue2 = issue2;
    }

    public String getIssue3() {
        return issue3;
    }

    public void setIssue3(String issue3) {
        this.issue3 = issue3;
    }

    public String getIssue4() {
        return issue4;
    }

    public void setIssue4(String issue4) {
        this.issue4 = issue4;
    }
}
