package com.spring.board.dto;

public class EducationDto {
    private int seq;
    private String startdate;
    private String enddate;
    private String institute;
    private String major;
    private double gpa;
    private String etc;
    private String result;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "EducationDto{" +
                "seq=" + seq +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", institute='" + institute + '\'' +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                ", etc='" + etc + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
