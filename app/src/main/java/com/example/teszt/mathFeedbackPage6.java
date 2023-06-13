package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mathFeedbackPage6 extends AppCompatActivity {

    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_feedback_page6);

        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);
        String feedbacksGiven = "";


        //////////////////// the comments explaining this page are located in "mathFeedbackPage2.java" file
        if (testQuestioningPage6.questionsWrong.contains("#: 1")){
            feedbacksGiven += "Problem 1: To find the 10 ratio given the angle, use the tan function on your calculator, and solve.\n\n";
        }

        if (testQuestioningPage6.questionsWrong.contains(" 2")){
            feedbacksGiven += "Problem 2: To find the tan ratio given the opposite and adjacent - first, remember your SOH CAH TOA. TOA is for tan. Tan is equal to opposite divided by adjacent. Thus, the tan ratio for the angle is equal to the given opposite divided by the given adjacent.\n\n";
        }

        if (testQuestioningPage6.questionsWrong.contains(" 3")){
            feedbacksGiven += "Problem 3: To find the sin ratio given the opposite and hypotenuse - first, remember your SOH CAH TOA. SOH is for sin. Sin is equal to opposite divided by hypotenuse. Thus, the tan ratio for the angle is equal to the given opposite divided by the given hypotenuse.\n\n";
        }

        if (testQuestioningPage6.questionsWrong.contains(" 4")){
            feedbacksGiven += "Problem 4: To find the opposite given the angle and the hypotenuse - remember that sin(angle) = opposite/hypotenuse. Rearrange this equation and solve for the opposite.\n\n";
        }

        for (int i = 5; i < 7; i++) {
            if (testQuestioningPage6.questionsWrong.contains(String.valueOf(i))) {
                feedbacksGiven += "Problem 5: To find the opposite given the angle and the adjacent - remember that tan(angle) = opposite/adjacent. Rearrange this equation and solve for the opposite.\n\n";
            }
            break;
        }

        if (testQuestioningPage6.questionsWrong.contains(" 7")) {
            feedbacksGiven += "Problem 6: To find the angle given the hypotenuse and the adjacent - remember that cos(angle) = adjacent/hypotenuse. Rearrange this equation and solve for the angle by inverse cosing the right side.\n\n";
        }

        if (testQuestioningPage6.questionsWrong.contains(" 8")) {
            feedbacksGiven += "Problem 7: To find the angle given the opposite and the adjacent - remember that tan(angle) = opposite/adjacent. Rearrange this equation and solve for the angle by inverse taning the right side.\n\n";
        }

        if (testQuestioningPage6.questionsWrong.contains(" 9")) {
            feedbacksGiven += "Problem 8: To find the angle given the hypotenuse and the opposite - remember that sin(angle) = opposite/hypotenuse. Rearrange this equation and solve for the angle by inverse sining the right side.\n\n";
        }

        for (int i = 10; i < 13; i++){
            if (testQuestioningPage6.questionsWrong.contains(String.valueOf(i))) {
                feedbacksGiven += "Problem 9: To find the length AB given the length AC and angle C, we have to use sine law. sin(C)/AC = sin(B)/AB. Rearrange the equation and solve for AB.\n\n";
            }
            break;
        }

        for (int i = 13; i < 16; i++){
            if (testQuestioningPage6.questionsWrong.contains(String.valueOf(i))) {
                feedbacksGiven += "Problem 10: To find the angle C given the three side lengths, use the cosine formula: c^2 = a^2 + b^2 - 2(a)(b)cos(C).";
            }
            break;
        }

        feedback.setText(feedbacksGiven);

        System.out.println(feedbacksGiven);

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