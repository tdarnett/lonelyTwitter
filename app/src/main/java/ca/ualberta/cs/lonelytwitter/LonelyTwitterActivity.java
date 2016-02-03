package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main activity for a small, personal Twitter app to capture, note and comment.
 * <p>It saves the input tweets to the json files.</p>
 *
 *     The list of important activities in this class are as follows:
 *     <ul>
 *         <li>onCreate()</li>
 *         <li>onStart()</li>
 *         <li>loadFromFile()</li>
 *         <li>saveInFile()</li>
 *     </ul>
 * @since 1.2.1
 * @see LonelyTwitterActivity for information.
 * @author tarnett
 * @version 2.2
 *
 */
public class LonelyTwitterActivity extends Activity {
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	/**
	 * oldTweetsList will contain the tweet objects that are loaded from file.
	 * @see #loadFromFile()
	 */
	private ListView oldTweetsList;

	/**
	 * This arraylist is for keeping tweets together <br>
	 * @see #loadFromFile()
	 */
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>(); //this creates a list of tweets
	private ArrayAdapter<Tweet> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		/**
		 * Once the user clicks "save", the message perfaced by a date is outputted on
		 * the screen.
		 */
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet latestTweet = new NormalTweet(text);
				ImportantTweet latestImportantTweet = new ImportantTweet(text);
				tweets.add(latestTweet);	//now we are just adding the latest tweet to the list of tweets
				adapter.notifyDataSetChanged(); //this tells adapter to update itself
				saveInFile();

			}
		});
		/**
		 * clear button will clear all previous entries, clear the user input, and delete
		 * the save file.
		 */
		Button clearButton = (Button) findViewById(R.id.clear);
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				setResult(RESULT_OK);
				bodyText.setText("");
				tweets.clear();
				deleteFile("file.sav");
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Takes the tweet objects that were saved into the file and loads them into
	 * a tweets array.
	 *
	 */
	private void loadFromFile() {
		tweets = new ArrayList<Tweet>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			// Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-2016-19
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

	}

	/**
	 * This takes a Tweets array and saves the tweet objects into a file.
	 * @throws RuntimeException if file not found or IO exception
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(); //easier to debug
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
	}
}