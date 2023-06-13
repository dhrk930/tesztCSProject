package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mathFeedbackPage extends AppCompatActivity {

    //the two GUI element variables are declared below
    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_feedback_page);

        //the gui variables are set to the actual gui elements that exist in this file's corresponding .xml file
        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);


        for (int i = 1; i < 16; i++){ //all of the 15 questions in the unit 1 math test require the same feedback hence only 1 for loop is required
            if (testQuestioningPage.questionsWrong.contains(String.valueOf(i))){ //if the questionsWrong array contains a string the value of i, set the feedback textView to the feedback listed below
                feedback.setText("Problem 1: It appears that you do not know how to " +
                        "solve the intersection of two equations. In order to solve this problem, " +
                        "you have to set the both of the equations equal to each other and solve for x by balancing all terms to one side. " +
                        "Once you have obtained the x-value, input this value into one of the equations to " +
                        "get the y-intersect. The question is done.");
            }
            break; //then break out of the for loop so the code above isn't repeated when not needed
        }





        //onclick listener for the home button
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
    }

    //this activity opens the home page
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}