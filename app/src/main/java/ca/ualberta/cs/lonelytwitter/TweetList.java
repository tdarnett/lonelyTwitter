package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tarnett on 1/26/16.
 */
public class TweetList {
    public ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    //https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html 2016-01-26
    public void addTweet(Tweet tweet) throws IllegalArgumentException{
        if (hasTweet(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }
    public Tweet getTweet (int index) {
        return tweets.get(index);
    }

    //http://stackoverflow.com/questions/5207029/how-to-sort-a-list-of-objects-by-their-date-java-collections-listobject 2016-01-25
    public TweetList getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet t1) {
                return tweet.getDate().compareTo(t1.getDate());
            }
        });
        return this;
    }
    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    // http://stackoverflow.com/questions/17125270/pass-arraylist-as-argument-to-function-- 2016-01-26
    public int getCount() {
        return tweets.size();
    }
}
