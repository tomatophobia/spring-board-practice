package com.spring.board.dto;

public class AchievementsDto {
    private int seq;
    private String award;
    private String awardinfo;
    private String club;
    private String clubinfo;
    private String certification;
    private String certificationinfo;
    private String result;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getAwardinfo() {
        return awardinfo;
    }

    public void setAwardinfo(String awardinfo) {
        this.awardinfo = awardinfo;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClubinfo() {
        return clubinfo;
    }

    public void setClubinfo(String clubinfo) {
        this.clubinfo = clubinfo;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCertificationinfo() {
        return certificationinfo;
    }

    public void setCertificationinfo(String certificationinfo) {
        this.certificationinfo = certificationinfo;
    }

    @Override
    public String toString() {
        return "AchievementsDto{" +
                "seq=" + seq +
                ", award='" + award + '\'' +
                ", awardinfo='" + awardinfo + '\'' +
                ", club='" + club + '\'' +
                ", clubinfo='" + clubinfo + '\'' +
                ", certification='" + certification + '\'' +
                ", certificationinfo='" + certificationinfo + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
