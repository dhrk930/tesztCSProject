package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mathFeedbackPage2 extends AppCompatActivity {

    //the gui variables are declared below
    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_feed_back_page2);

        //sets the gui variables declared above to the actual gui elements that exist in this .java file's .xml file
        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);
        String feedbacksGiven = ""; //this string will be added on with "feedbacks" when the user gets a question wrong

        for (int i = 1; i < 4; i++){
            if (testQuestioningPage2.questionsWrong.contains(String.valueOf(i))){ //if the user gets one of the questions between 1-3 wrong (Represented by the possible value(s) of i in this for loop), add the text below to the feedbacksGiven string
                feedbacksGiven += "Problem 1: In order to solve for the midpoint of a line formed by two points, " +
                        "we are going to find the x and y values of said point individually. In order to get the x value, " +
                        "add the two given x values and divide them by two. Repeat this same step for the y value." +
                        "The question is finished.\n\n";
            }
            break; //break out of the loop right after because only one "set" of feedback is required for this type of question - if we don't break out the loop and the user gets all questions 1-3 wrong, then it will add the string of feedback listed above several times.
        }

        //this process above is repeated several times for the other questions below
        for (int i = 4; i < 7; i++){
            if (testQuestioningPage2.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 2: In order to solve for the endpoint of a line. Let's " +
                        "do some algebra for the x and y values respectively. If the start point is (6, 1) and the mid point is (2, 4), " +
                        "then the midpoint (2, 4) is equal to ( (6 + x)/2 , (1 + y)/2 ). This turns into (2 = (6 + x) / 2). Solve for x and " +
                        "do the same for Y.\n\n";
            }
            break;
        }

        for (int i = 7; i < 10; i++){
            if (testQuestioningPage2.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 3: In order to solve for the length of a line formed by two points, we can use pythagorean theorem. Determine the sides a and b and solve for c (Hypotenuse) using c^2 = a^2 + b^2.\n\n";
            }
            break;
        }

        for (int i = 10; i < 12; i++){
            if (testQuestioningPage2.questionsWrong.contains(String.valueOf(i))){
                feedbacksGiven += "Problem 4: In order to solve for the equation of a circle given the radius, remember that the right side of the equation is equal to the square root of the radius." +
                        "For example, if you have a circle with a radius of 9, the equation is x^2 + y^2 = 3.\n\n";
            }
            break;
        }

        if (testQuestioningPage2.questionsWrong.contains(" 12")){ //if the user gets question #12 wrong (If the user gets this question wrong, it's string will be located in the questionsWrong string), then add the corresponding question's feedback to the feedbacksGiven variable
            feedbacksGiven += "Problem 5: In order to determine the radius of a circle given its equation, square the right side of the equation. That is the radius.\n\n";
        }

        for (int i = 13; i < 15; i++) {
            if (testQuestioningPage2.questionsWrong.contains(String.valueOf(i))) {
                feedbacksGiven += "Problem 6: In order to determine whether or not a point is located inside or outside a circle - if the point's x-value is larger than the radius, then it is outside the circle.\n\n";
            }
            break;
        }

        if (testQuestioningPage2.questionsWrong.contains(" 15")) {
            feedbacksGiven += "Problem 7: In order to find the equation of a circle given it's center point and right side of the equation - " +
                    "begin by setting the right side of the equation to the value given. " +
                    "Next, apply the horizontal/vertical transformations inside the exponents. " +
                    "Remember that horizontal/vertical transformations are reversed when looked at in an equation and when applied inside exponents - " +
                    "if you move 3 points to the right, x/y becomes -3 in the equation. For example, a vertical and horizontal shift 3 units up and right becomes (x-3)^2 and (y-3)^2 in the equation respectively.";

        }

        feedback.setText(feedbacksGiven); //set the feedback GUI element's text to the feedbacksGiven string

        //onclick listener for the home button on this page
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
    }

    //opens the home page
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}