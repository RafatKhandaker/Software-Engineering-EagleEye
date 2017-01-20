package com.example.c4q.quizzy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by RedDragon on 10/3/16.
 */

public class CheatActivity extends QuizActivity {

    private Question currentQuestion;
    private Question[] copyofQuestions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = (Button) findViewById(R.id.cheat_button);
        copyofQuestions = super.questionBank;
        button.setVisibility(View.GONE);
        //toast "the ansser is yes" or the answer is false.
//        View questionTV = (TextView) findViewById(R.id.question_text_view);
        //questionTV.setText("I didnt implement this yet. Need to figure out how to read from an Intent ex");
        TextView questionTV = (TextView) findViewById(R.id.question_text_view);

        Intent intent = getIntent();
        String myQuestion = intent.getExtras().getString("CURRENT QUESTION");
        boolean myAnswer = intent.getExtras().getBoolean("CURRENT ANSWER");

        questionTV.setText(myQuestion + ": " + myAnswer );


    }
}
