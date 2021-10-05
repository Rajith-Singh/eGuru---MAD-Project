package com.example.eguru_madproject;

public class FeedbaackModel {
    private String studentName;
    private String studentEmail;
    private String studentFeedback;

    public FeedbaackModel(){

    }

    public FeedbaackModel(String studentName, String studentEmail, String studentFeedback) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentFeedback = studentFeedback;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(String studentFeedback) {
        this.studentFeedback = studentFeedback;
    }
}
