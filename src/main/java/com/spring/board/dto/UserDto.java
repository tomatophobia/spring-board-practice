package com.spring.board.dto;

public class UserDto {
    private int seq;
    private String name;
    private String result;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}

