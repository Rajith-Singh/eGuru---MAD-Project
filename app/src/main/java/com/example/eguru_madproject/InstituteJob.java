package com.example.eguru_madproject;

public class InstituteJob {

    private String Aname;
    private String Asubject;
    private String Agrade;
    private String Aarea;
    private String Acontact;

    public InstituteJob(){}
    public InstituteJob(String aname, String asubject, String agrade, String aarea, String acontact) {
       this.Aname = aname;
       this.Asubject = asubject;
       this.Agrade = agrade;
       this.Aarea = aarea;
       this.Acontact = acontact;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public String getAsubject() {
        return Asubject;
    }

    public void setAsubject(String asubject) {
        Asubject = asubject;
    }

    public String getAgrade() {
        return Agrade;
    }

    public void setAgrade(String agrade) {
        Agrade = agrade;
    }

    public String getAarea() {
        return Aarea;
    }

    public void setAarea(String aarea) {
        Aarea = aarea;
    }

    public String getAcontact() {
        return Acontact;
    }

    public void setAcontact(String acontact) {
        Acontact = acontact;
    }
}
