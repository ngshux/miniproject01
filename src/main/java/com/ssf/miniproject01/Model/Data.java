package com.ssf.miniproject01.Model;

public class Data {
    private String name;
    private Integer wpm;
    private Integer cpm;
    private Integer score;

    public Data(String name, int wpm, int cpm, int score) {
        this.name = name;
        this.wpm = wpm;
        this.cpm = cpm;
        this.score = score;
    }
    
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWpm() {
        return wpm;
    }
    public void setWpm(int wpm) {
        this.wpm = wpm;
    }
    public int getCpm() {
        return cpm;
    }
    public void setCpm(int cpm) {
        this.cpm = cpm;
    }

    
}
