package com.example.eguru_madproject;

import android.widget.EditText;

public class instituteAds {
    private String et_name;
    private String et_classdetails;
    private String et_email;
    private String et_number;
    public instituteAds(){}
    public  instituteAds(String et_name, String et_classdetails, String et_email, String et_number)

    {
        this.et_name = et_name;
        this.et_classdetails = et_classdetails;
        this.et_email = et_email;
        this.et_number = et_number;
    }

    public String getEt_name() {
        return et_name;
    }

    public void setEt_name(String et_name) {
        this.et_name = et_name;
    }

    public String getEt_classdetails() {
        return et_classdetails;
    }

    public void setEt_classdetails(String et_classdetails) {
        this.et_classdetails = et_classdetails;
    }

    public String getEt_email() {
        return et_email;
    }

    public void setEt_email(String et_email) {
        this.et_email = et_email;
    }

    public String getEt_number() {
        return et_number;
    }

    public void setEt_number(String et_number) {
        this.et_number = et_number;
    }
}
