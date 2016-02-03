package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tarnett on 1/26/16.
 */

/**
 * this class was created to show unit testing in the lab. It has methods:
 * <ul>
 *     <li>addTweet</li>
 *     <li>hasTweet</li>
 *     <li>getTweet</li>
 *     <li>getTweets</li>
 *     <li>removeTweet</li>
 *     <li>getCount</li>
 * </ul>
 */
public class TweetList {
    public ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * addTweet checks to see if the new tweet is already contained in the list.
     * If the tweet already exists it throws an IllegalArgumentException, otherwise
     * the tweet is appended to the list
     * @param tweet takes in a tweet object
     * @throws IllegalArgumentException
     */
    public void addTweet(Tweet tweet) throws IllegalArgumentException{
        if (hasTweet(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    /**
     * This method checks if the tweet is already contained in the list
     * @param tweet takes in a tweet object
     * @return a boolean determining if the tweet exists in the list or not
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Get tweet returns a tweet associated to a given index of the Tweet list.
     * @param index Takes in an integer of the index
     * @return The tweet that is at the given index location in the Tweet List
     */
    public Tweet getTweet (int index) {
        return tweets.get(index);
    }

    /**
     * returns a list of tweets sorted chronologically by date.
     * <p>Idea of implementation from //http://stackoverflow.com/questions/5207029/how-to-sort-a-list-of-objects-by-their-date-java-collections-listobject 2016-01-25 </p>
     * @return TweetList array.
     */
    public TweetList getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet t1) {
                return tweet.getDate().compareTo(t1.getDate());
            }
        });
        return this;
    }

    /**
     * removes a tweet from TweetList
     * @param tweet takes in a tweet object that is to be removed from the TweetList
     */
    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    /**
     * Determines the size of the TweetList array
     * @return an integer specifying the number of tweet object in TweetList.
     */
    public int getCount() {
        return tweets.size();
    }
}
