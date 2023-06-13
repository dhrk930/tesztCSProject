package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mathFeedbackPage5 extends AppCompatActivity {

    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_feed_back_page5);

        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);
        String feedbacksGiven = "";


        //////////////////// the comments explaining this page are located in "mathFeedbackPage2.java" file
        for (int i = 1; i < 11; i++){
            if (testQuestioningPage5.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 1: In order to solve for an equation that is unbalanced, begin by balancing both sides. This can be done by moving the terms on the right side over to the left side. After that, use the quadratic formula to solve for the solutions. There is your answer.\n\n";
            }
            break;
        }

        for (int i = 11; i < 16; i++){
            if (testQuestioningPage5.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 2: In order to determine the number of solution to an equation without having to do the quadratic formula, use the formula b^2-4ac. A is the coefficient, b is the coefficient of the middle-x term and c is the y-intercept. If the answer is below 0, there are no solutions. If the answer equals 0, there is one solution. If the answer is larger than 0, there are two solutions.";
            }
            break;
        }

        feedback.setText(feedbacksGiven);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}