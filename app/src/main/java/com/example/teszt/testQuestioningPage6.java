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
import java.util.Random;
import java.lang.Math;

public class testQuestioningPage6 extends AppCompatActivity implements View.OnClickListener{

    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = mathQuestion.length;

    public static int score = 0;
    int ongoingQuestion = 0;

    String choosenAnswer = "";

    //////////////////////////////////////all question stuff below

    static Random Q1 = new Random();

    //in the question below, the user will have to determine the tan ratio of an angle.
    //question1
    static double degrees  = Q1.nextInt(40)+1; //randomly generate the angle's value in degrees
    static String questionDisplayed = "What is the tan ratio of " + degrees + " degrees?"; //generate the question displayed
    static double rightTan = ((double)Math.round((Math.tan(Math.toRadians(degrees)))*100))/100; //generate the correct double-type answer for the tan ratio (The Math.toRadians() method has to be used because trigonometry in java is done using radians, not degrees)
    static double incorrect1Tan = rightTan + Q1.nextInt(3) + 1; //randomize the tan ratio variables
    static double incorrect2Tan = rightTan + Q1.nextInt(3)+1;
    static String rightAnswer = rightTan + ""; //generate the incorrect and correct answer variables
    static String incorrect1Answer = (double)Math.round(incorrect1Tan*100)/100 + "";
    static String incorrect2Answer = (double)Math.round(incorrect2Tan*100)/100 + "";

    //in the two questions below, the user will have to determine the trig ratio using a triangle's side lengths. i will only comment the question below
    //question2
    static double adjacent2 = Q1.nextInt(20)+1; // randomly generate the opposite and adjacent sides to an angle
    static double opposite2 = Q1.nextInt(20)+1;
    static String questionDisplayed2 = "If the adjacent of an angle is " + adjacent2 + " and the opposite is " + opposite2 + ", what is the tan ratio for the angle?"; //initialize the question displayed
    static String rightAnswer2 = opposite2 + " / " + adjacent2; //state the right and incorrect answer variables
    static String incorrect1Answer2 = adjacent2 + " / " + opposite2;
    static String incorrect2Answer2 = opposite2 + " / " + opposite2;

    //question3
    static double hypotenuse3 = Q1.nextInt(40)+20;
    static double opposite3 = Q1.nextInt(20)+1;
    static String questionDisplayed3 = "If the opposite of an angle is " + opposite3 + " and the hypotenuse is " + hypotenuse3 + ", what is the sin ratio for the angle?";
    static String rightAnswer3 = opposite3+ " / " + hypotenuse3;
    static String incorrect1Answer3 = hypotenuse3 + " / " + opposite3;
    static String incorrect2Answer3 = opposite3 + " / " + opposite3;

    //in the 3 questions below, the user will have to find a sidelength using another sidelength and an angle. i will only comment the question below
    //question4
    static double hypotenuse4 = Q1.nextInt(40)+20; //randomly generate the hypotenuse and the angle
    static double angle4 = Q1.nextInt(20)+1;
    static String questionDisplayed4 = "If the hypotenuse is " + hypotenuse4 + " and the angle it makes with the adjacent is " + angle4 + " degrees, what is the length of the opposite relative to the angle?"; //initialize the question displayed variable
    static double opposite4 = ((double)Math.round((hypotenuse4 * Math.sin(Math.toRadians(angle4)))*100))/100; //calculate the right answer by calculating the opposite
    static double wrong1Opposite4 = opposite4 + 1 + Q1.nextInt(5); //these are the randomization variables for the incorrect answers, just a different name unlike before
    static double wrong2Opposite4 = opposite4 + 1 + Q1.nextInt(5);
    static String rightAnswer4 = "The opposite's length is " + opposite4; //initialize the right and incorrect answer variables
    static String incorrect1Answer4 = "The opposite's length is " + (double)Math.round(wrong1Opposite4*100)/100;
    static String incorrect2Answer4 = "The opposite's length is " + (double)Math.round(wrong2Opposite4*100)/100;

    //question5
    static double adjacent5 = Q1.nextInt(40)+1;
    static double angle5 = Q1.nextInt(40)+1;
    static String questionDisplayed5 = "If the adjacent is " + adjacent5 + " and the angle it makes with the hypotenuse is " + angle5 + " degrees, what is the length of the opposite relative to the angle?";
    static double opposite5 = ((double)Math.round((adjacent5 * Math.tan(Math.toRadians(angle5)))*100))/100;
    static double wrong1Adjacent5 = opposite5 + 1 + Q1.nextInt(5);
    static double wrong2Adjacent5 = opposite5 + 1 + Q1.nextInt(5);
    static String rightAnswer5 = "The opposite's length is " + opposite5;
    static String incorrect1Answer5 = "The opposite's length is " + (double)Math.round(wrong1Adjacent5*100)/100;
    static String incorrect2Answer5 = "The opposite's length is " + (double)Math.round(wrong2Adjacent5*100)/100;

    //question6
    static double adjacent6 = Q1.nextInt(40)+1;
    static double angle6 = Q1.nextInt(40)+1;
    static String questionDisplayed6 = "If the adjacent is " + adjacent6 + " and the angle it makes with the hypotenuse is " + angle6 + " degrees, what is the length of the opposite relative to the angle?";
    static double opposite6 = ((double)Math.round((adjacent6 * Math.tan(Math.toRadians(angle6)))*100))/100;
    static double wrong1Adjacent6 = opposite6 + 1 + Q1.nextInt(5);
    static double wrong2Adjacent6 = opposite6 + 1 + Q1.nextInt(5);
    static String rightAnswer6 = "The opposite's length is " + opposite6;
    static String incorrect1Answer6 = "The opposite's length is " + (double)Math.round(wrong1Adjacent6*100)/100;
    static String incorrect2Answer6 = "The opposite's length is " + (double)Math.round(wrong2Adjacent6*100)/100;

    //in the three questions below, the user will have to find an angle in a triangle using sidelengths. i will only comment the question below
    //question7
    static double hypotenuse7 = Q1.nextInt(40)+20; //randomly generate the hypotenuse and adjacent of the triangle
    static double adjacent7 = Q1.nextInt(20)+1;
    static String questionDisplayed7 = "If the hypotenuse is " + hypotenuse7 + " and the adjacent of an angle is " + adjacent7 + ", what is the angle in degrees?"; //initialize the question displayed variable
    static double correctAngle7 = ((double)Math.round(Math.toDegrees((Math.acos(adjacent7/hypotenuse7)))*100))/100; //find the correct angle using trig
    static double incorrect1Angle7 = correctAngle7 + 1 + Q1.nextInt(10); //randomize the correct angle variable - once again, this is for the incorrect answers
    static double incorrect2Angle7 = correctAngle7 + 1 + Q1.nextInt(10);
    static String rightAnswer7 = "The angle is " + correctAngle7 + "."; //initialize the right and incorrect answer variables
    static String incorrect1Answer7 = "The angle is " + (double)Math.round(incorrect1Angle7*100)/100 + ".";
    static String incorrect2Answer7 = "The angle is " + incorrect2Angle7 + ".";

    //question8
    static double opposite8 = Q1.nextInt(40)+1;
    static double adjacent8 = Q1.nextInt(20)+1;
    static String questionDisplayed8 = "If the opposite is " + opposite8 + " and the adjacent of an angle is " + adjacent8 + ", what is the angle in degrees?";
    static double correctAngle8 = ((double)Math.round(Math.toDegrees((Math.atan(opposite8/adjacent8)))*100))/100;
    static double incorrect1Angle8 = correctAngle8 + 1 + Q1.nextInt(10);
    static double incorrect2Angle8 = correctAngle8 + 1 + Q1.nextInt(10);
    static String rightAnswer8 = "The angle is " + correctAngle8 + ".";
    static String incorrect1Answer8 = "The angle is " + (double)Math.round(incorrect1Angle8*100)/100 + ".";
    static String incorrect2Answer8 = "The angle is " + (double)Math.round(incorrect2Angle8*100)/100 + ".";

    //question9
    static double hypotenuse9 = Q1.nextInt(40)+20;
    static double opposite9 = Q1.nextInt(20)+1;
    static String questionDisplayed9 = "If the hypotenuse is " + hypotenuse9 + " and the opposite of an angle is " + opposite9 + ", what is the angle in degrees?";
    static double correctAngle9 = ((double)Math.round(Math.toDegrees((Math.asin(opposite9/hypotenuse9)))*100))/100;
    static double incorrect1Angle9 = correctAngle9 + 1 + Q1.nextInt(10);
    static double incorrect2Angle9 = correctAngle9 + 1 + Q1.nextInt(10);
    static String rightAnswer9 = "The angle is " + correctAngle9 + ".";
    static String incorrect1Answer9 = "The angle is " + (double)Math.round(incorrect1Angle9*100)/100 + ".";
    static String incorrect2Answer9 = "The angle is " + (double)Math.round(incorrect2Angle9*100)/100 + ".";

    //in the three questions below, the user will have to use sine law to solve for something in a triangle. i will only comment the question below
    //question10
    static double AC10 = Q1.nextInt(15)+1; //randomly generate one of the triangle sides
    static double angleB10 = Q1.nextInt(60)+1; //randomly generate the angles
    static double angleC10 = Q1.nextInt(60)+1;
    static String questionDisplayed10 =  "If in a triangle ACB, the length AC is equal to " + AC10 + ", the angle B is equal to " + angleB10 + " degrees and the angle C is equal to " + angleC10 + " degrees, determine the length of AB."; //initialize the question displayed variable
    static double AB10 = ((double)Math.round((AC10*Math.sin(Math.toRadians(angleC10))/Math.sin(Math.toRadians(angleB10)))*100))/100; //calculate the correct answer for the side that the user has to find
    static double incorrect1AB10 = AB10 + Q1.nextInt(15)+1; //randomize for the purpose of the incorrect answers
    static double incorrect2AB10 = AB10 + 1 + Q1.nextInt(15);
    static String rightAnswer10 = "The length AB is equal to " + AB10; //state the right and incorrect answer variables
    static String incorrect1Answer10 = "The length AB is equal to " + (double)Math.round(incorrect1AB10*100)/100;
    static String incorrect2Answer10 = "The length AB is equal to " + (double)Math.round(incorrect2AB10*100)/100;

    //question11
    static double AC11 = Q1.nextInt(15)+1;
    static double angleB11 = Q1.nextInt(60)+1;
    static double angleC11 = Q1.nextInt(60)+1;
    static String questionDisplayed11 =  "If in a triangle ACB, the length AC is equal to " + AC11 + ", the angle B is equal to " + angleB11 + " degrees and the angle C is equal to " + angleC11 + " degrees, determine the length of AB.";
    static double AB11 = ((double)Math.round((AC11*Math.sin(Math.toRadians(angleC11))/Math.sin(Math.toRadians(angleB11)))*100))/100;
    static double incorrect1AB11 = AB11 + Q1.nextInt(15)+1;
    static double incorrect2AB11 = AB11 + 1 + Q1.nextInt(15);
    static String rightAnswer11 = "The length AB is equal to " + AB11;
    static String incorrect1Answer11 = "The length AB is equal to " + (double)Math.round(incorrect1AB11*100)/100;
    static String incorrect2Answer11 = "The length AB is equal to " + (double)Math.round(incorrect2AB11*100)/100;

    //question12
    static double AC12 = Q1.nextInt(15)+1;
    static double angleB12 = Q1.nextInt(60)+1;
    static double angleC12 = Q1.nextInt(60)+1;
    static String questionDisplayed12 =  "If in a triangle ACB, the length AC is equal to " + AC12 + ", the angle B is equal to " + angleB12 + " degrees and the angle C is equal to " + angleC12 + " degrees, determine the length of AB.";
    static double AB12 = ((double)Math.round((AC12*Math.sin(Math.toRadians(angleC12))/Math.sin(Math.toRadians(angleB12)))*100))/100;
    static double incorrect1AB12 = AB10 + Q1.nextInt(15)+1;
    static double incorrect2AB12 = AB10 + 1 + Q1.nextInt(15);
    static String rightAnswer12 = "The length AB is equal to " + AB12;
    static String incorrect1Answer12 = "The length AB is equal to " + (double)Math.round(incorrect1AB12*100)/100;
    static String incorrect2Answer12 = "The length AB is equal to " + (double)Math.round(incorrect2AB12*100)/100;

    //in the remaining questions of this test, the user will have to use cosine law. i will only comment the question below
    //question13
    static double A13 = Q1.nextInt(15)+1; //randomly generate the two sides needed for the cosine law
    static double B13 = Q1.nextInt(15)+1;
    static double angleC13 = Q1.nextInt(15)+1; //randomly generate one angle needed for the cosine law
    static String questionDisplayed13 = "The following triangle has these values for a, b and angle c respectively: " + A13 + ", " + B13 + ", " + angleC13 + " degrees. Determine the length of C."; //initialize the question displayed variable
    static double correctLength13 = ((double)Math.round((A13*A13 + B13*B13 - 2*A13*B13*Math.cos(Math.toRadians(angleC13)))*100))/100; //apply cosine law and determine the correct answer for the sidelength that the user has to determine
    static double incorrect1Length13 = correctLength13 + 1 + Q1.nextInt(15); //randomize the sidelength in these two lines of code here for the purpose of the incorrect variables - just as done previously
    static double incorrect2Length13 = correctLength13 + 1 + Q1.nextInt(15);
    static String rightAnswer13 = "The length of C is " + correctLength13; //initialize the right and incorrect answer variables.
    static String incorrect1Answer13 = "The length of C is " + (double)Math.round(incorrect1Length13*100)/100;
    static String incorrect2Answer13 = "The length of C is " + (double)Math.round(incorrect2Length13*100)/100;

    //question14
    static double A14 = Q1.nextInt(15)+1;
    static double B14 = Q1.nextInt(15)+1;
    static double angleC14 = Q1.nextInt(15)+1;
    static String questionDisplayed14 = "The following triangle has these values for a, b and angle c respectively: " + A14 + ", " + B14 + ", " + angleC14 + " degrees. Determine the length of C.";
    static double correctLength14 = ((double)Math.round((A14*A14 + B14*B14 - 2*A14*B14*Math.cos(Math.toRadians(angleC14)))*100))/100;
    static double incorrect1Length14 = correctLength14 + 1 + Q1.nextInt(15);
    static double incorrect2Length14 = correctLength14 + 1 + Q1.nextInt(15);
    static String rightAnswer14 = "The length of C is " + correctLength14;
    static String incorrect1Answer14 = "The length of C is " + (double)Math.round(incorrect1Length14*100)/100;
    static String incorrect2Answer14 = "The length of C is " + (double)Math.round(incorrect2Length14*100)/100;

    //question15
    static double A15 = Q1.nextInt(15)+1;
    static double B15 = Q1.nextInt(15)+1;
    static double angleC15 = Q1.nextInt(15)+1;
    static String questionDisplayed15 = "The following triangle has these values for a, b and angle c respectively: " + A15 + ", " + B15 + ", " + angleC15 + " degrees. Determine the length of C.";
    static double correctLength15 = ((double)Math.round((A15*A15 + B15*B15 - 2*A15*B15*Math.cos(Math.toRadians(angleC15)))*100))/100;
    static double incorrect1Length15 = correctLength15 + 1 + Q1.nextInt(15);
    static double incorrect2Length15 = correctLength15 + 1 + Q1.nextInt(15);
    static String rightAnswer15 = "The length of C is " + correctLength15;
    static String incorrect1Answer15 = "The length of C is " + (double)Math.round(incorrect1Length15*100)/100;
    static String incorrect2Answer15 = "The length of C is " + (double)Math.round(incorrect2Length15*100)/100;

    ////////////////////////////////////////////// question stuff ends

    public static String mathQuestion[] ={ //the questions displayed in the GUI are taken from this array
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
    public static String selectChoices[][] = { //this array is where all the text/strings for the multiple-choice buttons is located
            {rightAnswer, incorrect2Answer, incorrect1Answer},
            {rightAnswer2, incorrect1Answer2, incorrect2Answer2},
            {incorrect1Answer3, rightAnswer3, incorrect2Answer3},
            {incorrect1Answer4, rightAnswer4, incorrect2Answer4},
            {incorrect1Answer5, incorrect2Answer5, rightAnswer5},
            {incorrect1Answer6, incorrect2Answer6, rightAnswer6},
            {incorrect1Answer7, incorrect2Answer7, rightAnswer7},
            {incorrect1Answer8, rightAnswer8, incorrect2Answer8},
            {incorrect1Answer9, rightAnswer9, incorrect2Answer9},
            {rightAnswer10, incorrect1Answer10, incorrect2Answer10},
            {rightAnswer11, incorrect1Answer11, incorrect2Answer11},
            {rightAnswer12, incorrect2Answer12, incorrect1Answer12},
            {incorrect1Answer13, incorrect2Answer13, rightAnswer13},
            {incorrect1Answer14, incorrect2Answer14, rightAnswer14},
            {rightAnswer15, incorrect2Answer15, incorrect1Answer15}


    };
    public static String correctAnswer[] = { //this array contains the correct answer for each question
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
        setContentView(R.layout.activity_test_questioning_page6); // set the .xml file in review to the corresponding test questioning page xml file

        score = 0; //score value will store the number of questions the user gets right
        questionsWrong = "#: "; //this string will have the question number of each incorrectly answered question stored

        displayedQuestion = findViewById(R.id.displayedQuestion); //set these variables to the gui elements that exist in the .xml file
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        proceedButton = findViewById(R.id.button2);

        ans1.setOnClickListener(this); //set an onclick listener function for all of these. if a button press is detected, then the onClick function below will be performed by the program
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        proceedButton.setOnClickListener(this);

        loadNextQuestion(); //load the first/next question
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {

        ans1.setBackground(MainActivity.button.getBackground()); // set the background to the default button background. In the event of several button presses, you want all the buttons to have a default background except the one that has been clicked, hence this is why I have added this code
        ans2.setBackground(MainActivity.button.getBackground());
        ans3.setBackground(MainActivity.button.getBackground());

        Button pressedButton = (Button) view; // assign a variable for the button that gets pressed
        if(pressedButton.getId()==R.id.button2){ //if the pressed button is equal to the proceed button (User clicks the proceed button if they're finished with the question)
            if(choosenAnswer.equals(correctAnswer[ongoingQuestion])){ //check if the answer that they have chosen equals the corresponding question's correct answer
                score++; // add a score if the if statement's conditions are met
            }
            else if (!choosenAnswer.equals(correctAnswer[ongoingQuestion])){ //if the user's chosen answer does not equal the corresponding question's correct answer
                if(questionsWrong.equals("#: ")){ //if the questionsWrong string is already empty, simply add the question's number without a comma before
                    questionsWrong += String.valueOf(ongoingQuestion +1);
                }
                else{ // if the questionsWrong string is not already empty, add a comma then the question number of the question that the user got wrong
                    questionsWrong += ", ";
                    questionsWrong += String.valueOf(ongoingQuestion +1);
                }
            }

            ongoingQuestion++; //add a number to the user's ongoing question
            loadNextQuestion(); //load the next question

        }else{
            choosenAnswer = pressedButton.getText().toString(); //if the user does not click the proceed button but instead clicks one of the multiple choice buttons, get the text of the multiple choice button into a string and set the clicked button to a square-border with a constant colour (no gradient)
            pressedButton.setBackgroundColor(Color.parseColor("#ADD8E6"));
        }
    }

    void loadNextQuestion(){ //here is the load next question function - the function that loads the next or first question
        if (ongoingQuestion == numberOfQuestions){ //if the user's question number is equal to the number of questions that are in the test, send the user to the testRecap page where they will receive a recap of their performance
            Intent intent = new Intent(this, testRecap6.class);
            startActivity(intent); //start the activity of sending the user to the testRecap page
            return;
        }

        displayedQuestion.setText(mathQuestion[ongoingQuestion]); //else, set the text of the displayed question to the next question and set it's choices to the choices of the next question as well.
        ans1.setText(selectChoices[ongoingQuestion][0]);
        ans2.setText(selectChoices[ongoingQuestion][1]);
        ans3.setText(selectChoices[ongoingQuestion][2]);
    }

    @Override
    public void onBackPressed(){
        return;
    } //this disables the back button so the user cannot back out the test while they are completing the test
}