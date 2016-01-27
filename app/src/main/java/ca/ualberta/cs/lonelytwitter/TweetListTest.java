package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tarnett on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }
    public void testAddTweet(){
        Boolean pass = false;
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        tweets.addTweet(tweet);
        try {
            tweets.addTweet(tweet);

        } catch (IllegalArgumentException e) {
            pass = true;
        }

        assertTrue(pass);
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");

        assertFalse(tweets.hasTweet(tweet));
        tweets.addTweet(tweet);
        //tweets.hasTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));

    }
    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.removeTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }
    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());

    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);

        assertEquals(tweets.getCount(),1);
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet(new Date(2016,01,01),"Test tweet");
        Tweet tweet2 = new NormalTweet(new Date(2016,01,02),"Test tweet2");
        Tweet tweet3 = new NormalTweet(new Date(2016,01,03),"Test tweet3");
        Tweet tweet4 = new NormalTweet(new Date(2016,01,04),"Test tweet4");
        tweets.addTweet(tweet3);
        tweets.addTweet(tweet4);
        tweets.addTweet(tweet);
        tweets.addTweet(tweet2);


        TweetList testTweets;
        testTweets = tweets.getTweets();


        assertTrue(testTweets.getTweet(0).getDate().before(testTweets.getTweet(1).getDate()));
    }
}
