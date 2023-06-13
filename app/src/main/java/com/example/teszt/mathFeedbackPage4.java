package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mathFeedbackPage4 extends AppCompatActivity {

    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_feed_back_page4);

        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);
        String feedbacksGiven = "";


        //////////////////// the comments explaining this page are located in "mathFeedbackPage2.java" file
        if (testQuestioningPage4.questionsWrong.contains("#: 1")){
            feedbacksGiven += "Problem 1: The term at the left-most side of the equation is the y-intercept.\n\n";
        }
        if (testQuestioningPage4.questionsWrong.contains(" 2")){
            feedbacksGiven += "Problem 2: In order to find the x-intercepts, you can use the quadratic formula as explained in the previous unit tests (Complete those first!).\n\n";
        }
        if (testQuestioningPage4.questionsWrong.contains(" 3")){
            feedbacksGiven += "Problem 3: In order to find the range of an equation, complete a basic graph of the equation on paper and using this, it would be fairly easy to predict where to graph continues on - allowing you to find the range.\n\n";
        }
        if (testQuestioningPage4.questionsWrong.contains(" 4")){
            feedbacksGiven += "Problem 4: In order to find the domain/direction of opening of an equation, repeat the steps you did to complete question #3 except observe the x-values instead of the y-values.\n\n";
        }

        for (int i = 5; i < 8; i++){
            if (testQuestioningPage4.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 5: In order to determine an equation after it has been transformed, let's first begin with the horizontal transformations. If the question states that the equation has been moved x units to the right (Positive side), subtract the value of x (For example - (x-3)^2). If the equation has been horizontally stretched by a factor of x, divide this value in front of the horizontal translation (For example, (1/3(x-3))^2). If the equation has been vertically stretched, multiply the value in front of everything else done previously. If a vertical translation is applied, " +
                        " add the whole thing by the value of the vertical translation. The question is done - remember that horizontal changes are oppositely shown in the equation.\n\n";
            }
            break;
        }

        for (int i = 8; i < 10; i++){
            if (testQuestioningPage4.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 6: For these questions, you simply had to state the horizontal multiplication. If the equation looks like this: 3(x-3)^2, then a horizontal transformation of 1/3 has been applied - remember that horizontal transformations are always oppositely done when looking at the equation.\n\n";
            }
            break;
        }

        for (int i = 10; i < 16; i++){
            if (testQuestioningPage4.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 7: For these questions, you had to state the maximum height. In order to find the maximum height, use the formula -b/2a. This tells you the x-value for the vertex. Substitute this x-value back into the equation to get the y-value which is the answer.";
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