package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scienceTestQuestioningPage3 extends AppCompatActivity implements View.OnClickListener{

    ///////////////// a proper explanation of this page is located in the "testQuestioningPage.java" file
    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = scienceQuestion.length;

    public static int score = 0;
    int ongoingQuestion = 0;
    String choosenAnswer = "";

    //question1
    static String questionDisplayed = "What is the scientific term for the wavelength(s) of the electromagnetic spectrum visible to the human eye?";
    static String rightAnswer = "Light.";
    static String incorrect1Answer = "Radiation.";
    static String incorrect2Answer = "Photonic travel.";

    //question2
    static String questionDisplayed2 = "What shape does light travel in?";
    static String rightAnswer2 = "Waves.";
    static String incorrect1Answer2 = "Circles.";
    static String incorrect2Answer2 = "Light does not travel at all.";

    //question3
    static String questionDisplayed3 = "Complete the phrase: The angle ___ of is always equal to the angle of ___.";
    static String rightAnswer3 = "Incidence, reflection.";
    static String incorrect1Answer3 = "Reflection, incidence.";
    static String incorrect2Answer3 = "Initial, final.";

    //question4
    static String questionDisplayed4 = "What is an incident ray?";
    static String rightAnswer4 = "An incoming ray of light that strikes a surface.";
    static String incorrect1Answer4 = "A reflection of a light ray.";
    static String incorrect2Answer4 = "A circle of photons.";

    //question5
    static String questionDisplayed5 = "What is a reflected ray?";
    static String rightAnswer5 = "A ray of light that is reflected off a surface.";
    static String incorrect1Answer5 = "A ray of light that travels through a medium such as water.";
    static String incorrect2Answer5 = "Question doesn't make sense.";

    //question6
    static String questionDisplayed6 = "What type of mirror collects light at a single point?";
    static String rightAnswer6 = "Concave mirrors.";
    static String incorrect1Answer6 = "Convex mirrors.";
    static String incorrect2Answer6 = "All types of mirror do this.";

    //question7
    static String questionDisplayed7 = "What is a concave mirror?";
    static String rightAnswer7 = "A concave mirror collects light at a single point, called a focal point.";
    static String incorrect1Answer7 = "Such a mirror does not exist.";
    static String incorrect2Answer7 = "A concave mirror emits rays.";

    //question8
    static String questionDisplayed8 = "What is the scientific term for the bending of light as it passes between mediums?";
    static String rightAnswer8 = "Refraction.";
    static String incorrect1Answer8 = "Deflection.";
    static String incorrect2Answer8 = "Differentiation.";

    //question9
    static String questionDisplayed9 = "What is a convex mirror?";
    static String rightAnswer9 = "A mirror that bulges out in the direction of the light source.";
    static String incorrect1Answer9 = "A mirror that is razor-thin and consumes light.";
    static String incorrect2Answer9 = "Question doesn't make sense.";

    //question10
    static String questionDisplayed10 = "Towards what does light bend to as it passes from one medium to another?";
    static String rightAnswer10 = "Towards the normal.";
    static String incorrect1Answer10 = "Towards the diffraction.";
    static String incorrect2Answer10 = "There is no term for such an occurrence.";

    //question11
    static String questionDisplayed11 = "What is the formula for the index of refraction?";
    static String rightAnswer11 = "N = C / V";
    static String incorrect1Answer11 = "Index of Refraction = R / A";
    static String incorrect2Answer11 = "V = N / C";

    //question12
    static String questionDisplayed12 = "What is the index of refraction?";
    static String rightAnswer12 = "Determines how much the path of light is bent when entering a new medium.";
    static String incorrect1Answer12 = "How much light is bent towards the vertical.";
    static String incorrect2Answer12 = "How much light fluctuates in a medium.";

    //question13
    static String questionDisplayed13 = "What is the index of refraction of a vacuum?";
    static String rightAnswer13 = "Zero.";
    static String incorrect1Answer13 = "Infinity.";
    static String incorrect2Answer13 = "1.92";

    //question14
    static String questionDisplayed14 = "What is the scientific term for a lens that is thinner at the center and spreads light outwards?";
    static String rightAnswer14 = "A concave lens.";
    static String incorrect1Answer14 = "A convex lens.";
    static String incorrect2Answer14 = "A consecutive lens.";

    //question15
    static String questionDisplayed15 = "What is a convex lens?";
    static String rightAnswer15 = "A lens that collects light to a single point behind the lens.";
    static String incorrect1Answer15 = "A lens that refracts light towards all directions.";
    static String incorrect2Answer15 = "A lens that creates heat by absorbing photons.";


    public static String scienceQuestion[] ={
            questionDisplayed,
            questionDisplayed2,
            questionDisplayed3,
            questionDisplayed4,
            questionDisplayed5,
            questionDisplayed6,
            questionDisplayed7,
            questionDisplayed8,
            questionDisplayed9,
            questionDisplayed10,
            questionDisplayed11,
            questionDisplayed12,
            questionDisplayed13,
            questionDisplayed14,
            questionDisplayed15

    };

    public static String selectChoices[][] = {
            {rightAnswer, incorrect1Answer, incorrect2Answer},
            {rightAnswer2, incorrect1Answer2, incorrect2Answer2},
            {incorrect2Answer3, incorrect1Answer3, rightAnswer3},
            {incorrect1Answer4, rightAnswer4, incorrect2Answer4},
            {incorrect2Answer5, incorrect1Answer5, rightAnswer5},
            {incorrect2Answer6, incorrect1Answer6, rightAnswer6},
            {incorrect2Answer7, incorrect1Answer7, rightAnswer7},
            {incorrect1Answer8, rightAnswer8, incorrect2Answer8},
            {incorrect1Answer9, rightAnswer9, incorrect2Answer9},
            {incorrect2Answer10, rightAnswer10, incorrect1Answer10},
            {incorrect1Answer11, rightAnswer11, incorrect2Answer11},
            {rightAnswer12, incorrect1Answer12, incorrect2Answer12},
            {rightAnswer13, incorrect1Answer13, incorrect2Answer13},
            {incorrect1Answer14, incorrect2Answer14, rightAnswer14},
            {rightAnswer15, incorrect1Answer15, incorrect2Answer15}
    };

    public static String correctAnswer[] = {
            rightAnswer,
            rightAnswer2,
            rightAnswer3,
            rightAnswer4,
            rightAnswer5,
            rightAnswer6,
            rightAnswer7,
            rightAnswer8,
            rightAnswer9,
            rightAnswer10,
            rightAnswer11,
            rightAnswer12,
            rightAnswer13,
            rightAnswer14,
            rightAnswer15

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_test_questioning_page3);

        score = 0;
        questionsWrong = "#: ";

        displayedQuestion = findViewById(R.id.displayedQuestion);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        proceedButton = findViewById(R.id.button2);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        proceedButton.setOnClickListener(this);

        loadNextQuestion();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {

        ans1.setBackground(MainActivity.button.getBackground());
        ans2.setBackground(MainActivity.button.getBackground());
        ans3.setBackground(MainActivity.button.getBackground());

        Button pressedButton = (Button) view;
        if(pressedButton.getId()==R.id.button2){
            if(choosenAnswer.equals(correctAnswer[ongoingQuestion])){
                score++;
            }
            else if (!choosenAnswer.equals(correctAnswer[ongoingQuestion])){
                if(questionsWrong.equals("#: ")){
                    questionsWrong += String.valueOf(ongoingQuestion +1);
                }
                else{
                    questionsWrong += ", ";
                    questionsWrong += String.valueOf(ongoingQuestion +1);
                }
            }

            ongoingQuestion++;
            loadNextQuestion();

        }else{
            choosenAnswer = pressedButton.getText().toString();
            pressedButton.setBackgroundColor(Color.parseColor("#ADD8E6"));
        }
    }

    void loadNextQuestion(){
        if (ongoingQuestion == numberOfQuestions){
            Intent intent = new Intent(this, scienceTestRecap3.class);
            startActivity(intent);
            return;
        }

        displayedQuestion.setText(scienceQuestion[ongoingQuestion]);
        ans1.setText(selectChoices[ongoingQuestion][0]);
        ans2.setText(selectChoices[ongoingQuestion][1]);
        ans3.setText(selectChoices[ongoingQuestion][2]);
    }

    @Override
    public void onBackPressed(){
        return;
    }
}