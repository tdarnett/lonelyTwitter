package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by tarnett on 1/12/16.
 */
public abstract class CurrentMood {
    protected Date date;
    //private String message;
    protected String mood;

    public CurrentMood(Date date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    public CurrentMood(String mood) {
        this.date = new Date();
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    */


}
