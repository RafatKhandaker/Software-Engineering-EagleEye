package com.ibm.watson.developer_cloud.android.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ibm.watson.developer_cloud.android.library.audio.StreamPlayer;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**#################################################################################################
 *                               Copyright IBM Corporation 2016                                    #
 *                                                                                                 #
 *                Licensed under the Apache License, Version 2.0 (the "License");                  #
 *                you may not use this file except in compliance with the License.                 #
 *                                                                                                 #
 *                                                                                                 #
 *                                                                Created by: Rafat Khandaker      #
 *                                                                                                 #
 *                                                                        on:        12-08-16      #
 *                                                                   Version:             1.0      #
 *################################################################################################*/

public class MainActivity extends AppCompatActivity{

@BindView(R.id.text_view) TextView textView;
@BindView(R.id.button) Button button;
@BindView(R.id.edit_text) EditText editText;
@BindView(R.id.image_button) ImageButton imageButton;

private static final int SPEECH = 1;
public static String getEditText;
private SpeechRecognizer speech;
private Intent recognizerIntent;


StreamPlayer streamPlayer;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
      ButterKnife.bind(this);

      // initialize TextToSpeech

      executeWatsonTTS();
      onMicButton();
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
      super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case SPEECH:
                if(requestCode == RESULT_OK && null!= data){

                    ArrayList<String> speechText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    editText.setText(speechText.get(0));
                 }


        }
    }
//------------------------------ACTIVATE WATSON TEXT TO SPEECH--------------------------------------

    private void executeWatsonTTS(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("The text to speech: " +editText.getText());
                textView.setText("TTS: " +editText.getText());

                getEditText = String.valueOf(editText.getText());

                WatsonTask task = new WatsonTask();
                task.execute(new String[]{});
            }
        });
    }


//---------------------------------WATSON BACKGROUND THREAD-----------------------------------------

    private class WatsonTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText("running the Watson thread");
                }
            });

            TextToSpeech textToSpeech = initTextToSpeechService();
            streamPlayer = new StreamPlayer();
            streamPlayer.playStream(textToSpeech.synthesize(MainActivity.getEditText, Voice.EN_ALLISON));
            return "Text to speech done";
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText("TTS stats: " +s);
        }
    }

    private TextToSpeech initTextToSpeechService(){
        TextToSpeech service = new TextToSpeech();
        String username = "0d6f1399-7b5d-469f-93a9-c6c2fed94f01";
        String password = "MZJAwre3bx8J";
        service.setUsernameAndPassword(username, password);
        return service;
    }

//--------------------------------------------------------------------------------------------------

        public void onMicButton(){
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    promptSpeechInput(imageButton.getContext());
                }
            });
        }

    public void promptSpeechInput(Context context){
        speech = SpeechRecognizer.createSpeechRecognizer(context);
//        speech.setRecognitionListener((RecognitionListener) this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say Something");

        try{
            startActivityForResult(recognizerIntent, SPEECH);
            textView.setText("");
        }catch(ActivityNotFoundException notFoundError){
            Toast.makeText(MainActivity.this, "speech to text error",
                    Toast.LENGTH_LONG).show();
        }

    }

//-----------------------------------Initialize TextToSpeech----------------------------------------


}

