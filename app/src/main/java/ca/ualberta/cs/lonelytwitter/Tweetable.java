package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 */

/**
 * An interface that uses date and message
 */
public interface Tweetable {
    // getMessage returns the tweet message.
    public String getMessage();
    public Date getDate();
}
