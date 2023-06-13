package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testRecap3 extends AppCompatActivity {
    //////////////////////////////// THE COMMENTS EXPLAINING THE TEST RECAP PAGE ARE LOCATED IN THE "testRecap.java" FILE
    private TextView scoreText;

    private Button button;

    private TextView feedbackText;
    private Button feedbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recap3);
        MainActivity.unit3TestDone++;

        scoreText = (TextView) findViewById(R.id.textView8);
        feedbackButton = findViewById(R.id.feedbackButton);
        feedbackText = (TextView) findViewById(R.id.feedbackView);

        String testScored = String.valueOf(testQuestioningPage3.score);

        scoreText.setText("You got " + testScored + " out of " + testQuestioningPage3.mathQuestion.length + " answers correct!");

        if(testQuestioningPage3.questionsWrong.equals("#: ")){
            feedbackText.setText("Congratulations, you scored perfectly.");
        }
        else{
            feedbackText.setText("Here are the questions you got wrong:\n " + testQuestioningPage3.questionsWrong);
        }

        button = (Button) findViewById(R.id.homeButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
        feedbackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, mathFeedbackPage3.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        return;
    }
}