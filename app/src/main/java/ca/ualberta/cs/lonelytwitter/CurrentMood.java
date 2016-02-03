package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by tarnett on 1/12/16.
 */

/**
 * An abstract class to create a mood for a tweet. Any mood will inherit from this class
 * @author tarnett
 * @version 1
 */
public abstract class CurrentMood {
    protected Date date;
    protected String mood;

    /**
     * contructor
     * @param date Date type variable
     * @param mood A string to specify the current mood
     */
    public CurrentMood(Date date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    /**
     * A constructor, cretes a new Date if date is not passed in the paramter
     * @param mood String to specify the current mood.
     */
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
