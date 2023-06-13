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

public class testQuestioningPage4 extends AppCompatActivity implements View.OnClickListener{

    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = mathQuestion.length;

    public static int score = 0;
    int ongoingQuestion = 0;
    String choosenAnswer = "";

    ////////////////////////////////all questions stuff below

    static Random Q1 = new Random();

    //in the question below, the user has to state the y-intercepts of a quadratic
    ///question1
    static double coefficientX = Q1.nextInt(15); // generate the coefficient of the quadratic
    static double middleX = Q1.nextInt(25); //generate the middle x term
    static double yIntercept = Q1.nextInt(25); // generate the y-intercept
    static String rightAnswer = String.valueOf(yIntercept); //the right answer is the y intercept
    static String incorrect1Answer = String.valueOf(yIntercept+ Q1.nextInt(5)+1); // the incorrect answers are randomized based on the value of the y-intercept, as done in previous tests
    static String incorrect2Answer = String.valueOf(yIntercept+Q1.nextInt(5)+1);

    //in the question below, the user has to state the x-intercepts of a quadratic
    //question2
    static double coefficientX2 = Q1.nextInt(3)+1; //generate the coefficient, middle and y-intercept terms of the quadratic
    static double middleX2 = Q1.nextInt(30)+13;
    static double yIntercept2 = Q1.nextInt(10)+1;
    static double x2Value = ((-1* middleX2 +Math.sqrt(middleX2 * middleX2 -4* coefficientX2 * yIntercept2))/(2* coefficientX2)); //find the first and second y intercepts
    static double nextX2Value = ((-1* middleX2 -Math.sqrt(middleX2 * middleX2 -4* coefficientX2 * yIntercept2))/(2* coefficientX2));
    static double randomized1middleX2 = x2Value +1 + Q1.nextInt(3); //randomize these variables for the same purpose as previously
    static double randomized2middleX2 = x2Value +1 + Q1.nextInt(3);
    static double randomized1YIntercept2 = nextX2Value +1 + Q1.nextInt(8);
    static double randomized2YIntercept2 = nextX2Value +1 + Q1.nextInt(8);
    static String rightAnswer2 = "The x-intercepts are "+ (double)Math.round(x2Value*100)/100 +" and " + (double)Math.round(nextX2Value*100)/100; //state the right and incorrect answers
    static String incorrect1Answer2 = "The x-intercepts are "+(double)Math.round(randomized1middleX2*100)/100+" and " + (double)Math.round(randomized1YIntercept2*100)/100;
    static String incorrect2Answer2 = "The x-intercepts are "+(double)Math.round(randomized2middleX2*100)/100+" and " + (double)Math.round(randomized2YIntercept2*100)/100;

    //in the two questions below, the user has to state the domain/range of a quadratic, cubic or quartic. because the questions are of the same type, i will only comment the question below
    //question3
    static double coefficientX3 = Q1.nextInt(15)+1; //generate the coefficient
    static double firstMiddleX3 = Q1.nextInt(15)+1; //generate the middle x terms. The first, middle and last terminology is used because a quartic will use all these three terms, whereas a cubic will only use two of these terms and so on
    static double middleMiddleX3 = Q1.nextInt(15)+1;
    static double lastMiddleX3 = Q1.nextInt(15)+1;
    static double yIntercept3 = Q1.nextInt(15)+1; //generate the y-intercept
    static double exponent3 = Q1.nextInt(3)+2; //generate the exponent of the leading coefficient
    static String rightAnswer3; //state the right, incorrect and questionDisplayed variables.
    static String incorrect1Answer3;
    static String incorrect2Answer3;
    static String questionDisplayed3;

    static{
        if (exponent3 == 4){ //if the exponent equals 4, ask the user to state the range of a quartic obviously
            rightAnswer3 = "{y > 0}"; //set the right/incorrect answer variables to certain values
            incorrect1Answer3 = "{y < 0}";
            incorrect2Answer3 = "DNE";
            questionDisplayed3 = "What is the range of the following equation:\n"+coefficientX3+"x^4 + "+firstMiddleX3+"x^3 +"+middleMiddleX3+"x^2 + "+lastMiddleX3+"x +"+yIntercept3;

        }
        else if(exponent3 == 3){ //if the exponent equals 3, ask the user to state the range of a cubic obviously
            rightAnswer3 = "{YEIR}";
            incorrect1Answer3 = "{y > 0}";
            incorrect2Answer3 = "{x > 0}";
            questionDisplayed3 = "What is the range of the following equation:\n"+coefficientX3+"x^3 + "+firstMiddleX3+"x^2 +"+middleMiddleX3+"x + "+lastMiddleX3;
        }
        else if (exponent3 == 2){ //if the exponent equals 2, ask the user to state the range of a quadratic obviously
            rightAnswer3 = "{y > 0}";
            incorrect1Answer3 = "{y = 0}";
            incorrect2Answer3 = "{x < 0}";
            questionDisplayed3 = "What is the range of the following equation:\n"+coefficientX3+"x^2 + "+firstMiddleX3+"x +"+middleMiddleX3;
        }
    }

    //question4
    static double coefficientX4 = Q1.nextInt(15)+1;
    static double firstMiddleX4 = Q1.nextInt(15)+1;
    static double middleMiddleX4 = Q1.nextInt(15)+1;
    static double lastMiddleX4 = Q1.nextInt(15)+1;
    static double yIntercept4 = Q1.nextInt(15)+1;
    static double exponent4 = Q1.nextInt(3)+2;
    static String rightAnswer4;
    static String incorrect1Answer4;
    static String incorrect2Answer4;
    static String questionDisplayed4;

    static{
        if (exponent4 == 4){
            rightAnswer4 = "Up, XEIR";
            incorrect1Answer4 = "Right, YEIR";
            incorrect2Answer4 = "Down, XEIR";
            questionDisplayed4 = "What is the domain and direction of opening of the following equation?:\n"+coefficientX4+"x^4 + "+firstMiddleX4+"x^3 +"+middleMiddleX4+"x^2 + "+lastMiddleX4+"x +"+yIntercept4;

        }
        else if(exponent4 == 3){
            rightAnswer4 = "Not applicable, XEIR";
            incorrect1Answer4 = "Sideways, XEIR";
            incorrect2Answer4 = "Down, x > 0";
            questionDisplayed4 = "What is the domain and direction of opening of the following equation?:\n"+coefficientX4+"x^3 + "+firstMiddleX4+"x^2 +"+middleMiddleX4+"x + "+lastMiddleX4;
        }
        else if (exponent4 == 2){
            rightAnswer4 = "Up, XEIR";
            incorrect1Answer4 = "Forwards, X < 0";
            incorrect2Answer4 = "Sideways, X = 0";
            questionDisplayed4 = "What is the domain and direction of opening of the following equation?:\n"+coefficientX4+"x^2 + "+firstMiddleX4+"x +"+middleMiddleX4;
        }
    }

    //for the questions 5-7, the user will have to state the equation of a quadratic that has been changed/compressed/translated. I will only comment the question directly below
    //question5
    static double coefficientX5 = Q1.nextInt(10)+1; //generate the coefficient
    static double verticalX5 = Q1.nextInt(5)+1; //generate the horizontal change factor
    static double horizontalX5 = Q1.nextInt(5)+1; //generate the vertical change factor
    static double horizontalCompression5 = (double)Math.round(1/ horizontalX5*100)/100; //generate the reciprocal of the horizontal/vertical change factors in the event that a compression is assigned
    static double verticalCompression5 = (double)Math.round(1/ verticalX5*100)/100;
    static double horizontalTranslationX5 = Q1.nextInt(5)+1; //generate a translation factor horizontally and vertically
    static double verticalTranslationX5 = Q1.nextInt(5)+1;
    static double totalVerticalChange5 = 0; //these two variables will hold the value of the end horizontal/vertical compression/stretch that will be applied
    static double totalHorizontalChange5 = 0;
    static double determineHorizontalChange = Q1.nextInt(2); //these two variables determine whether a stretch or compression is applied - more on that below on line 143
    static double determineVerticalChange = Q1.nextInt(2);
    static String displayedQuestion5;

    static {
        System.out.println(determineHorizontalChange);
        if (determineHorizontalChange == 0) { //if this variable equals 0, tell the user that a horizontal stretch has been applied
            totalHorizontalChange5 += horizontalCompression5;
            displayedQuestion5 = "The equation of "+coefficientX5+"x^2 is horizontally multiplied by a factor of " + horizontalX5 + ", horizontally translated by a factor of " + horizontalTranslationX5 + ", vertically translated by a factor of " + verticalTranslationX5 + " and vertically multiplied by a factor of ";
        } else if (determineHorizontalChange == 1) { // if this variable equals 1, tell the user that a horizontal compression has been applied
            totalHorizontalChange5 += (horizontalX5);
            displayedQuestion5 = "The equation of "+coefficientX5+"x^2 is horizontally multiplied by a factor of " + horizontalCompression5 + ", horizontally translated by a factor of " + horizontalTranslationX5 + ", vertically translated by a factor of " + verticalTranslationX5 + " and vertically multiplied by a factor of ";
        }
    }
    static{
        if (determineVerticalChange==0) { //if this variable equals 0, tell the user that a vertical stretch has been applied
            totalVerticalChange5 += (verticalX5);
            displayedQuestion5 += verticalX5 + ". What is the final equation?";
        }

        else if(determineVerticalChange==1){ //if this variable equals 0, tell the user that a vertical compression has been applied
            totalVerticalChange5+=verticalCompression5;
            displayedQuestion5+=verticalCompression5+". What is the final equation?";
        }
    }
    static double randomTotalVerticalChange5 = totalVerticalChange5 + Q1.nextInt(5)+1; //randomize the coefficients/terms in the newly changed quadratic for the same purpose as done previously - its all for the incorrect answers
    static double randomTotalHorizontalChange5 = totalHorizontalChange5 + Q1.nextInt(5)+1;
    static double randomHorizontalTranslation5 = horizontalTranslationX5 + Q1.nextInt(5)+1;
    static double randomVerticalTranslation5 = verticalTranslationX5 + Q1.nextInt(5)+1;
    static double random2TotalVerticalChange5 = totalVerticalChange5 + Q1.nextInt(5)+1;
    static double random2TotalHorizontalChange5 = totalHorizontalChange5 + Q1.nextInt(5)+1;
    static double random2HorizontalTranslation5 = horizontalTranslationX5 + Q1.nextInt(5)+1;
    static double random2VerticalTranslation5 = verticalTranslationX5 + Q1.nextInt(5)+1;
    static String rightAnswer5 = (double)Math.round(coefficientX5*totalVerticalChange5*100)/100+"("+(double)Math.round(totalHorizontalChange5*100)/100+"(x-"+(double)Math.round(horizontalTranslationX5*100)/100+"))^2 + "+(double)Math.round(verticalTranslationX5*100)/100; //state the right and incorrect answer variables
    static String incorrect1Answer5 = (double)Math.round(coefficientX5*randomTotalVerticalChange5*100)/100+"("+(double)Math.round(randomTotalHorizontalChange5*100)/100+"(x-"+(double)Math.round(randomHorizontalTranslation5*100)/100+"))^2 + "+(double)Math.round(randomVerticalTranslation5*100)/100;
    static String incorrect2Answer5 = (double)Math.round(coefficientX5*random2TotalVerticalChange5*100)/100+"("+(double)Math.round(random2TotalHorizontalChange5*100)/100+"(x-"+(double)Math.round(random2HorizontalTranslation5*100)/100+"))^2 + "+(double)Math.round(random2VerticalTranslation5*100)/100;

    //question6
    static double coefficientX6 = Q1.nextInt(10)+1;
    static double verticalX6 = Q1.nextInt(5)+1;
    static double horizontalX6 = Q1.nextInt(5)+1;
    static double horizontalCompression6 = (double)Math.round(1/ horizontalX6*100)/100;
    static double verticalCompression6 = (double)Math.round(1/ verticalX6*100)/100;
    static double horizontalTranslationX6 = Q1.nextInt(5)+1;
    static double verticalTranslationX6 = Q1.nextInt(5)+1;
    static double totalVerticalChange6 = 0;
    static double totalHorizontalChange6 = 0;
    static double determineHorizontalChange6 = Q1.nextInt(2);
    static double determineVerticalChange6 = Q1.nextInt(2);
    static String displayedQuestion6;

    static {
        System.out.println(determineHorizontalChange6);
        if (determineHorizontalChange6 == 0) { //do a horizontal stretch
            totalHorizontalChange6 += horizontalCompression6;
            displayedQuestion6 = "The equation of "+coefficientX6+"x^2 is horizontally multiplied by a factor of " + horizontalX6 + ", horizontally translated by a factor of " + horizontalTranslationX6 + ", vertically translated by a factor of " + verticalTranslationX6 + " and vertically multiplied by a factor of ";
        } else if (determineHorizontalChange6 == 1) { // do a horizontal compression
            totalHorizontalChange6 += (horizontalX6);
            displayedQuestion6 = "The equation of "+coefficientX6+"x^2 is horizontally multiplied by a factor of " + horizontalCompression6 + ", horizontally translated by a factor of " + horizontalTranslationX6 + ", vertically translated by a factor of " + verticalTranslationX6 + " and vertically multiplied by a factor of ";
        }

    }
    static{
        if (determineVerticalChange6==0) { //do a vertical stretch
            totalVerticalChange6 += (verticalX6);
            displayedQuestion6 += verticalX6 + ". What is the final equation?";
        }

        else if(determineVerticalChange6==1){ // do a vertical compression
            totalVerticalChange6+=verticalCompression6;
            displayedQuestion6+=verticalCompression6+". What is the final equation?";
        }
    }
    static double randomTotalVerticalChange6 = totalVerticalChange6 + Q1.nextInt(5)+1;
    static double randomTotalHorizontalChange6 = totalHorizontalChange6 + Q1.nextInt(5)+1;
    static double randomHorizontalTranslation6 = horizontalTranslationX6 + Q1.nextInt(5)+1;
    static double randomVerticalTranslation6 = verticalTranslationX6 + Q1.nextInt(5)+1;
    static double random2TotalVerticalChange6 = totalVerticalChange6 + Q1.nextInt(5)+1;
    static double random2TotalHorizontalChange6 = totalHorizontalChange6 + Q1.nextInt(5)+1;
    static double random2HorizontalTranslation6 = horizontalTranslationX6 + Q1.nextInt(5)+1;
    static double random2VerticalTranslation6 = verticalTranslationX6 + Q1.nextInt(5)+1;
    static String rightAnswer6 = (double)Math.round(coefficientX6*totalVerticalChange6*100)/100+"("+(double)Math.round(totalHorizontalChange6*100)/100+"(x-"+(double)Math.round(horizontalTranslationX6*100)/100+"))^2 + "+(double)Math.round(verticalTranslationX6*100)/100;
    static String incorrect1Answer6 = (double)Math.round(coefficientX6*randomTotalVerticalChange6*100)/100+"("+(double)Math.round(randomTotalHorizontalChange6*100)/100+"(x-"+(double)Math.round(randomHorizontalTranslation6*100)/100+"))^2 + "+(double)Math.round(randomVerticalTranslation6*100)/100;
    static String incorrect2Answer6 = (double)Math.round(coefficientX6*random2TotalVerticalChange6*100)/100+"("+(double)Math.round(random2TotalHorizontalChange6*100)/100+"(x-"+(double)Math.round(random2HorizontalTranslation6*100)/100+"))^2 + "+(double)Math.round(random2VerticalTranslation6*100)/100;

    //question7
    static double coefficientX7 = Q1.nextInt(10)+1;
    static double verticalX7 = Q1.nextInt(5)+1;
    static double horizontalX7 = Q1.nextInt(5)+1;
    static double horizontalCompression7 = (double)Math.round(1/ horizontalX7*100)/100;
    static double verticalCompression7 = (double)Math.round(1/ verticalX7*100)/100;
    static double horizontalTranslationX7 = Q1.nextInt(5)+1;
    static double verticalTranslationX7 = Q1.nextInt(5)+1;
    static double totalVerticalChange7 = 0;
    static double totalHorizontalChange7 = 0;
    static double determineHorizontalChange7 = Q1.nextInt(2);
    static double determineVerticalChange7 = Q1.nextInt(2);
    static String displayedQuestion7;

    static {
        System.out.println(determineHorizontalChange7);
        if (determineHorizontalChange7 == 0) { //do a horizontal stretch
            totalHorizontalChange7 += horizontalCompression7;
            displayedQuestion7 = "The equation of "+coefficientX7+"x^2 is horizontally multiplied by a factor of " + horizontalX7 + ", horizontally translated by a factor of " + horizontalTranslationX7 + ", vertically translated by a factor of " + verticalTranslationX7 + " and vertically multiplied by a factor of ";
        } else if (determineHorizontalChange7 == 1) { // do a horizontal compression
            totalHorizontalChange7 += (horizontalX7);
            displayedQuestion7 = "The equation of "+coefficientX7+"x^2 is horizontally multiplied by a factor of " + horizontalCompression7 + ", horizontally translated by a factor of " + horizontalTranslationX7 + ", vertically translated by a factor of " + verticalTranslationX7 + " and vertically multiplied by a factor of ";
        }

    }
    static{
        if (determineVerticalChange7==0) { //do a vertical stretch
            totalVerticalChange7 += (verticalX7);
            displayedQuestion7 += verticalX7 + ". What is the final equation?";
        }

        else if(determineVerticalChange7==1){ // do a vertical compression
            totalVerticalChange7+=verticalCompression7;
            displayedQuestion7+=verticalCompression7+". What is the final equation?";
        }
    }
    static double randomTotalVerticalChange7 = totalVerticalChange7 + Q1.nextInt(5)+1;
    static double randomTotalHorizontalChange7 = totalHorizontalChange7 + Q1.nextInt(5)+1;
    static double randomHorizontalTranslation7 = horizontalTranslationX7 + Q1.nextInt(5)+1;
    static double randomVerticalTranslation7 = verticalTranslationX7 + Q1.nextInt(5)+1;
    static double random2TotalVerticalChange7 = totalVerticalChange7 + Q1.nextInt(5)+1;
    static double random2TotalHorizontalChange7 = totalHorizontalChange7 + Q1.nextInt(5)+1;
    static double random2HorizontalTranslation7 = horizontalTranslationX7 + Q1.nextInt(5)+1;
    static double random2VerticalTranslation7 = verticalTranslationX7 + Q1.nextInt(5)+1;
    static String rightAnswer7 = (double)Math.round(coefficientX7*totalVerticalChange7*100)/100+"("+(double)Math.round(totalHorizontalChange7*100)/100+"(x-"+(double)Math.round(horizontalTranslationX7*100)/100+"))^2 + "+(double)Math.round(verticalTranslationX7*100)/100;
    static String incorrect1Answer7 = (double)Math.round(coefficientX7*randomTotalVerticalChange7*100)/100+"("+(double)Math.round(randomTotalHorizontalChange7*100)/100+"(x-"+(double)Math.round(randomHorizontalTranslation7*100)/100+"))^2 + "+(double)Math.round(randomVerticalTranslation7*100)/100;
    static String incorrect2Answer7 = (double)Math.round(coefficientX7*random2TotalVerticalChange7*100)/100+"("+(double)Math.round(random2TotalHorizontalChange7*100)/100+"(x-"+(double)Math.round(random2HorizontalTranslation7*100)/100+"))^2 + "+(double)Math.round(random2VerticalTranslation7*100)/100;

    //in the two questions below, the user will have to state one transformation that has been applied to x^2. I will only comment the question below
    //question8
    static double coefficientX8 = Q1.nextInt(10)+1; //generate the coefficient of the quadratic
    static double verticalX8 = Q1.nextInt(5)+1; //generate the horizontal/vertical stretch factors
    static double horizontalX8 = Q1.nextInt(5)+1;
    static double horizontalCompression8 = (double)Math.round(1/ horizontalX8*100)/100; //generate the reciprocal of the horizontal/vertical stretch factors
    static double verticalCompression8 = (double)Math.round(1/ verticalX8*100)/100;
    static double horizontalTranslationX8 = Q1.nextInt(5)+1; //generate the horizontal/vertical translation factors
    static double verticalTranslationX8 = Q1.nextInt(5)+1;
    static double totalVerticalChange8 = 0; //these two variables will hold the total vertical/horizontal stretch/compression that has been applied to x^2
    static double totalHorizontalChange8 = 0;
    static double determineHorizontalChange8 = Q1.nextInt(2); //these variables will determine whether or not a vertical/horizontal stretch or compression is applied
    static double determineVerticalChange8 = Q1.nextInt(2);

    static {
        System.out.println(determineHorizontalChange8);
        if (determineHorizontalChange8 == 0) { //do a horizontal stretch if this variable equals 0
            totalHorizontalChange8 += horizontalX8;
        } else if (determineHorizontalChange8 == 1) { // do a horizontal compression if this variable equals 1
            totalHorizontalChange8 += (horizontalCompression8);
        }

    }
    static{
        if (determineVerticalChange8==0) { //do a vertical stretch if this variable equals 0
            totalVerticalChange8 += (verticalX8);
        }

        else if(determineVerticalChange8==1){ // do a vertical compression if this variable equals 1
            totalVerticalChange8+=verticalCompression8;
        }
    }
    static double randomTotalHorizontalChange8 = totalHorizontalChange8 + Q1.nextInt(5)+1; //randomize the total horizontal change value for the incorrect answers because the user will have to determine the horizontal change applied
    static String equation8 = (double)Math.round(coefficientX8*totalVerticalChange8*100)/100+"("+(double)Math.round((1/totalHorizontalChange8)*100)/100+"(x-"+(double)Math.round(horizontalTranslationX8*100)/100+"))^2 + "+(double)Math.round(verticalTranslationX8*100)/100; //generate the right and incorrect answers here
    static String displayedQuestion8 = "Which of the following transformations were done to the x^2 in the following equation?:\n" + equation8;
    static String rightAnswer8 = "A horizontal multiplication of " + (double)Math.round(totalHorizontalChange8*100)/100;
    static String incorrect1Answer8 = "A horizontal multiplication of " + (double)Math.round(randomTotalHorizontalChange8*100)/100;
    static String incorrect2Answer8 = "A horizontal multiplication of " + (double)Math.round(verticalTranslationX8*100)/100;

    //question9
    static double coefficientX9 = Q1.nextInt(10)+1;
    static double verticalX9 = Q1.nextInt(5)+1;
    static double horizontalX9 = Q1.nextInt(5)+1;
    static double horizontalCompression9 = (double)Math.round(1/ horizontalX9*100)/100;
    static double verticalCompression9 = (double)Math.round(1/ verticalX9*100)/100;
    static double horizontalTranslationX9 = Q1.nextInt(5)+1;
    static double verticalTranslationX9 = Q1.nextInt(5)+1;
    static double totalVerticalChange9 = 0;
    static double totalHorizontalChange9 = 0;
    static double determineHorizontalChange9 = Q1.nextInt(2);
    static double determineVerticalChange9 = Q1.nextInt(2);

    static {
        System.out.println(determineHorizontalChange9);
        if (determineHorizontalChange9 == 0) { //do a horizontal stretch
            totalHorizontalChange9 += horizontalX9;
        } else if (determineHorizontalChange9 == 1) { // do a horizontal compression
            totalHorizontalChange9 += (horizontalCompression9);
        }

    }
    static{
        if (determineVerticalChange9==0) { //do a vertical stretch
            totalVerticalChange9 += (verticalX9);
        }

        else if(determineVerticalChange9==1){ // do a vertical compression
            totalVerticalChange9+=verticalCompression9;
        }
    }
    static double randomTotalHorizontalChange9 = totalHorizontalChange9 + Q1.nextInt(5)+1;
    static String equation9 = (double)Math.round(coefficientX9*totalVerticalChange9*100)/100+"("+(double)Math.round(totalHorizontalChange9*100)/100+"(x-"+(double)Math.round(horizontalTranslationX9*100)/100+"))^2 + "+(double)Math.round(verticalTranslationX9*100)/100;
    static String displayedQuestion9 = "Which of the following transformations were done to the x^2 in the following equation?:\n" + equation9;
    static String rightAnswer9 = "A vertical multiplication of " + (double)Math.round(totalVerticalChange9*coefficientX9*100)/100;
    static String incorrect1Answer9 = "A vertical multiplication of " + (double)Math.round(randomTotalHorizontalChange9*100)/100;
    static String incorrect2Answer9 = "A vertical multiplication of " + (double)Math.round(verticalTranslationX9*100)/100;

    //for the questions 10-15, the user will have to answer a word problem regarding finding the vertex of a quadratic. I will only comment the question below
    //question10
    static double coefficientX10 = Q1.nextInt(10)*-1 - 1; //the word problem has a basketball flying up with it's position above the ground being modeled by a quadratic. Here the coefficient, middle-x and y-intercept terms are generated.
    static double middleX10 = Q1.nextInt(10)* + 3;
    static double yInterceptX10 = Q1.nextInt(10);
    static double xVertex10 = ((-1*middleX10)/(2*coefficientX10)); //find the vertex using the formula -b/2a
    static double yVertex10 = coefficientX10*xVertex10*xVertex10+middleX10*xVertex10+yInterceptX10; //find the height value using this x-vertex value
    static double randomized1XVertex10 = xVertex10 + 1 + Q1.nextInt(10); //randomize the variables once again for the incorrect answers
    static double randomized1YVertex10 = yVertex10 - 1 + -1*Q1.nextInt(10);
    static double randomized2XVertex10 = xVertex10 + 1 + Q1.nextInt(10);
    static double randomized2YVertex10 = yVertex10 - 1 + -1*Q1.nextInt(10);
    static String rightAnswer10 = "The vertex point is ("+(double)Math.round(xVertex10*100)/100+", "+(double)Math.round(yVertex10*100)/100+")"; //generate right and incorrect answers
    static String incorrect1Answer10 = "The vertex point is ("+(double)Math.round(randomized1XVertex10*100)/100+", "+(double)Math.round(randomized1YVertex10*100)/100+")";
    static String incorrect2Answer10 = "The vertex point is ("+(double)Math.round(randomized2XVertex10*100)/100+", "+(double)Math.round(randomized2YVertex10*100)/100+")";
    static String displayedQuestion10 = "A basketball is launched into the air using a hydraulic machine. The ball's trajectory above the ground is described by this equation:\n" + coefficientX10+"x^2 + "+middleX10+"x + "+yInterceptX10+"\nDetermine the point at which the ball is at it's maximum height.";

    //question11
    static double coefficientX11 = Q1.nextInt(10)*-1 - 1;
    static double middleX11 = Q1.nextInt(10)* + 3;
    static double yInterceptX11 = Q1.nextInt(10);
    static double xVertex11 = ((-1*middleX11)/(2*coefficientX11));
    static double yVertex11 = coefficientX11*xVertex11*xVertex11+middleX11*xVertex11+yInterceptX11;
    static double randomized1XVertex11 = xVertex11 + 1 + Q1.nextInt(10);
    static double randomized1YVertex11 = yVertex11 - 1 + -1*Q1.nextInt(10);
    static double randomized2XVertex11 = xVertex11 + 1 + Q1.nextInt(10);
    static double randomized2YVertex11 = yVertex11 - 1 + -1*Q1.nextInt(10);
    static String rightAnswer11 = "The vertex point is ("+(double)Math.round(xVertex11*100)/100+", "+(double)Math.round(yVertex11*100)/100+")";
    static String incorrect1Answer11 = "The vertex point is ("+(double)Math.round(randomized1XVertex11*100)/100+", "+(double)Math.round(randomized1YVertex11*100)/100+")";
    static String incorrect2Answer11 = "The vertex point is ("+(double)Math.round(randomized2XVertex11*100)/100+", "+(double)Math.round(randomized2YVertex11*100)/100+")";
    static String displayedQuestion11 = "A car is launched into space using a rocket-ship. The car's trajectory above the ground is described by this equation:\n" + coefficientX11+"x^2 + "+middleX11+"x + "+yInterceptX11+"\nDetermine the point at which the car is at it's maximum height.";

    //question12
    static double coefficientX12 = Q1.nextInt(10)*-1 - 1;
    static double middleX12 = Q1.nextInt(10)* + 3;
    static double yInterceptX12 = Q1.nextInt(10);
    static double xVertex12 = ((-1*middleX12)/(2*coefficientX12));
    static double yVertex12 = coefficientX12*xVertex12*xVertex12+middleX12*xVertex12+yInterceptX12;
    static double randomized1XVertex12 = xVertex12 + 1 + Q1.nextInt(10);
    static double randomized1YVertex12 = yVertex12 - 1 + -1*Q1.nextInt(10);
    static double randomized2XVertex12 = xVertex12 + 1 + Q1.nextInt(10);
    static double randomized2YVertex12 = yVertex12 - 1 + -1*Q1.nextInt(10);
    static String rightAnswer12 = "The vertex point is ("+(double)Math.round(xVertex12*100)/100+", "+(double)Math.round(yVertex12*100)/100+")";
    static String incorrect1Answer12 = "The vertex point is ("+(double)Math.round(randomized1XVertex12*100)/100+", "+(double)Math.round(randomized1YVertex12*100)/100+")";
    static String incorrect2Answer12 = "The vertex point is ("+(double)Math.round(randomized2XVertex12*100)/100+", "+(double)Math.round(randomized2YVertex12*100)/100+")";
    static String displayedQuestion12 = "A space-probe is launched into space using a rocket-ship but comes crashing down soon after. The probe's trajectory above the ground is described by this equation:\n" + coefficientX12+"x^2 + "+middleX12+"x + "+yInterceptX12+"\nDetermine the point at which the probe is at it's maximum height.";

    //question13
    static double coefficientX13 = Q1.nextInt(10)*-1 - 1;
    static double middleX13 = Q1.nextInt(10)* + 3;
    static double yInterceptX13 = Q1.nextInt(10);
    static double xVertex13 = ((-1*middleX13)/(2*coefficientX13));
    static double yVertex13 = coefficientX13*xVertex13*xVertex13+middleX13*xVertex13+yInterceptX13;
    static double randomized1XVertex13 = xVertex13 + 1 + Q1.nextInt(10);
    static double randomized1YVertex13 = yVertex13 - 1 + -1*Q1.nextInt(10);
    static double randomized2XVertex13 = xVertex13 + 1 + Q1.nextInt(10);
    static double randomized2YVertex13 = yVertex13 - 1 + -1*Q1.nextInt(10);
    static String rightAnswer13 = "The vertex point is ("+(double)Math.round(xVertex13*100)/100+", "+(double)Math.round(yVertex13*100)/100+")";
    static String incorrect1Answer13 = "The vertex point is ("+(double)Math.round(randomized1XVertex13*100)/100+", "+(double)Math.round(randomized1YVertex13*100)/100+")";
    static String incorrect2Answer13 = "The vertex point is ("+(double)Math.round(randomized2XVertex13*100)/100+", "+(double)Math.round(randomized2YVertex13*100)/100+")";
    static String displayedQuestion13 = "A soccer ball is launched into the air. The ball's trajectory above the ground is described by this equation:\n" + coefficientX13+"x^2 + "+middleX13+"x + "+yInterceptX13+"\nDetermine the point at which the ball is at it's maximum height.";

    //question14
    static double coefficientX14 = Q1.nextInt(10)*-1 - 1;
    static double middleX14 = Q1.nextInt(10)* + 3;
    static double yInterceptX14 = Q1.nextInt(10);
    static double xVertex14 = ((-1*middleX14)/(2*coefficientX14));
    static double yVertex14 = coefficientX14*xVertex14*xVertex14+middleX14*xVertex14+yInterceptX14;
    static double randomized1XVertex14 = xVertex14 + 1 + Q1.nextInt(10);
    static double randomized1YVertex14 = yVertex14 - 1 + -1*Q1.nextInt(10);
    static double randomized2XVertex14 = xVertex14 + 1 + Q1.nextInt(10);
    static double randomized2YVertex14 = yVertex14 - 1 + -1*Q1.nextInt(10);
    static String rightAnswer14 = "The vertex point is ("+(double)Math.round(xVertex14*100)/100+", "+(double)Math.round(yVertex14*100)/100+")";
    static String incorrect1Answer14 = "The vertex point is ("+(double)Math.round(randomized1XVertex14*100)/100+", "+(double)Math.round(randomized1YVertex14*100)/100+")";
    static String incorrect2Answer14 = "The vertex point is ("+(double)Math.round(randomized2XVertex14*100)/100+", "+(double)Math.round(randomized2YVertex14*100)/100+")";
    static String displayedQuestion14 = "A truck is launched into space using a cannon. The truck's trajectory the ground is described by this equation:\n" + coefficientX14+"x^2 + "+middleX14+"x + "+yInterceptX14+"\nDetermine the point at which the truck is at it's maximum height.";

    //question15
    static double coefficientX15 = Q1.nextInt(10)*-1 - 1;
    static double middleX15 = Q1.nextInt(10)* + 3;
    static double yInterceptX15 = Q1.nextInt(10);
    static double xVertex15 = ((-1*middleX15)/(2*coefficientX15));
    static double yVertex15 = coefficientX15*xVertex15*xVertex15+middleX15*xVertex15+yInterceptX15;
    static double randomized1XVertex15 = xVertex15 + 1 + Q1.nextInt(10);
    static double randomized1YVertex15 = yVertex15 - 1 + -1*Q1.nextInt(10);
    static double randomized2XVertex15 = xVertex15 + 1 + Q1.nextInt(10);
    static double randomized2YVertex15 = yVertex15 - 1 + -1*Q1.nextInt(10);
    static String rightAnswer15 = "The vertex point is ("+(double)Math.round(xVertex15*100)/100+", "+(double)Math.round(yVertex15*100)/100+")";
    static String incorrect1Answer15 = "The vertex point is ("+(double)Math.round(randomized1XVertex15*100)/100+", "+(double)Math.round(randomized1YVertex15*100)/100+")";
    static String incorrect2Answer15 = "The vertex point is ("+(double)Math.round(randomized2XVertex15*100)/100+", "+(double)Math.round(randomized2YVertex15*100)/100+")";
    static String displayedQuestion15 = "A volleyball is launched into the air. The ball's trajectory above the ground is described by this equation:\n" + coefficientX15+"x^2 + "+middleX15+"x + "+yInterceptX15+"\nDetermine the point at which the ball is at it's maximum height.";

    ////////////////////////////////////question stuff ends

    public static String mathQuestion[] ={ //the questions displayed in the GUI are taken from here
            "What are the y-intercepts on the following equation?:\n"+coefficientX+"x^2 + "+middleX+"x + " +yIntercept,
            "What are the x-intercepts on the following equation?:\n"+coefficientX2+"x^2 + "+middleX2+"x + "+ yIntercept2,
            questionDisplayed3,
            questionDisplayed4,
            displayedQuestion5,
            displayedQuestion6,
            displayedQuestion7,
            displayedQuestion8,
            displayedQuestion9,
            displayedQuestion10,
            displayedQuestion11,
            displayedQuestion12,
            displayedQuestion13,
            displayedQuestion14,
            displayedQuestion15



    };
    public static String selectChoices[][] = { //this array is where all the text/strings for the multiple-choice buttons is located
            {incorrect1Answer, incorrect2Answer, rightAnswer},
            {incorrect1Answer2, incorrect2Answer2, rightAnswer2},
            {incorrect2Answer3, incorrect1Answer3, rightAnswer3},
            {incorrect1Answer4, rightAnswer4, incorrect2Answer4},
            {rightAnswer5, incorrect1Answer5, incorrect2Answer5},
            {rightAnswer6, incorrect2Answer6, incorrect1Answer6},
            {incorrect2Answer7,rightAnswer7, incorrect1Answer7},
            {incorrect2Answer8, rightAnswer8, incorrect1Answer8},
            {incorrect1Answer9, rightAnswer9, incorrect2Answer9},
            {incorrect1Answer10, rightAnswer10, incorrect2Answer10},
            {incorrect1Answer11, incorrect2Answer11, rightAnswer11},
            {incorrect2Answer12, incorrect1Answer12, rightAnswer12},
            {rightAnswer13, incorrect1Answer13, incorrect2Answer13},
            {rightAnswer14, incorrect2Answer14, incorrect1Answer14},
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
        setContentView(R.layout.activity_test_questioning_page4); // set the .xml file in review to the corresponding test questioning page xml file

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
            Intent intent = new Intent(this, testRecap4.class);
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