package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scienceFeedbackPage2 extends AppCompatActivity {

    private Button button;
    private TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_feedback_page2);

        button = (Button) findViewById(R.id.homeButton);
        feedback = (TextView) findViewById(R.id.textView2);
        String feedbacksGiven = "";


        //////////////////// the comments explaining this feedback system are located in "mathFeedbackPage2.java" file
        if (scienceTestQuestioningPage2.questionsWrong.contains("#: 1")) {
            feedbacksGiven += "Problem 1: In animals, vacuoles perform the role of isolating waste products.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 2")) {
            feedbacksGiven += "Problem 2: The purpose of the cytoplasm is to provide a space (A gel-like fluid space) for all the other organelles to reside in.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 3")) {
            feedbacksGiven += "Problem 3: The purpose of the ribosome is to have a site for protein synthesis.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 4")) {
            feedbacksGiven += "Problem 4: The cell wall only exists in the kingdom plantae.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 5")) {
            feedbacksGiven += "Problem 5: Plants have one larger vacuole.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 6")) {
            feedbacksGiven += "Problem 6: The mitochondria is the powerhouse of the cell - it creates the energy for the cell.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 7")) {
            feedbacksGiven += "Problem 7: Diffusion is the movement of molecules between differing areas of concentration - crucial for a cell's survival.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 8")) {
            feedbacksGiven += "Problem 8: Cells replicate in order to allow the organism to survive by completing functions such as growth, repair and reproduction.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 9")) {
            feedbacksGiven += "Problem 9: The first stage of mitosis (The cell replication phase) is prophase.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 10")) {
            feedbacksGiven += "Problem 10: The process of cell specialization is done because different organs require different types of cells.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 11")) {
            feedbacksGiven += "Problem 11: Nervous tissue provides sensing sensations for the organism.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 12")) {
            feedbacksGiven += "Problem 12: The chest cavity expands when we take a breathe because the diaphragm contracts and moves downward.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 13")) {
            feedbacksGiven += "Problem 13: Connective tissue provides structure and support for organs in the body.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 14")) {
            feedbacksGiven += "Problem 14: The circulatory system plays the important role of circulating oxygen-rich blood to all of the body's organs.\n\n";
        }
        if (scienceTestQuestioningPage2.questionsWrong.contains(" 15")) {
            feedbacksGiven += "Problem 15: Veins carry oxygen-poor blood back to the heart.\n\n";
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