package com.example.armando.project;

import java.time.LocalTime;

/**
 * Contains lecture data and methods
 * @author Matt
 */
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

    /**
     * Get time of class on Monday
     * May be empty if no class on Monday
     * @return classTime
     */
    public String getMonday() {
        return monday;
    }

    /**
     * Set class time on Monday
     * @param monday
     */
    public void setMonday(String monday) {
        this.monday = monday;
    }

    /**
     * Get time of class on Tuesday
     * May be empty if no class on Tuesday
     * @return classTime
     */
    public String getTuesday() {
        return tuesday;
    }

    /**
     * Set class time on Tuesday
     * @param tuesday
     */
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * Get time of class on Wednesday
     * May be empty if no class on Wednesday
     * @return classTime
     */
    public String getWednesday() {
        return wednesday;
    }

    /**
     * Set class time on Wednesday
     * @param wednesday
     */
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * Get time of class on Thursday
     * May be empty if no class on Thursday
     * @return classTime
     */
    public String getThursday() {
        return thursday;
    }

    /**
     * Set class time on Thursday
     * @param thursday
     */
    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    /**
     * Get time of class on Friday
     * May be empty if no class on Friday
     * @return classTime
     */
    public String getFriday() {
        return friday;
    }

    /**
     * Set class time on Friday
     * @param friday
     */
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
       boolean result = false;

       for(int i = 0; i < 5; i++){

           if(thisStartStop[i] == null || lectStartStop[i] == null){
               continue;
           }

           if((thisStartStop[i][0].compareTo(lectStartStop[i][0]) <= 0)
                   && (thisStartStop[i][1].compareTo(lectStartStop[i][0]) >= 0)){
               return true;
           } else if((thisStartStop[i][0].compareTo(lectStartStop[i][1]) <= 0)
                   && (thisStartStop[i][1].compareTo(lectStartStop[i][1]) >= 0)){
               return true;
           } else if((thisStartStop[i][0].compareTo(lectStartStop[i][0]) >= 0)
                   && (thisStartStop[i][1].compareTo(lectStartStop[i][1]) <= 0)){
               return true;
           }
       }
       return result;
    }

    //Armando
    public String getCourseOfDay(String day){
        if (day.equalsIgnoreCase("monday"))
            return this.monday;
        if (day.equalsIgnoreCase("tuesday"))
            return this.tuesday;
        if (day.equalsIgnoreCase("wednesday"))
            return this.wednesday;
        if (day.equalsIgnoreCase("thursday"))
            return this.thursday;
        if (day.equalsIgnoreCase("friday"))
            return this.friday;

        return null;
    }
    //Armando
    public boolean hasLectureOn(String day){
        if (!(this.getCourseOfDay(day)==null)){
            return true;
        }
        return false;
    }
}
