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

public class testQuestioningPage2 extends AppCompatActivity implements View.OnClickListener{

    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = mathQuestion.length;

    public static int score = 0;
    int ongoingQuestion = 0;
    String choosenAnswer = "";

    ////////////////////////////////////// all question stuff below

    static Random Q1 = new Random();

    //In questions 1-6, the user will have to find the midpoint or endpoint of a line formed by two points. Because these aforementioned questions are of the same type, I will only comment the first question below.
    //question 1
    static double startX = Q1.nextInt(15); //first coordinate's x value is randomly generated
    static double startY = Q1.nextInt(15); //first coordinate's y-value
    static double endX = Q1.nextInt(15); //second coordinate's x-value
    static double endY = Q1.nextInt(15); //second coordinate's y-value
    static double answerXInt = ((startX + endX)/2); //the correct midpoint's x-value is assigned to here
    static double answerYInt= ((startY + endY)/2); //the correct midpoint's y-value is assigned to here
    static String rightAnswer = "The x-value is " + (double)Math.round(answerXInt*100)/100 + " and the y-value is " + (double)Math.round(answerYInt*100)/100; // the correct answer string is formed
    static double answerXIntRandomizer = answerXInt +1+ Q1.nextInt(8); //as stated previously (Question 1: Unit 1 comments), these randomizer variables are for the incorrect answers.
    static double answerYIntRandomizer = answerYInt +1+ Q1.nextInt(8);
    static double answer2XIntRandomizer = answerXInt +1+ Q1.nextInt(8);
    static double answer2YIntRandomizer = answerYInt +1+ Q1.nextInt(8);
    static String incorrect1Answer = "The x-value is " + (double)Math.round(answerXIntRandomizer*100)/100 + " and the y-value is " + (double)Math.round(answerYIntRandomizer*100)/100; // the incorrect answers are initialized using the randomized variables
    static String incorrect2Answer = "The x-value is " + (double)Math.round(answer2XIntRandomizer*100)/100 + " and the y-value is " + (double)Math.round(answer2YIntRandomizer*100)/100;

    //question 2
    static double startX2 = Q1.nextInt(15);
    static double startY2 = Q1.nextInt(15);
    static double endX2 = Q1.nextInt(15);
    static double endY2 = Q1.nextInt(15);
    static double answerXInt2 = ((startX2 + endX2)/2);
    static double answerYInt2= ((startY2 + endY2)/2);
    static String rightAnswer2 = "The x-value is " + (double)Math.round(answerXInt2*100)/100 + " and the y-value is " + (double)Math.round(answerYInt2*100)/100;
    static double answerXIntRandomizer2 = answerXInt2 +1+ Q1.nextInt(8);
    static double answerYIntRandomizer2 = answerYInt2 +1+ Q1.nextInt(8);
    static double answer2XIntRandomizer2 = answerXInt2 +1+ Q1.nextInt(8);
    static double answer2YIntRandomizer2 = answerYInt2 +1+ Q1.nextInt(8);
    static String incorrect1Answer2 = "The x-value is " + (double)Math.round(answerXIntRandomizer2*100)/100 + " and the y-value is " + (double)Math.round(answerYIntRandomizer2*100)/100;
    static String incorrect2Answer2 = "The x-value is " + (double)Math.round(answer2XIntRandomizer2*100)/100 + " and the y-value is " + (double)Math.round(answer2YIntRandomizer2*100)/100;

    //question 3
    static double startX3 = Q1.nextInt(15);
    static double startY3 = Q1.nextInt(15);
    static double endX3 = Q1.nextInt(15);
    static double endY3 = Q1.nextInt(15);
    static double answerXInt3 = ((startX3 + endX3)/2);
    static double answerYInt3= ((startY3 + endY3)/2);
    static String rightAnswer3 = "The x-value is " + (double)Math.round(answerXInt3*100)/100 + " and the y-value is " + (double)Math.round(answerYInt3*100)/100;
    static double answerXIntRandomizer3 = answerXInt3 +1+ Q1.nextInt(8);
    static double answerYIntRandomizer3 = answerYInt3 +1+ Q1.nextInt(8);
    static double answer2XIntRandomizer3 = answerXInt3 +1+ Q1.nextInt(8);
    static double answer2YIntRandomizer3 = answerYInt3 +1+ Q1.nextInt(8);
    static String incorrect1Answer3 = "The x-value is " + (double)Math.round(answerXIntRandomizer3*100)/100 + " and the y-value is " + (double)Math.round(answerYIntRandomizer3*100)/100;
    static String incorrect2Answer3 = "The x-value is " + (double)Math.round(answer2XIntRandomizer3*100)/100 + " and the y-value is " + (double)Math.round(answer2YIntRandomizer3*100)/100;

    //question 4
    static double startX4 = Q1.nextInt(15);
    static double startY4 = Q1.nextInt(15);
    static double middleX4 = Q1.nextInt(15);
    static double middleY4 = Q1.nextInt(15);
    static double rightAnswerEndX4 = 0;
    static double rightAnswerEndY4 = 0;

    static{
        if(middleX4==startX4){
            middleX4 += 5;
        }
        if(middleX4 > startX4){
            rightAnswerEndX4 = middleX4+(middleX4-startX4);
        }
        else if(middleX4 < startX4){
            rightAnswerEndX4 = middleX4-(startX4-middleX4);
        }

        if(middleY4==startY4){
            startY4 +=5;
        }
        if(middleY4 > startY4){
            rightAnswerEndY4 = middleY4+(middleY4-startY4);
        }
        else if (middleY4 < startX4){
            rightAnswerEndY4 = middleY4-(startY4-middleY4);
        }
    }
    static double answerXRandomizer4 = rightAnswerEndX4+1+Q1.nextInt(8);
    static double answerYRandomizer4 = rightAnswerEndY4+1+Q1.nextInt(8);
    static double answer2XRandomizer4 = rightAnswerEndX4+1+Q1.nextInt(8);
    static double answer2YRandomizer4 = rightAnswerEndY4+1+Q1.nextInt(8);
    static String rightAnswer4 = "The x-value is " + (double)Math.round(rightAnswerEndX4*100)/100 + " and the y-value is " + (double)Math.round(rightAnswerEndY4*100)/100;
    static String incorrect1Answer4 = "The x-value is " + (double)Math.round(answerXRandomizer4*100)/100 + " and the y-value is " + (double)Math.round(answerYRandomizer4*100)/100;
    static String incorrect2Answer4 = "The x-value is " + (double)Math.round(answer2XRandomizer4*100)/100 + " and the y-value is " + (double)Math.round(answer2YRandomizer4*100)/100;

    //question 5
    static double startX5 = Q1.nextInt(15);
    static double startY5 = Q1.nextInt(15);
    static double middleX5 = Q1.nextInt(15);
    static double middleY5 = Q1.nextInt(15);
    static double rightAnswerEndX5 = 0;
    static double rightAnswerEndY5 = 0;

    static{
        if(middleX5==startX5){
            middleX5 += 5;
        }
        if(middleX5 > startX5){
            rightAnswerEndX5 = middleX5+(middleX5-startX5);
        }
        else if(middleX5 < startX5){
            rightAnswerEndX5 = middleX5-(startX5-middleX5);
        }

        if(middleY5==startY5){
            startY5 +=5;
        }
        if(middleY5 > startY5){
            rightAnswerEndY5 = middleY5+(middleY5-startY5);
        }
        else if (middleY5 < startX5){
            rightAnswerEndY5 = middleY5-(startY5-middleY5);
        }
    }
    static double answerXRandomizer5 = rightAnswerEndX5+1+Q1.nextInt(8);
    static double answerYRandomizer5 = rightAnswerEndY5+1+Q1.nextInt(8);
    static double answer2XRandomizer5 = rightAnswerEndX5+1+Q1.nextInt(8);
    static double answer2YRandomizer5 = rightAnswerEndY5+1+Q1.nextInt(8);
    static String rightAnswer5 = "The x-value is " + (double)Math.round(rightAnswerEndX5*100)/100 + " and the y-value is " + (double)Math.round(rightAnswerEndY5*100)/100;
    static String incorrect1Answer5 = "The x-value is " + (double)Math.round(answerXRandomizer5*100)/100 + " and the y-value is " + (double)Math.round(answerYRandomizer5*100)/100;
    static String incorrect2Answer5 = "The x-value is " + (double)Math.round(answer2XRandomizer5*100)/100 + " and the y-value is " + (double)Math.round(answer2YRandomizer5*100)/100;

    //question6
    static double startX6 = Q1.nextInt(15);
    static double startY6 = Q1.nextInt(15);
    static double middleX6 = Q1.nextInt(15);
    static double middleY6 = Q1.nextInt(15);
    static double rightAnswerEndX6 = 0;
    static double rightAnswerEndY6 = 0;

    static{
        if(middleX6==startX6){
            middleX6 += 5;
        }
        if(middleX6 > startX6){
            rightAnswerEndX6 = middleX6+(middleX6-startX6);
        }
        else if(middleX6 < startX6){
            rightAnswerEndX6 = middleX6-(startX6-middleX6);
        }

        if(middleY6==startY6){
            startY6 +=5;
        }
        if(middleY6 > startY6){
            rightAnswerEndY6 = middleY6+(middleY6-startY6);
        }
        else if (middleY6 < startX6){
            rightAnswerEndY6 = middleY6-(startY6-middleY6);
        }
    }
    static double answerXRandomizer6 = rightAnswerEndX6+1+Q1.nextInt(8);
    static double answerYRandomizer6 = rightAnswerEndY6+1+Q1.nextInt(8);
    static double answer2XRandomizer6 = rightAnswerEndX6+1+Q1.nextInt(8);
    static double answer2YRandomizer6 = rightAnswerEndY6+1+Q1.nextInt(8);
    static String rightAnswer6 = "The x-value is " + (double)Math.round(rightAnswerEndX6*100)/100 + " and the y-value is " + (double)Math.round(rightAnswerEndY6*100)/100;
    static String incorrect1Answer6 = "The x-value is " + (double)Math.round(answerXRandomizer6*100)/100 + " and the y-value is " + (double)Math.round(answerYRandomizer6*100)/100;
    static String incorrect2Answer6 = "The x-value is " + (double)Math.round(answer2XRandomizer6*100)/100 + " and the y-value is " + (double)Math.round(answer2YRandomizer6*100)/100;

    //In questions 7-9, the user will have to find the length of a line formed by two points. Because these aforementioned questions are of the same type, I will only comment the question below.
    //question7
    static double startX7 = Q1.nextInt(15); //this is the start point's x-value
    static double startY7 = Q1.nextInt(15); //this is the start point's y-value
    static double endX7 = Q1.nextInt(15); //this is the end point's x-value
    static double endY7 = Q1.nextInt(15); //this is the end point's y-value
    static double base = 0; //because the pythagorean theorem will be used to find the length of this line, base/height variables need to be initialized
    static double height = 0;

    static{
        if(endX7==startX7){ //if the end point's x-value equals the start point's x-value, add 5 to the end point's x-value
            endX7 += 5;
        }
        if(endY7==startY7){ //if the end point's y-value equals the start point's y-value, add 5 to the start point's y-value
            startY7 +=5;
        }

        if(endX7>startX7){ //if the end point's x-value is larger than the start point's x-value, complete a certain formula to find the base of the right-angled triangle formed
            base = endX7-startX7;
        }
        else if(startX7>endX7){ //if the end point's x-value is smaller than the start point's x-value, complete a certain formula to find the base of the right-angled triangle formed
            base = startX7-endX7;
        }

        if(endY7>startY7){ //if the end point's y-value is larger than the start point's y-value, complete a certain formula to find the height of the right-angled triangle formed
            height = endY7-startY7;
        }
        else if(startY7>endY7){ //if the end point's y-value is smaller than the start point's y-value, complete a certain formula to find the height of the right-angled triangle formed
            height = startY7-endY7;
        }
    }
    static double length = Math.sqrt(height*height+base*base); //the pythagorean theorem is used here to find the hypotenuse/length of the line
    static double firstRandomizer = length +Q1.nextInt(8)+1; //randomizer variables for the incorrect answers
    static double secondRandomizer = length +Q1.nextInt(8)+1;
    static String rightAnswer7 = "The length is " + (double)Math.round(length*100)/100; //correct answer is initialized using the length variable
    static String incorrect1Answer7 = "The length is " + (double)Math.round(firstRandomizer*100)/100; //incorrect answers are initialized using the randomized variables
    static String incorrect2Answer7 = "The length is " + (double)Math.round(secondRandomizer*100)/100;

    //question8
    static double startX8 = Q1.nextInt(15);
    static double startY8 = Q1.nextInt(15);
    static double endX8 = Q1.nextInt(15);
    static double endY8 = Q1.nextInt(15);
    static double base8 = 0;
    static double height8 = 0;

    static{
        if(endX8==startX8){
            endX8 += 5;
        }
        if(endY8==startY8){
            startY8 +=5;
        }

        if(endX8>startX8){
            base8 = endX8-startX8;
        }
        else if(startX8>endX8){
            base8 = startX8-endX8;
        }

        if(endY8>startY8){
            height8 = endY8-startY8;
        }
        else if(startY8>endY8){
            height8 = startY8-endY8;
        }
    }
    static double length8 = Math.sqrt(height8*height8+base8*base8);
    static double firstRandomizer8 = length8 +Q1.nextInt(8)+1;
    static double secondRandomizer8 = length8 +Q1.nextInt(8)+1;
    static String rightAnswer8 = "The length is " + (double)Math.round(length8*100)/100;
    static String incorrect1Answer8 = "The length is " + (double)Math.round(firstRandomizer8*100)/100;
    static String incorrect2Answer8 = "The length is " + (double)Math.round(secondRandomizer8*100)/100;

    //question9
    static double startX9 = Q1.nextInt(15);
    static double startY9 = Q1.nextInt(15);
    static double endX9 = Q1.nextInt(15);
    static double endY9 = Q1.nextInt(15);
    static double base9 = 0;
    static double height9 = 0;

    static{
        if(endX9==startX9){
            endX9 += 5;
        }
        if(endY9==startY9){
            startY9 +=5;
        }

        if(endX9>startX9){
            base9 = endX9-startX9;
        }
        else if(startX9>endX9){
            base9 = startX9-endX9;
        }

        if(endY9>startY9){
            height9 = endY9-startY9;
        }
        else if(startY9>endY9){
            height9 = startY9-endY9;
        }
    }
    static double length9 = Math.sqrt(height9*height9+base9*base9);
    static double firstRandomizer9 = length9 +Q1.nextInt(8)+1;
    static double secondRandomizer9 = length9 +Q1.nextInt(8)+1;
    static String rightAnswer9 = "The length is " + (double)Math.round(length9*100)/100;
    static String incorrect1Answer9 = "The length is " + (double)Math.round(firstRandomizer9*100)/100;
    static String incorrect2Answer9 = "The length is " + (double)Math.round(secondRandomizer9*100)/100;

    // in the two questions below, the user has to find equation of a circle given it's radius. I will only comment the question directly below because the two questions below are of the same type.
    //question10
    static double radius10 = Q1.nextInt(50); //randomly generate the radius of the circle
    static double rightEquationSide = radius10*radius10; //find the right side of the circle's equation by squaring the radius
    static double firstRandomizer10 = rightEquationSide + Q1.nextInt(8)+1; //randomize these variables for the incorrect equations, as done previously
    static double secondRandomizer10 = rightEquationSide +Q1.nextInt(8)+1;
    static String rightAnswer10 = "The equation is: x^2 + y^2 = " + (double)Math.round(rightEquationSide*100)/100; //use the correct right side of the equation variable to initialize the correct answer
    static String incorrect1Answer10 = "The equation is: x^2 + y^2 = " + (double)Math.round(firstRandomizer10*100)/100; //initialize the incorrect answers using the randomized right side of the equation variable
    static String incorrect2Answer10 = "The equation is: x^2 + y^2 = " + (double)Math.round(secondRandomizer10*100)/100;

    //question11
    static double radius11 = Q1.nextInt(50);
    static double rightEquationSide11 = radius11*radius11;
    static double firstRandomizer11 = rightEquationSide11 + Q1.nextInt(8)+1;
    static double secondRandomizer11 = rightEquationSide11 +Q1.nextInt(8)+1;
    static String rightAnswer11 = "The equation is: x^2 + y^2 = " + (double)Math.round(rightEquationSide11*100)/100;
    static String incorrect1Answer11 = "The equation is: x^2 + y^2 = " + (double)Math.round(firstRandomizer11*100)/100;
    static String incorrect2Answer11 = "The equation is: x^2 + y^2 = " + (double)Math.round(secondRandomizer11*100)/100;

    /////// in the question below, the user has to find the radius of a circle given it's equation
    //question12
    static double rightEquationSide12 = Q1.nextInt(20); //randomly generate the right side of the equation. the right side of a circle's equation is directly responsible for it's radius.
    static String rightAnswer12 = "The radius of the circle is: " + (double)Math.round(Math.sqrt(rightEquationSide12)*100)/100; //initialize the correct answer by square rooting
    static double firstRandomizer12 = Math.sqrt(rightEquationSide12) + Q1.nextInt(8)+1; //randomize the correct answer for the incorrect answers
    static double secondRandomizer12 = Math.sqrt(rightEquationSide12) +Q1.nextInt(8)+1;
    static String incorrect1Answer12 = "The radius of the circle is: " + (double)Math.round(firstRandomizer12*100)/100; //initialize the incorrect answers
    static String incorrect2Answer12 = "The radius of the circle is: " + (double)Math.round(secondRandomizer12*100)/100;

    // in the two questions below, the user will have to determine whether or not a point resides outside a circle given the circle's equation. Because the questions are of the same type, I will only comment the question directly below
    //question13
    static double pointX13 = Q1.nextInt(50); //randomly generate the x-value of the point. the y-value remains 0
    static double rightEquationSide13 = Q1.nextInt(25); //randomly generate the right side of the eqaution.
    static String rightAnswer13 = ""; //initialize the right and incorrect answers
    static String incorrect1Answer13;
    static String incorrect2Answer13 = "Question Not Applicable";

    static{
        if(pointX13==Math.sqrt(rightEquationSide13)){ //if the point's x-value is equal to the circle's radius, add five to the point's x-value
            pointX13+=5;
        }
        if (pointX13 < Math.sqrt(rightEquationSide13)){ //if the point's x-value is inside the circle, set the rightAnswer variable to yes. If not, set the variable to no
            rightAnswer13 = "Yes";
            incorrect1Answer13 = "No";
        }
        else{
            rightAnswer13 = "No";
            incorrect1Answer13 = "Yes";
        }
    }

    //question14
    static double pointX14 = Q1.nextInt(50);
    static double rightEquationSide14 = Q1.nextInt(25);
    static String rightAnswer14;
    static String incorrect1Answer14;
    static String incorrect2Answer14 = "Not Applicable";

    static{
        if(pointX14==Math.sqrt(rightEquationSide14)){
            pointX14+=5;
        }
        if (pointX14 < Math.sqrt(rightEquationSide14)){
            rightAnswer14 = "Yes";
            incorrect1Answer14 = "No";
        }
        else{
            rightAnswer14 = "No";
            incorrect1Answer14 = "Yes";
        }
    }

    //for the last question, the user has to state the equation of the circle given it's center point and it's right equation side
    //question15
    static double pointX15 = Q1.nextInt(50); //generate the point's x and y value.
    static double pointY15 = Q1.nextInt(25);
    static double radius15 = Q1.nextInt(18); //generate the circle's radius.
    static double rightEquationSide15 = radius15*radius15; //find the right side of the circle's equation by squaring the radius.
    static String rightAnswer15 = "(x - "+pointX15+")^2 + (y - "+pointY15+")^2 = "+ rightEquationSide15; //The right answer is equal to the following string
    static double answerXRandomizer15 = pointX15+1+Q1.nextInt(11); //randomize the x/y values of the circle's equation for the incorrect answers
    static double answerYRandomizer15 = pointY15+1+Q1.nextInt(11);
    static double answer2XRandomizer15 = pointX15+1+Q1.nextInt(11);
    static double answer2YRandomizer15 = pointY15+1+Q1.nextInt(11);
    static String incorrect1Answer15 = "(x - "+answerXRandomizer15+")^2 + (y - "+answerYRandomizer15+")^2 = "+radius15; // initialize the incorrect answers using the randomized x/y values and use the radius for the right side of the equation which is wrong.
    static String incorrect2Answer15 = "(x - "+answer2XRandomizer15+")^2 + (y - "+answer2YRandomizer15+")^2 = "+radius15;

    ////////////////////////////////////////////question stuff ends

    public static String mathQuestion[] ={ //the questions displayed in the GUI are taken from this array
            "Determine the coordinates of the mid-point of the formed line segment given the start and end point:\n("+startX+" , "+startY+") ("+endX+" , "+endY+")",
            "Determine the coordinates of the mid-point of the formed line segment given the start and end point:\n("+startX2+" , "+startY2+") ("+endX2+" , "+endY2+")",
            "Determine the coordinates of the mid-point of the formed line segment given the start and end point:\n("+startX3+" , "+startY3+") ("+endX3+" , "+endY3+")",
            "Determine the coordinates of the end-point of the formed line segment given the start and mid point:\n("+startX4+" , "+startY4+") ("+middleX4+" , "+middleY4+")",
            "Determine the coordinates of the end-point of the formed line segment given the start and mid point:\n("+startX5+" , "+startY5+") ("+middleX5+" , "+middleY5+")",
            "Determine the coordinates of the end-point of the formed line segment given the start and mid point:\n("+startX6+" , "+startY6+") ("+middleX6+" ," +middleY6+")",
            "Determine the length of the formed line segment:\n("+startX7+" , "+startY7+") ("+endX7+" , "+endY7+")",
            "Determine the length of the formed line segment:\n("+startX8+" , "+startY8+") ("+endX8+" , "+endY8+")",
            "Determine the length of the formed line segment:\n("+startX9+" , "+startY9+") ("+endX9+" , "+endY9+")",
            "Determine the equation of a circle with a radius of "+ radius10,
            "Determine the equation of a circle with a radius of "+ radius11,
            "Determine the radius of a circle with the equation:\nx^2 + y^2 = " + rightEquationSide12,
            "Is the point ("+pointX13+" , 0) inside the circle defined by the equation:\nx^2 + y^2 = " + rightEquationSide13,
            "Is the point ("+pointX14+" , 0) inside the circle defined by the equation:\nx^2 + y^2 = " + rightEquationSide14,
            "Determine the equation of the circle that is centered at ("+pointX15+" , "+pointY15+") and which equals "+rightEquationSide15+" on the right side of the equation.",


    };
    public static String selectChoices[][] = { //this array is where all the text/Strings for the multiple-choice buttons is located
            {rightAnswer, incorrect1Answer, incorrect2Answer},
            {incorrect1Answer2, rightAnswer2, incorrect2Answer2},
            {incorrect1Answer3, rightAnswer3, incorrect2Answer3},
            {incorrect1Answer4, incorrect2Answer4, rightAnswer4},
            {rightAnswer5, incorrect2Answer5, incorrect1Answer5},
            {rightAnswer6, incorrect1Answer6, incorrect2Answer6},
            {incorrect1Answer7, rightAnswer7, incorrect2Answer7},
            {incorrect2Answer8, rightAnswer8, incorrect1Answer8},
            {incorrect2Answer9, incorrect1Answer9, rightAnswer9},
            {incorrect1Answer10, incorrect2Answer10, rightAnswer10},
            {incorrect1Answer11, incorrect2Answer11, rightAnswer11},
            {rightAnswer12, incorrect1Answer12, incorrect2Answer12},
            {rightAnswer13, incorrect2Answer13, incorrect1Answer13},
            {incorrect2Answer14, rightAnswer14, incorrect1Answer14},
            {incorrect2Answer15, rightAnswer15, incorrect1Answer15}
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
        setContentView(R.layout.activity_test_questioning_page2); // set the .xml file in review to the corresponding test questioning page xml file

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
            Intent intent = new Intent(this, testRecap2.class);
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