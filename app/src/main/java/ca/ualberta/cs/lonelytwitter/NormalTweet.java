package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 */

/**
 * A normal tweet will only output the date of creation and the user's message.
 * <p>Implements Tweetable.
 *@see Tweetable
 * </p>
 *<p>extends Tweet
 * @see Tweet
 * </p>
 *
 * @author tarnett
 * @version 1
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
