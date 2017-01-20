package com.example.c4q.quizzy;

/**
 * Created by C4Q on 9/28/16.
 */
public class Question {

    private int textResId;
    private boolean answer;

    public Question(int textResId, boolean answer){
        this.textResId = textResId;
        this.answer = answer;
    }

    public int getTextResId() {
        return textResId;
    }

    public boolean isAnswerTrue(){
        return answer;
    }


}
