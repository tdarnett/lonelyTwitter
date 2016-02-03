package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 */

/**
 * The tweet will only contain a date and the message inputted by the user.
 * You can assign a mood to the tweet as well.
 */
public abstract class Tweet {
    protected Date date;
    protected String message;
    /**
     * This array contains moods for the tweet.
     *     @see HappyMood
     *     @see SadMood
     */
    private ArrayList<CurrentMood> moods;

    public abstract Boolean isImportant();

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    /**
     * setMessage takes input and only assigns it to itself if the messge lenght is less than
     * or equal to 140 characters.
     * @param message takes in a message string from the input field
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }


    /**
     * toString produces valid output for the file.
     *
     * @return the string of the date separated by "|" and the tweet.
     */
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
