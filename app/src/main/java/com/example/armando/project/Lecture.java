package com.example.armando.project;

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
}
