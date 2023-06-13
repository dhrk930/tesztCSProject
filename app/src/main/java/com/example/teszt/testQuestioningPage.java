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
import java.lang.Math;
import java.util.Random;

public class testQuestioningPage extends AppCompatActivity implements View.OnClickListener{

    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = mathQuestion.length;

    public static int score = 0;
    int ongoingQuestion = 0;
    String choosenAnswer = "";

    ////////////////////////////// all the questions below

    static Random Q1 = new Random();

    //question1 (EXPLANATION IS HERE ONLY BECAUSE ALL OF THE QUESTIONS IN THIS SPECIFIC TEST ARE OF THE SAME TYPE) (In this question/every question on this test, the user will have to determine the intersection of two linear equations).
    public static double Q1X = Q1.nextInt(15); //this is the slope of the first equation
    public static double Q1Y = Q1.nextInt(15); //this is the y-intercept of the first equation
    public static double Q2X = Q1.nextInt(15); //this is the slope of the second equation
    public static double Q2Y = Q1.nextInt(15); //this is the y-intercept of the second equation. All of these variables have their values generated thanks to "Q1.nextInt(15)" which generates a random number between and including 0 and 14.

    static{
        if(Q1X == Q2X){ // if the slopes of the equations are equal, add a value of one to first equation's slope. This prevents a x/y intersection of infinity from occurring.
            Q1X++;
        }
    }
    public static double xIntercept = (Q2Y- Q1Y)/(Q1X - Q2X); //This formula from the internet calculates the x-intercept of the intersection
    public static double yIntercept = Q1X * ( (Q2Y - Q1Y) / (Q1X - Q2X) ) + Q1Y; //This formula calculates the y-intercept of the intersection
    public static double xInterceptRandomQ1X = xIntercept+Q1.nextInt(8)+1; //These random variables are generated for the incorrect multiple-choice answers. These variables use the correct x/y intercept values and add a random number to them.
    public static double yInterceptRandomQ2X = yIntercept+Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X = xIntercept+Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X = yIntercept+Q1.nextInt(8)+1;
    public static String rightAnswer1 = "The x-intercept is " + (double)Math.round(xIntercept*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept*100)/100; //The correct answer is stated. The (double)Math.round(x*100)/100 rounds the answers to two decimal places.


    //question2
    static double Q1X2 = Q1.nextInt(15);
    static double Q1Y2 = Q1.nextInt(15);
    static double Q2X2 = Q1.nextInt(15);
    static double Q2Y2 = Q1.nextInt(15);

    static{
        if(Q1X2 == Q2X2){
            Q1X2++;
        }
    }
    static double xIntercept2 = (Q2Y2 - Q1Y2)/(Q1X2 - Q2X2);
    static double yIntercept2 = Q1X2 * ( (Q2Y2 - Q1Y2) / (Q1X2 - Q2X2) ) + Q1Y2;
    public static double xInterceptRandomQ1X2 = xIntercept2 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X2 = yIntercept2 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X2 = xIntercept2 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X2 = yIntercept2 +Q1.nextInt(8)+1;
    static String rightAnswer2 = "The x-intercept is " + (double)Math.round(xIntercept2*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept2*100)/100;


    //question3
    static double Q1X3 = Q1.nextInt(15);
    static double Q1Y3 = Q1.nextInt(15);
    static double Q2X3 = Q1.nextInt(15);
    static double Q2Y3 = Q1.nextInt(15);

    static{
        if(Q1X3 == Q2X3){
            Q1X3++;
        }
    }
    static double xIntercept3 = (Q2Y3 - Q1Y3)/(Q1X3 - Q2X3);
    static double yIntercept3 = Q1X3 * ( (Q2Y3 - Q1Y3) / (Q1X3 - Q2X3) ) + Q1Y3;
    public static double xInterceptRandomQ1X3 = xIntercept3 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X3 = yIntercept3 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X3 = xIntercept3 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X3 = yIntercept3 +Q1.nextInt(8)+1;
    static String rightAnswer3 = "The x-intercept is " + (double)Math.round(xIntercept3*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept3*100)/100;

    //question4
    static double Q1X4 = Q1.nextInt(15);
    static double Q1Y4 = Q1.nextInt(15);
    static double Q2X4 = Q1.nextInt(15);
    static double Q2Y4 = Q1.nextInt(15);

    static{
        if(Q1X4 == Q2X4){
            Q1X4++;
        }
    }
    static double xIntercept4 = (Q2Y4 - Q1Y4)/(Q1X4 - Q2X4);
    static double yIntercept4 = Q1X4 * ( (Q2Y4 - Q1Y4) / (Q1X4 - Q2X4) ) + Q1Y4;
    public static double xInterceptRandomQ1X4 = xIntercept4 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X4 = yIntercept4 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X4 = xIntercept4 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X4 = yIntercept4 +Q1.nextInt(8)+1;
    static String rightAnswer4 = "The x-intercept is " + (double)Math.round(xIntercept4*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept4*100)/100;

    //question5
    static double Q1X5 = Q1.nextInt(15);
    static double Q1Y5 = Q1.nextInt(15);
    static double Q2X5 = Q1.nextInt(15);
    static double Q2Y5 = Q1.nextInt(15);

    static{
        if(Q1X5 == Q2X5){
            Q1X5++;
        }
    }
    static double xIntercept5 = (Q2Y5 - Q1Y5)/(Q1X5 - Q2X5);
    static double yIntercept5 = Q1X5 * ( (Q2Y5 - Q1Y5) / (Q1X5 - Q2X5) ) + Q1Y5;
    public static double xInterceptRandomQ1X5 = xIntercept5 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X5 = yIntercept5 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X5 = xIntercept5 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X5 = yIntercept5 +Q1.nextInt(8)+1;
    static String rightAnswer5 = "The x-intercept is " + (double)Math.round(xIntercept5*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept5*100)/100;

    //question6
    static double Q1X6 = Q1.nextInt(15);
    static double Q1Y6 = Q1.nextInt(15);
    static double Q2X6 = Q1.nextInt(15);
    static double Q2Y6 = Q1.nextInt(15);
    static{
        if(Q1X6 == Q2X6){
            Q1X6++;
        }
    }
    static double xIntercept6 = (Q2Y6 - Q1Y6)/(Q1X6 - Q2X6);
    static double yIntercept6 = Q1X6 * ( (Q2Y6 - Q1Y6) / (Q1X6 - Q2X6) ) + Q1Y6;
    public static double xInterceptRandomQ1X6 = xIntercept6 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X6 = yIntercept6 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X6 = xIntercept6 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X6 = yIntercept6 +Q1.nextInt(8)+1;
    static String rightAnswer6 = "The x-intercept is " + (double)Math.round(xIntercept6*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept6*100)/100;

    //question7
    static double Q1X7 = Q1.nextInt(15);
    static double Q1Y7 = Q1.nextInt(15);
    static double Q2X7 = Q1.nextInt(15);
    static double Q2Y7 = Q1.nextInt(15);
    static{
        if(Q1X7 == Q2X7){
            Q1X7++;
        }
    }
    static double xIntercept7 = (Q2Y7 - Q1Y7)/(Q1X7 - Q2X7);
    static double yIntercept7 = Q1X7 * ( (Q2Y7 - Q1Y7) / (Q1X7 - Q2X7) ) + Q1Y7;
    public static double xInterceptRandomQ1X7 = xIntercept7 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X7 = yIntercept7 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X7 = xIntercept7 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X7 = yIntercept7 +Q1.nextInt(8)+1;
    static String rightAnswer7 = "The x-intercept is " + (double)Math.round(xIntercept7*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept7*100)/100;

    //question8
    static double Q1X8 = Q1.nextInt(15);
    static double Q1Y8 = Q1.nextInt(15);
    static double Q2X8 = Q1.nextInt(15);
    static double Q2Y8 = Q1.nextInt(15);
    static{
        if(Q1X8 == Q2X8){
            Q1X8++;
        }
    }
    static double xIntercept8 = (Q2Y8 - Q1Y8)/(Q1X8 - Q2X8);
    static double yIntercept8 = Q1X8 * ( (Q2Y8 - Q1Y8) / (Q1X8 - Q2X8) ) + Q1Y8;
    public static double xInterceptRandomQ1X8 = xIntercept8 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X8 = yIntercept8 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X8 = xIntercept8 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X8 = yIntercept8 +Q1.nextInt(8)+1;
    static String rightAnswer8 = "The x-intercept is " + (double)Math.round(xIntercept8*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept8*100)/100;

    //question9
    static double Q1X9 = Q1.nextInt(15);
    static double Q1Y9 = Q1.nextInt(15);
    static double Q2X9 = Q1.nextInt(15);
    static double Q2Y9 = Q1.nextInt(15);
    static{
        if(Q1X9 == Q2X9){
            Q1X9++;
        }
    }
    static double xIntercept9 = (Q2Y9 - Q1Y9)/(Q1X9 - Q2X9);
    static double yIntercept9 = Q1X9 * ( (Q2Y9 - Q1Y9) / (Q1X9 - Q2X9) ) + Q1Y9;
    public static double xInterceptRandomQ1X9 = xIntercept9 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X9 = yIntercept9 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X9 = xIntercept9 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X9 = yIntercept9 +Q1.nextInt(8)+1;
    static String rightAnswer9 = "The x-intercept is " + (double)Math.round(xIntercept9*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept9*100)/100;

    //question10
    static double Q1X10 = Q1.nextInt(15);
    static double Q1Y10 = Q1.nextInt(15);
    static double Q2X10 = Q1.nextInt(15);
    static double Q2Y10 = Q1.nextInt(15);
    static{
        if(Q1X10 == Q2X10){
            Q1X10++;
        }
    }
    static double xIntercept10 = (Q2Y10 - Q1Y10)/(Q1X10 - Q2X10);
    static double yIntercept10 = Q1X10 * ( (Q2Y10 - Q1Y10) / (Q1X10 - Q2X10) ) + Q1Y10;
    public static double xInterceptRandomQ1X10 = xIntercept10 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X10 = yIntercept10 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X10 = xIntercept10 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X10 = yIntercept10 +Q1.nextInt(8)+1;
    static String rightAnswer10 = "The x-intercept is " + (double)Math.round(xIntercept10*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept10*100)/100;

    //question11
    static double Q1X11 = Q1.nextInt(15);
    static double Q1Y11 = Q1.nextInt(15);
    static double Q2X11 = Q1.nextInt(15);
    static double Q2Y11 = Q1.nextInt(15);
    static{
        if(Q1X11 == Q2X11){
            Q1X11++;
        }
    }
    static double xIntercept11 = (Q2Y11 - Q1Y11)/(Q1X11 - Q2X11);
    static double yIntercept11 = Q1X11 * ( (Q2Y11 - Q1Y11) / (Q1X11 - Q2X11) ) + Q1Y11;
    public static double xInterceptRandomQ1X11 = xIntercept11 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X11 = yIntercept11 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X11 = xIntercept11 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X11 = yIntercept11 +Q1.nextInt(8)+1;
    static String rightAnswer11 = "The x-intercept is " + (double)Math.round(xIntercept11*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept11*100)/100;

    //question12
    static double Q1X12 = Q1.nextInt(15);
    static double Q1Y12 = Q1.nextInt(15);
    static double Q2X12 = Q1.nextInt(15);
    static double Q2Y12 = Q1.nextInt(15);
    static{
        if(Q1X12 == Q2X12){
            Q1X12++;
        }
    }
    static double xIntercept12 = (Q2Y12 - Q1Y12)/(Q1X12 - Q2X12);
    static double yIntercept12 = Q1X12 * ( (Q2Y12 - Q1Y12) / (Q1X12 - Q2X12) ) + Q1Y12;
    public static double xInterceptRandomQ1X12 = xIntercept12 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X12 = yIntercept12 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X12 = xIntercept12 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X12 = yIntercept12 +Q1.nextInt(8)+1;
    static String rightAnswer12 = "The x-intercept is " + (double)Math.round(xIntercept12*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept12*100)/100;

    //question13
    static double Q1X13 = Q1.nextInt(15);
    static double Q1Y13 = Q1.nextInt(15);
    static double Q2X13 = Q1.nextInt(15);
    static double Q2Y13 = Q1.nextInt(15);
    static{
        if(Q1X13 == Q2X13){
            Q1X13++;
        }
    }
    static double xIntercept13 = (Q2Y13 - Q1Y13)/(Q1X13 - Q2X13);
    static double yIntercept13 = Q1X13 * ( (Q2Y13 - Q1Y13) / (Q1X13 - Q2X13) ) + Q1Y13;
    public static double xInterceptRandomQ1X13 = xIntercept13 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X13 = yIntercept13 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X13 = xIntercept13 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X13 = yIntercept13 +Q1.nextInt(8)+1;
    static String rightAnswer13 = "The x-intercept is " + (double)Math.round(xIntercept13*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept13*100)/100;

    //question14
    static double Q1X14 = Q1.nextInt(15);
    static double Q1Y14 = Q1.nextInt(15);
    static double Q2X14 = Q1.nextInt(15);
    static double Q2Y14 = Q1.nextInt(15);
    static{
        if(Q1X14 == Q2X14){
            Q1X14++;
        }
    }
    static double xIntercept14 = (Q2Y14 - Q1Y14)/(Q1X14 - Q2X14);
    static double yIntercept14 = Q1X14 * ( (Q2Y14 - Q1Y14) / (Q1X14 - Q2X14) ) + Q1Y14;
    public static double xInterceptRandomQ1X14 = xIntercept14 +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X14 = yIntercept14 +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X14 = xIntercept14 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X14 = yIntercept14 +Q1.nextInt(8)+1;
    static String rightAnswer14 = "The x-intercept is " + (double)Math.round(xIntercept14*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept14*100)/100;

    //question15
    static double Q1X15 = Q1.nextInt(15);
    static double Q1Y15 = Q1.nextInt(15);
    static double Q2X15 = Q1.nextInt(15);
    static double Q2Y15 = Q1.nextInt(15);
    static{
        if(Q1X15 == Q2X15){
            Q1X15++;
        }
    }
    static double xIntercept15 = (Q2Y15 - Q1Y15)/(Q1X15 - Q2X15);
    static double yIntercept15 = Q1X15 * ( (Q2Y15 - Q1Y15) / (Q1X15 - Q2X15) ) + Q1Y15;
    public static double xInterceptRandomQ1X15 = xIntercept +Q1.nextInt(8)+1;
    public static double yInterceptRandomQ2X15 = yIntercept +Q1.nextInt(8)+1;
    public static double x2InterceptRandomQ1X15 = xIntercept15 +Q1.nextInt(8)+1;
    public static double y2InterceptRandomQ2X15 = yIntercept15 +Q1.nextInt(8)+1;
    static String rightAnswer15 = "The x-intercept is " + (double)Math.round(xIntercept15*100)/100 + " and the y-intercept is " + (double)Math.round(yIntercept15*100)/100;

    ////////////////////////////////////question stuff ends

    public static String mathQuestion[] ={ //the questions displayed in the GUI are taken from this array
            "When do the following equations intersect?\ny = " + Q1X + "x + " + Q1Y + " and y = " + Q2X + "x + " + Q2Y,
            "When do the following equations intersect?\ny = " + Q1X2 + "x + " + Q1Y2 + " and y = " + Q2X2 + "x + " + Q2Y2,
            "When do the following equations intersect?\ny = " + Q1X3 + "x + " + Q1Y3 + " and y = " + Q2X3 + "x + " + Q2Y3,
            "When do the following equations intersect?\ny = " + Q1X4 + "x + " + Q1Y4 + " and y = " + Q2X4 + "x + " + Q2Y4,
            "When do the following equations intersect?\ny = " + Q1X5 + "x + " + Q1Y5 + " and y = " + Q2X5 + "x + " + Q2Y5,
            "When do the following equations intersect?\ny = " + Q1X6 + "x + " + Q1Y6 + " and y = " + Q2X6 + "x + " + Q2Y6,
            "When do the following equations intersect?\ny = " + Q1X7 + "x + " + Q1Y7 + " and y = " + Q2X7 + "x + " + Q2Y7,
            "When do the following equations intersect?\ny = " + Q1X8 + "x + " + Q1Y8 + " and y = " + Q2X8 + "x + " + Q2Y8,
            "When do the following equations intersect?\ny = " + Q1X9 + "x + " + Q1Y9 + " and y = " + Q2X9 + "x + " + Q2Y9,
            "When do the following equations intersect?\ny = " + Q1X10 + "x + " + Q1Y10 + " and y = " + Q2X10 + "x + " + Q2Y10,
            "When do the following equations intersect?\ny = " + Q1X11 + "x + " + Q1Y11 + " and y = " + Q2X11 + "x + " + Q2Y11,
            "When do the following equations intersect?\ny = " + Q1X12 + "x + " + Q1Y12 + " and y = " + Q2X12 + "x + " + Q2Y12,
            "When do the following equations intersect?\ny = " + Q1X13 + "x + " + Q1Y13 + " and y = " + Q2X13 + "x + " + Q2Y13,
            "When do the following equations intersect?\ny = " + Q1X14 + "x + " + Q1Y14 + " and y = " + Q2X14 + "x + " + Q2Y14,
            "When do the following equations intersect?\ny = " + Q1X15 + "x + " + Q1Y15 + " and y = " + Q2X15 + "x + " + Q2Y15

    };

    public static String selectChoices[][] = { //this array is where all the text for the multiple-choice buttons is located
            {rightAnswer1, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X*100)/100},
            {rightAnswer2, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X2*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X2*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X2*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X2*100)/100},
            {rightAnswer3, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X3*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X3*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X3*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X3*100)/100},
            {rightAnswer4, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X4*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X4*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X4*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X4*100)/100},
            {"The x-intercept is " + (double)Math.round(xInterceptRandomQ1X5*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X5*100)/100, rightAnswer5, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X5*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X5*100)/100},
            {rightAnswer6, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X6*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X6*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X6*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X6*100)/100},
            {rightAnswer7, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X7*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X7*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X7*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X7*100)/100},
            {"The x-intercept is " + (double)Math.round(xInterceptRandomQ1X8*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X8*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X8*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X8*100)/100, rightAnswer8},
            {rightAnswer9, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X9*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X9*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X9*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X9*100)/100},
            {rightAnswer10, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X10*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X10*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X10*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X10*100)/100},
            {"The x-intercept is " + (double)Math.round(xInterceptRandomQ1X11*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X11*100)/100, rightAnswer11, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X11*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X11*100)/100},
            {"The x-intercept is " + (double)Math.round(xInterceptRandomQ1X12*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X12*100)/100, rightAnswer12, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X12*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X12*100)/100},
            {rightAnswer13, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X13*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X13*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X13*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X13*100)/100},
            {"The x-intercept is " + (double)Math.round(xInterceptRandomQ1X14*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X14*100)/100, rightAnswer14, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X14*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X14*100)/100},
            {rightAnswer15, "The x-intercept is " + (double)Math.round(xInterceptRandomQ1X15*100)/100 + " and the y-intercept is " + (double)Math.round(yInterceptRandomQ2X15*100)/100, "The x-intercept is " + (double)Math.round(x2InterceptRandomQ1X15*100)/100 + " and the y-intercept is " + (double)Math.round(y2InterceptRandomQ2X15*100)/100},

    };

    public static String correctAnswer[] = { //this array contains the correct answer for each question
            rightAnswer1,
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
        setContentView(R.layout.activity_test_questioning_page); // set the .xml file in review to the corresponding testQuestioningPage's xml file

        score = 0; //score value will store the number of questions the user gets right
        questionsWrong = "#: "; //this string will have the question number of each incorrectly answered question stored

        displayedQuestion = findViewById(R.id.displayedQuestion); //set these variables to the gui elements that exist in the .xml file
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        proceedButton = findViewById(R.id.button2);

        ans1.setOnClickListener(this); //set an onclick listener function for all of the buttons
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
                score++; // add a score
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
             Intent intent = new Intent(this, testRecap.class);
             startActivity(intent); //open the testRecap page
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