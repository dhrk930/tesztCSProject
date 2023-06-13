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

public class scienceTestQuestioningPage extends AppCompatActivity implements View.OnClickListener{

    ///////////////// a proper explanation of this page is located in the "testQuestioningPage.java" file
    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = scienceQuestion.length;

    public static int score = 0;
    int ongoingQuestion = 0;
    String choosenAnswer = "";

    //variables for question1
    static String questionDisplayed = "What is the atomic symbol for oxygen?";
    static String rightAnswer = "O";
    static String incorrect1Answer = "Ox";
    static String incorrect2Answer = "Oe";

    //question2
    static String questionDisplayed2 = "What is the atomic symbol for sodium?";
    static String rightAnswer2 = "Na";
    static String incorrect1Answer2 = "N";
    static String incorrect2Answer2 = "Sm";

    //question3
    static String questionDisplayed3 = "What is the atomic symbol for nitrogen?";
    static String rightAnswer3 = "N";
    static String incorrect1Answer3 = "Ni";
    static String incorrect2Answer3 = "Gn";

    //question4
    static String questionDisplayed4 = "What is the atomic symbol for copper?";
    static String rightAnswer4 = "Cu";
    static String incorrect1Answer4 = "Co";
    static String incorrect2Answer4 = "Cr";

    //question5
    static String questionDisplayed5 = "What is the atomic symbol for gold?";
    static String rightAnswer5 = "Au";
    static String incorrect1Answer5 = "Go";
    static String incorrect2Answer5 = "G";

    //question6
    static String questionDisplayed6 = "How many valence electrons does sodium have?";
    static String rightAnswer6 = "1";
    static String incorrect1Answer6 = "2";
    static String incorrect2Answer6 = "0";

    //question7
    static String questionDisplayed7 = "How many valence electrons does uranium have?";
    static String rightAnswer7 = "6";
    static String incorrect1Answer7 = "5";
    static String incorrect2Answer7 = "Radioactive substances can't hold onto valence electrons.";

    //question8
    static String questionDisplayed8 = "Is a pH of 7 neutral or acidic?";
    static String rightAnswer8 = "Neutral.";
    static String incorrect1Answer8 = "Acidic.";
    static String incorrect2Answer8 = "Question doesn't make sense.";

    //question9
    static String questionDisplayed9 = "Is a pH of 9 acidic or basic?";
    static String rightAnswer9 = "Slightly basic.";
    static String incorrect1Answer9 = "Completely acidic.";
    static String incorrect2Answer9 = "Question doesn't make sense.";

    //question10
    static String questionDisplayed10 = "What is the pH range of a weak base?";
    static String rightAnswer10 = "Slightly above a pH of 7.";
    static String incorrect1Answer10 = "A pH of near 14.";
    static String incorrect2Answer10 = "A pH of 3.";

    //question11
    static String questionDisplayed11 = "How many electrons does chlorine have?";
    static String rightAnswer11 = "17";
    static String incorrect1Answer11 = "14";
    static String incorrect2Answer11 = "12.5";

    //question12
    static String questionDisplayed12 = "Do ionic compounds have a low, middle or high melting point?";
    static String rightAnswer12 = "High.";
    static String incorrect1Answer12 = "Extremely low.";
    static String incorrect2Answer12 = "The bonds are so strong that they don't melt.";

    //question13
    static String questionDisplayed13 = "Are electrons shared or transferred in a covalent bond?";
    static String rightAnswer13 = "Shared.";
    static String incorrect1Answer13 = "Transferred.";
    static String incorrect2Answer13 = "The electrons are lost in favour of an electromagnetic bond.";

    //question14
    static String questionDisplayed14 = "What is produced in an acid-base neutralization reaction?";
    static String rightAnswer14 = "Water and a salt.";
    static String incorrect1Answer14 = "Two acids and one base.";
    static String incorrect2Answer14 = "The base products do not change.";

    //question15
    static String questionDisplayed15 = "Do covalent compounds have two non-metals or two minerals and an ionic salt?";
    static String rightAnswer15 = "Two or more non-metals.";
    static String incorrect1Answer15 = "Two minerals and an ionic salt.";
    static String incorrect2Answer15 = "Three minerals and an oxygen atom.";


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
        setContentView(R.layout.activity_science_test_questioning_page);

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
            Intent intent = new Intent(this, scienceTestRecap.class);
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