package com.example.armando.project;

public class Lecture {
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    public Lecture(){}

    public Lecture(String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() { return friday; }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public boolean compare(Lecture lect){
        boolean result = true;

        return result;
    }

}
