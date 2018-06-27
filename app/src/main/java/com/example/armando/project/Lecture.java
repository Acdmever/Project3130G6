package com.example.armando.project;

public class Lecture {
    public String monday;
    public String tuesday;
    public String wednesday;
    public String thursday;
    public String friday;

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

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getMonday() {

        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }
    public String getCourseOfDay(String day){
        if (day.equalsIgnoreCase("Monday"))
            return this.monday;
        if (day.equalsIgnoreCase("Tuesday"))
            return this.tuesday;
        if (day.equalsIgnoreCase("Wednesday"))
            return this.wednesday;
        if (day.equalsIgnoreCase("Thursday"))
            return this.thursday;
        if (day.equalsIgnoreCase("Friday"))
            return this.friday;

        return null;
    }
    public boolean hasLectureOn(String day){
        if (!(this.getCourseOfDay(day)==null)){
            return true;
        }
        return false;
    }
}
