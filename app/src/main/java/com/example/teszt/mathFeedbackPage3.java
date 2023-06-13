package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mathFeedbackPage3 extends AppCompatActivity {

    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_feed_back_page3);

        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);
        String feedbacksGiven = "";


        //////////////////// the comments explaining this page are located in "mathFeedbackPage2.java" file
        for (int i = 1; i < 6; i++){
            if (testQuestioningPage3.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 1: In order to expand an equation such as (2x+1)(3x+1), you have to use" +
                        " distributive property. Multiply the 2x to the 3x and 1, multiply the 1 to the 3x and 1 and add the following results together. That is your answer.\n\n";
            }
            break;
        }

        for (int i = 6; i < 11; i++){
            if (testQuestioningPage3.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 2: In order to factor a quadratic, the most reliable way is to use " +
                        "the quadratic formula. Use it and solve for both x-intercepts. Remember that in an equation, the " +
                        "positive/negative value of the x-intercepts is reversed. For example, if an x-intercept is 3," +
                        " the factored version will look like (x-3). Apply your x-intercepts into the equation using the method" +
                        " above and multiply the whole thing by the leading coefficient of the initial equation. It is done.\n\n";
            }
            break;
        }

        for (int i = 11; i < 16; i++){
            if (testQuestioningPage3.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 3: In order to expand this equation, you can either use distributive property or pascal's triangle. " +
                        "Pascal's triangle is much easier to use. Here is the arrangement for pascal's triangle for " +
                        "quadratics, cubics and quartics respectively - (1 2 1), (1 3 3 1), (1 4 6 4 1). Each one of these numbers " +
                        "corresponds to a term on the fully factored equation. Multiply each term starting from the left side by the y-intercept to the exponent of the equation. For example, if the equation is a " +
                        "quartic, multiply the left most term by 10^4 and continue down toward the right side, decreasing the exponent by one each time. The equation is finished.\n\n";
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