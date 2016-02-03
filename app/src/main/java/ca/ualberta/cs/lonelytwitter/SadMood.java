package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by tarnett on 1/12/16.
 */
/**
 * Give a sad emotion to the tweet.
 * <br> This prefaces the tweet with "I am sad!"
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
