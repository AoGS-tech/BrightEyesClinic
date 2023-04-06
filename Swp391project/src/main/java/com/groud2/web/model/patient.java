/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author nguye
 */
public class patient extends user{
    String patientId,Idcard,userid,timeOrder,medicalDate,medicalTime,symptom,conclude,medicine,doctorName,status,process;
    user user ;
    public patient( user user, String patientId, String Idcard, String userid, String timeOrder, String medicalDate, String medicalTime, String symptom, String conclude, String medicine, String doctorName, String status, String process) {
        this.user=user;
        this.patientId = patientId;
        this.Idcard = Idcard;
        this.userid = userid;
        this.timeOrder = timeOrder;
        this.medicalDate = medicalDate;
        this.medicalTime = medicalTime;
        this.symptom = symptom;
        this.conclude = conclude;
        this.medicine = medicine;
        this.doctorName = doctorName;
        this.status = status;
        this.process = process;
    }
public patient(  String patientId, String Idcard, String userid, String timeOrder, String medicalDate, String medicalTime, String symptom, String conclude, String medicine, String doctorName, String status, String process) {
       
        this.patientId = patientId;
        this.Idcard = Idcard;
        this.userid = userid;
        this.timeOrder = timeOrder;
        this.medicalDate = medicalDate;
        this.medicalTime = medicalTime;
        this.symptom = symptom;
        this.conclude = conclude;
        this.medicine = medicine;
        this.doctorName = doctorName;
        this.status = status;
        this.process = process;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public patient() {
    }
    
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getIdcard() {
        return Idcard;
    }

    public void setIdcard(String Idcard) {
        this.Idcard = Idcard;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getMedicalDate() {
        return medicalDate;
    }

    public void setMedicalDate(String medicalDate) {
        this.medicalDate = medicalDate;
    }

    public String getMedicalTime() {
        return medicalTime;
    }

    public void setMedicalTime(String medicalTime) {
        this.medicalTime = medicalTime;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getConclude() {
        return conclude;
    }

    public void setConclude(String conclude) {
        this.conclude = conclude;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

  
    

}