package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scienceFeedbackPage3 extends AppCompatActivity {

    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_feed_back_page);

        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);
        String feedbacksGiven = "";


        //////////////////// the comments explaining this feedback system are located in "mathFeedbackPage2.java" file
        if (scienceTestQuestioningPage3.questionsWrong.contains("#: 1")) {
            feedbacksGiven += "Problem 1: Light is the term for the wavelength(s) of the electromagnetic spectrum visible to the human eye.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 2")) {
            feedbacksGiven += "Problem 2: Light travels in a wave.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 3")) {
            feedbacksGiven += "Problem 3: The angle of incidence is the angle between the incoming light ray and the normal. This angle is equal to the angle between the reflection of this light ray and the normal.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 4")) {
            feedbacksGiven += "Problem 4: An incident ray is a term for an incoming light ray.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 5")) {
            feedbacksGiven += "Problem 5: A reflected ray is a ray of light that is reflected off a surface.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 6")) {
            feedbacksGiven += "Problem 6: Concave mirrors collect light to a single point.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 7")) {
            feedbacksGiven += "Problem 7: A concave mirror collects light to a single point, called a focal point.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 8")) {
            feedbacksGiven += "Problem 8: The scientific term for the bending of light as it passes from one medium to another is called refraction.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 9")) {
            feedbacksGiven += "Problem 9: A convex mirror bulges towards the light source and reflects light in all directions.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 10")) {
            feedbacksGiven += "Problem 10: Light bends towards the normal as it passes between mediums.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 11")) {
            feedbacksGiven += "Problem 11: The formula for the index of refraction is N (Index of Refraction) = C (Speed of Light) / V (Phase Velocity of Light)\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 12")) {
            feedbacksGiven += "Problem 12: The index of refraction of a medium is a term for how much light is bent when entering the medium.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 13")) {
            feedbacksGiven += "Problem 13: The index of refraction of a vacuum is zero because there are no air molecules to bend light.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 14")) {
            feedbacksGiven += "Problem 14: The scientific term for a lens that is thinner at the center and spreads light outwards is a concave lens.\n\n";
        }
        if (scienceTestQuestioningPage3.questionsWrong.contains(" 15")) {
            feedbacksGiven += "Problem 15: A convex lens is a piece of glass that collects light to a single point behind the lens.";
        }

        feedback.setText(feedbacksGiven);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

    }

    public void openActivity2 () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}