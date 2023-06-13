package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testRecap extends AppCompatActivity {

    //declare these 4 variables. these 4 variables will be set equal to the actual GUI elements that exist in this .java file's corresponding .xml file
    private TextView scoreText;
    private Button button;
    private Button feedbackButton;
    private TextView feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recap); //set the .xml file we're looking at to this .java file's corresponding .xml file
        MainActivity.unit1TestDone++; //once the user finishes a test, this variable is added to. before a user begins a test, this variable is checked. if this variable equals 1 (Which means that the user has already completed the test), then the user will not be able to start the test and will have to restart the app to do so

        //in these 3 lines of code below, the variables that were initialized at the top are set to the actual GUI elements that exist in the .xml file
        scoreText = (TextView) findViewById(R.id.textView8);

        feedbackText = (TextView) findViewById(R.id.feedbackView);

        feedbackButton = findViewById(R.id.feedbackButton);

        String testScored = String.valueOf(testQuestioningPage.score); //get the user's score variable from the testQuestioningPage.java file and set it to this string

        scoreText.setText("You got " + testScored + " out of " + testQuestioningPage.mathQuestion.length + " answers correct!"); //this text tells the user their overall score

        if(testQuestioningPage.questionsWrong.equals("#: ")){ //if the user got nothing wrong, this phrase is printed on the GUI
            feedbackText.setText("Congratulations, you scored perfectly.");
        }
        else{ //else, the user receives a rundown of the questions that they got wrong
            feedbackText.setText("Here are the questions you got wrong:\n " + testQuestioningPage.questionsWrong);
        }

        button = (Button) findViewById(R.id.homeButton);
        button.setOnClickListener(new View.OnClickListener(){ //set an onclick listener function to bring the user back home
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

        feedbackButton.setOnClickListener(new View.OnClickListener(){ //set an onclick listener function to bring the user to the more thorough feedback page where they will receive a more complex rundown of their performance on the test that they just finished
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });

    }

    public void openActivity2(){ //this function opens up the main page (The subject selection screen)
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivity3(){ //this function opens up the corresponding feedback page of this test
        Intent intent = new Intent(this, mathFeedbackPage.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        return;
    } //disables the back button on this page so the user can't go back and change stuff on the test after realising they got some things wrong
}