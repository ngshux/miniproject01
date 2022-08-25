package com.ssf.miniproject01;

public class Data {
    private String name;
    private int wpm;
    private int cpm;

    public Data(String name, int wpm, int cpm) {
        this.name = name;
        this.wpm = wpm;
        this.cpm = cpm;
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
