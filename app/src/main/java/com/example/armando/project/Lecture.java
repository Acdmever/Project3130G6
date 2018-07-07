package com.example.armando.project;

import java.time.LocalTime;

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

    public String[][] getStartStopTimes(){
        String[] monday;
        String[] tuesday;
        String[] wednesday;
        String[] thursday;
        String[] friday;

       if(this.monday != null){
           monday = getMonday().split("-");
       } else {
           monday = null;
       }

       if(this.tuesday != null){
           tuesday = getTuesday().split("-");
       } else {
           tuesday = null;
       }

       if(this.wednesday != null){
           wednesday = getWednesday().split("-");
       } else {
           wednesday = null;
       }

       if(this.thursday != null){
           thursday = getThursday().split("-");
       } else {
           thursday = null;
       }

       if(this.friday != null){
           friday = getFriday().split("-");
       } else {
           friday = null;
       }

       String[][] times = new String[5][2];
       times[0] = monday;
       times[1] = tuesday;
       times[2] = wednesday;
       times[3] = thursday;
       times[4] = friday;
       return times;
    }

    //true = conflict, false = no conflict
    public boolean compare(Lecture lect){
       String[][] thisStartStop = this.getStartStopTimes();
       String[][] lectStartStop = lect.getStartStopTimes();
       boolean result = true;

       for(int i = 0; i < 5; i++){
           if(thisStartStop[i] == null || lectStartStop[i] == null){
               continue;
           }

           if(thisStartStop[i][0].compareTo(lectStartStop[i][1]) >= 0){
               return false;
           }
           else if(thisStartStop[i][1].compareTo(lectStartStop[i][0]) <= 0) {
               return false;
           }
       }
       return result;
    }
}
