package com.example.eguru_madproject;

public class Tadds {
    private String subject;
    private String medium;
    private String grade;
    private String fee;

    public Tadds(){}
    public Tadds(String subject, String medium, String grade, String fee){
        this.subject = subject;
        this.medium = medium;
        this.grade = grade;
        this.fee = fee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
