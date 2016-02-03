package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by tarnett on 1/12/16.
 */

/**
 * Give a happy emotion to the tweet.
 * <br> This prefaces the tweet with "I am Happy!"
 * @author tarnett
 * @version 1
 */
public class HappyMood extends CurrentMood {

    public HappyMood(Date date, String mood) {
        super(date ,mood);
    }

    public HappyMood(String mood) {
        super(mood);
    }

    public String getMood() {
        return "I am Happy!" + this.mood;
    }
    public String showMood() {
        return ":)";

    }
}
