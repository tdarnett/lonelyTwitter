package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by tarnett on 1/12/16.
 */
public class SadMood extends CurrentMood {

    public SadMood(Date date, String mood) {
        super(date, mood);
    }

    public SadMood(String mood) {
        super(mood);
    }

    public Date getDate() {
        return this.date;
    }

    public String getMood() {
        return "I am sad!" + this.mood;
    }
    public String showMood() {
        return ":(";

    }
}
