package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scienceFeedbackPage extends AppCompatActivity {

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
        if (scienceTestQuestioningPage.questionsWrong.contains("#: 1")) {
            feedbacksGiven += "Problem 1: The symbol for oxygen is O (The largest letter on the periodic table).\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 2")) {
            feedbacksGiven += "Problem 2: The symbol for sodium is Na (The largest letter on the periodic table).\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 3")) {
            feedbacksGiven += "Problem 3: The symbol for nitrogen is N (The largest letter on the periodic table).\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 4")) {
            feedbacksGiven += "Problem 4: The symbol for copper is Cu (The largest letter on the periodic table).\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 5")) {
            feedbacksGiven += "Problem 5: The symbol for gold is Au (The largest letter on the periodic table).\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 6")) {
            feedbacksGiven += "Problem 6: On the periodic table, the row (Vertical) number determines the number of valence electrons, starting at 1 with the row of hydrogen. Sodium has 1 valence electron.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 7")) {
            feedbacksGiven += "Problem 7: On the periodic table, the row (Vertical) number determines the number of valence electrons, starting at 1 with the row of hydrogen. Uranium has 6 valence electrons.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 8")) {
            feedbacksGiven += "Problem 8: A pH (power of hydrogen) of 7 is neutral. It is the midpoint of the pH scale.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 9")) {
            feedbacksGiven += "Problem 9: A pH (power of hydrogen) of 9 is slightly basic. It is slightly more basic than the neutral pH of 7.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 10")) {
            feedbacksGiven += "Problem 10: The pH of a weak base is slightly above 7.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 11")) {
            feedbacksGiven += "Problem 11: The number of electrons of an element can be determined by the element's atomic number. Chlorine has 17 electrons.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 12")) {
            feedbacksGiven += "Problem 12: Ionic compounds have very strongly bonded and have a high boiling point. They can still be melted.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 13")) {
            feedbacksGiven += "Problem 13: Electrons are shared in a covalent bond. The higher the electronegativity of an element in a compound, the more the electrons gravitate towards that electronegative compound but it's still sharing.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 14")) {
            feedbacksGiven += "Problem 14: Water and a salt (Salts are ionic compounds) are produced in an acid-base neutralisation reaction.\n\n";
        }
        if (scienceTestQuestioningPage.questionsWrong.contains(" 15")) {
            feedbacksGiven += "Problem 15: Covalent compounds typically have two or more non-metals.";
        }

        feedback.setText(feedbacksGiven);

        System.out.print(feedbacksGiven);

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