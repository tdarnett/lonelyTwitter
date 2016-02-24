package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    //TODO: A function that gets tweets
    public static class getTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>> {

        @Override
        protected 
    }
    //TODO: A function that adds a tweet
    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void> {
        @Override
        protected Void doInBackground(NormalTweet...tweets) {
            verifyClient();
            for (int i = 0; i < tweets.length; i++) {
                NormalTweet tweet = tweets[i];

                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        // se the id to tweet that elastic search told me it was
                        tweet.setId(result.getId());
                    } else {
                        //TODO: add an error message.Right here it will trigger if the insert fails
                        Log.i("TODO"," We actually failed here, adding a tweet");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
    }

    public static void verifyClient () {
        // verify that this client exists
        // if it doesnt then it will make it.
        if (client == null) { //this makes a new client
            //TODO: put this url somewhere it makes sense
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient)factory.getObject();
        }
    }
}

