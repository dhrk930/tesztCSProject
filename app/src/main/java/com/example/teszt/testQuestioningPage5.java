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

public class testQuestioningPage5 extends AppCompatActivity implements View.OnClickListener{

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

    //for the questions 1-10, the user will have to balance both sides of a quadratic and solve for the solutions. I will only comment the question below
    ///question1
    static double coefficientX = Q1.nextInt(3)+1; //generate the coefficient of the quadratic
    static double middleX = Q1.nextInt(30)+13; //generate the middle-x term of the quadratic
    static double displayedYIntercept = Q1.nextInt(10)+1; //generate the y-intercept of the quadratic present before any balancing occurs (By balancing I refer to moving terms from the right to the left side)
    static double leftEquationSide = Q1.nextInt(30)+1; //generate the left side of the equation - this side will have it's terms moved to the right side as stated previously in order to solve the quadratic
    static double yIntercept = displayedYIntercept+leftEquationSide*-1; //generate the y-intercept of the equation
    static double xValue = ((-1*middleX+Math.sqrt(middleX*middleX-4*coefficientX*yIntercept))/(2*coefficientX)); //generate the two solutions to the quadratic after all terms have been balanced on one side
    static double nextXValue = ((-1*middleX-Math.sqrt(middleX*middleX-4*coefficientX*yIntercept))/(2*coefficientX));
    static double randomized1middleX = xValue +1 + Q1.nextInt(3); //randomize the solutions for the incorrect answers
    static double randomized2middleX = xValue +1 + Q1.nextInt(3);
    static double randomized1YIntercept = nextXValue+1 + Q1.nextInt(8);
    static double randomized2YIntercept = nextXValue+1 + Q1.nextInt(8);
    static String questionDisplayed = "Determine the x-intercepts for the following equation:\n"+leftEquationSide+" = "+coefficientX+"x^2 + "+middleX+"x + "+displayedYIntercept; //initialize the question displayed - this question will be displayed in the GUI
    static String rightAnswer = "The x-intercepts are: "+(double)Math.round(xValue*100)/100+" and "+(double)Math.round(nextXValue*100)/100; //initialize the right and incorrect answer variables
    static String incorrect1Answer = "The x-intercepts are: "+(double)Math.round(randomized1middleX*100)/100+" and "+(double)Math.round(randomized1YIntercept*100)/100;
    static String incorrect2Answer = "The x-intercepts are: "+(double)Math.round(randomized2middleX*100)/100+" and "+(double)Math.round(randomized2YIntercept*100)/100;

    ///question2
    static double coefficientX2 = Q1.nextInt(3)+1;
    static double middleX2 = Q1.nextInt(30)+13;
    static double displayedYIntercept2 = Q1.nextInt(10)+1;
    static double leftEquationSide2 = Q1.nextInt(30)+1;
    static double yIntercept2 = displayedYIntercept2+leftEquationSide2*-1;
    static double xValue2 = ((-1*middleX2+Math.sqrt(middleX2*middleX2-4*coefficientX2*yIntercept2))/(2*coefficientX2));
    static double nextXValue2 = ((-1*middleX2-Math.sqrt(middleX2*middleX2-4*coefficientX2*yIntercept2))/(2*coefficientX2));
    static double randomized1middleX2 = xValue2 +1 + Q1.nextInt(3);
    static double randomized2middleX2 = xValue2 +1 + Q1.nextInt(3);
    static double randomized1YIntercept2 = nextXValue2+1 + Q1.nextInt(8);
    static double randomized2YIntercept2 = nextXValue2+1 + Q1.nextInt(8);
    static String questionDisplayed2 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide2+" = "+coefficientX2+"x^2 + "+middleX2+"x + "+displayedYIntercept2;
    static String rightAnswer2 = "The x-intercepts are: "+(double)Math.round(xValue2*100)/100+" and "+(double)Math.round(nextXValue2*100)/100;
    static String incorrect1Answer2 = "The x-intercepts are: "+(double)Math.round(randomized1middleX2*100)/100+" and "+(double)Math.round(randomized1YIntercept2*100)/100;
    static String incorrect2Answer2 = "The x-intercepts are: "+(double)Math.round(randomized2middleX2*100)/100+" and "+(double)Math.round(randomized2YIntercept2*100)/100;

    ///question3
    static double coefficientX3 = Q1.nextInt(3)+1;
    static double middleX3 = Q1.nextInt(30)+13;
    static double displayedYIntercept3 = Q1.nextInt(10)+1;
    static double leftEquationSide3 = Q1.nextInt(30)+1;
    static double yIntercept3 = displayedYIntercept3+leftEquationSide*-1;
    static double xValue3 = ((-1*middleX3+Math.sqrt(middleX3*middleX3-4*coefficientX3*yIntercept3))/(2*coefficientX3));
    static double nextXValue3 = ((-1*middleX3-Math.sqrt(middleX3*middleX3-4*coefficientX3*yIntercept3))/(2*coefficientX3));
    static double randomized1middleX3 = xValue3 +1 + Q1.nextInt(3);
    static double randomized2middleX3 = xValue3 +1 + Q1.nextInt(3);
    static double randomized1YIntercept3 = nextXValue3+1 + Q1.nextInt(8);
    static double randomized2YIntercept3 = nextXValue3+1 + Q1.nextInt(8);
    static String questionDisplayed3 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide3+" = "+coefficientX3+"x^2 + "+middleX3+"x + "+displayedYIntercept3;
    static String rightAnswer3 = "The x-intercepts are: "+(double)Math.round(xValue3*100)/100+" and "+(double)Math.round(nextXValue3*100)/100;
    static String incorrect1Answer3 = "The x-intercepts are: "+(double)Math.round(randomized1middleX3*100)/100+" and "+(double)Math.round(randomized1YIntercept3*100)/100;
    static String incorrect2Answer3 = "The x-intercepts are: "+(double)Math.round(randomized2middleX3*100)/100+" and "+(double)Math.round(randomized2YIntercept3*100)/100;

    ///question4
    static double coefficientX4 = Q1.nextInt(3)+1;
    static double middleX4 = Q1.nextInt(30)+13;
    static double displayedYIntercept4 = Q1.nextInt(10)+1;
    static double leftEquationSide4 = Q1.nextInt(30)+1;
    static double yIntercept4 = displayedYIntercept4+leftEquationSide4*-1;
    static double xValue4 = ((-1*middleX4+Math.sqrt(middleX4*middleX4-4*coefficientX4*yIntercept4))/(2*coefficientX4));
    static double nextXValue4 = ((-1*middleX4-Math.sqrt(middleX4*middleX4-4*coefficientX4*yIntercept4))/(2*coefficientX4));
    static double randomized1middleX4 = xValue4 +1 + Q1.nextInt(3);
    static double randomized2middleX4 = xValue4 +1 + Q1.nextInt(3);
    static double randomized1YIntercept4 = nextXValue4+1 + Q1.nextInt(8);
    static double randomized2YIntercept4 = nextXValue4+1 + Q1.nextInt(8);
    static String questionDisplayed4 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide4+" = "+coefficientX4+"x^2 + "+middleX4+"x + "+displayedYIntercept4;
    static String rightAnswer4 = "The x-intercepts are: "+(double)Math.round(xValue4*100)/100+" and "+(double)Math.round(nextXValue4*100)/100;
    static String incorrect1Answer4 = "The x-intercepts are: "+(double)Math.round(randomized1middleX4*100)/100+" and "+(double)Math.round(randomized1YIntercept4*100)/100;
    static String incorrect2Answer4 = "The x-intercepts are: "+(double)Math.round(randomized2middleX4*100)/100+" and "+(double)Math.round(randomized2YIntercept4*100)/100;

    ///question5
    static double coefficientX5 = Q1.nextInt(3)+1;
    static double middleX5 = Q1.nextInt(30)+13;
    static double displayedYIntercept5 = Q1.nextInt(10)+1;
    static double leftEquationSide5 = Q1.nextInt(30)+1;
    static double yIntercept5 = displayedYIntercept5+leftEquationSide5*-1;
    static double xValue5 = ((-1*middleX5+Math.sqrt(middleX5*middleX5-4*coefficientX5*yIntercept5))/(2*coefficientX5));
    static double nextXValue5 = ((-1*middleX5-Math.sqrt(middleX5*middleX5-4*coefficientX5*yIntercept5))/(2*coefficientX5));
    static double randomized1middleX5 = xValue5 +1 + Q1.nextInt(3);
    static double randomized2middleX5 = xValue5 +1 + Q1.nextInt(3);
    static double randomized1YIntercept5 = nextXValue5+1 + Q1.nextInt(8);
    static double randomized2YIntercept5 = nextXValue5+1 + Q1.nextInt(8);
    static String questionDisplayed5 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide5+" = "+coefficientX5+"x^2 + "+middleX5+"x + "+displayedYIntercept5;
    static String rightAnswer5 = "The x-intercepts are: "+(double)Math.round(xValue5*100)/100+" and "+(double)Math.round(nextXValue5*100)/100;
    static String incorrect1Answer5 = "The x-intercepts are: "+(double)Math.round(randomized1middleX5*100)/100+" and "+(double)Math.round(randomized1YIntercept5*100)/100;
    static String incorrect2Answer5 = "The x-intercepts are: "+(double)Math.round(randomized2middleX5*100)/100+" and "+(double)Math.round(randomized2YIntercept5*100)/100;

    ///question6
    static double coefficientX6 = Q1.nextInt(3)+1;
    static double displayedMiddleX6 = Q1.nextInt(30)+13;
    static double leftEquationSide6 = Q1.nextInt(30)*-1-5;
    static double middleX6 = displayedMiddleX6+leftEquationSide6*-1;
    static double yIntercept6 = Q1.nextInt(10)+1;
    static double xValue6 = ((-1*middleX6+Math.sqrt(middleX6*middleX6-4*coefficientX6*yIntercept6))/(2*coefficientX6));
    static double nextXValue6 = ((-1*middleX6-Math.sqrt(middleX6*middleX6-4*coefficientX6*yIntercept6))/(2*coefficientX6));
    static double randomized1middleX6 = xValue6 +1 + Q1.nextInt(3);
    static double randomized2middleX6 = xValue6 +1 + Q1.nextInt(3);
    static double randomized1YIntercept6 = nextXValue6+1 + Q1.nextInt(8);
    static double randomized2YIntercept6 = nextXValue6+1 + Q1.nextInt(8);
    static String questionDisplayed6 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide6+"x = "+coefficientX6+"x^2 + "+displayedMiddleX6+"x + "+yIntercept6;
    static String rightAnswer6 = "The x-intercepts are: "+(double)Math.round(xValue6*100)/100+" and "+(double)Math.round(nextXValue6*100)/100;
    static String incorrect1Answer6 = "The x-intercepts are: "+(double)Math.round(randomized1middleX6*100)/100+" and "+(double)Math.round(randomized1YIntercept6*100)/100;
    static String incorrect2Answer6 = "The x-intercepts are: "+(double)Math.round(randomized2middleX6*100)/100+" and "+(double)Math.round(randomized2YIntercept6*100)/100;

    ///question7
    static double coefficientX7 = Q1.nextInt(3)+1;
    static double displayedMiddleX7 = Q1.nextInt(30)+13;
    static double leftEquationSide7 = Q1.nextInt(30)*-1-5;
    static double middleX7 = displayedMiddleX7+leftEquationSide7*-1;
    static double yIntercept7 = Q1.nextInt(10)+1;
    static double xValue7 = ((-1*middleX7+Math.sqrt(middleX7*middleX7-4*coefficientX7*yIntercept7))/(2*coefficientX7));
    static double nextXValue7 = ((-1*middleX7-Math.sqrt(middleX7*middleX7-4*coefficientX7*yIntercept7))/(2*coefficientX7));
    static double randomized1middleX7 = xValue7 +1 + Q1.nextInt(3);
    static double randomized2middleX7 = xValue7 +1 + Q1.nextInt(3);
    static double randomized1YIntercept7 = nextXValue7+1 + Q1.nextInt(8);
    static double randomized2YIntercept7 = nextXValue7+1 + Q1.nextInt(8);
    static String questionDisplayed7 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide7+"x = "+coefficientX7+"x^2 + "+displayedMiddleX7+"x + "+yIntercept7;
    static String rightAnswer7 = "The x-intercepts are: "+(double)Math.round(xValue7*100)/100+" and "+(double)Math.round(nextXValue7*100)/100;
    static String incorrect1Answer7 = "The x-intercepts are: "+(double)Math.round(randomized1middleX7*100)/100+" and "+(double)Math.round(randomized1YIntercept7*100)/100;
    static String incorrect2Answer7 = "The x-intercepts are: "+(double)Math.round(randomized2middleX7*100)/100+" and "+(double)Math.round(randomized2YIntercept7*100)/100;

    ///question8
    static double coefficientX8 = Q1.nextInt(3)+1;
    static double displayedMiddleX8 = Q1.nextInt(30)+13;
    static double leftEquationSide8 = Q1.nextInt(30)*-1-5;
    static double middleX8 = displayedMiddleX8+leftEquationSide8*-1;
    static double yIntercept8 = Q1.nextInt(10)+1;
    static double xValue8 = ((-1*middleX8+Math.sqrt(middleX8*middleX8-4*coefficientX8*yIntercept8))/(2*coefficientX8));
    static double nextXValue8 = ((-1*middleX8-Math.sqrt(middleX8*middleX8-4*coefficientX8*yIntercept8))/(2*coefficientX8));
    static double randomized1middleX8 = xValue8 +1 + Q1.nextInt(3);
    static double randomized2middleX8 = xValue8 +1 + Q1.nextInt(3);
    static double randomized1YIntercept8 = nextXValue8+1 + Q1.nextInt(8);
    static double randomized2YIntercept8 = nextXValue8+1 + Q1.nextInt(8);
    static String questionDisplayed8 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide8+"x = "+coefficientX8+"x^2 + "+displayedMiddleX8+"x + "+yIntercept8;
    static String rightAnswer8 = "The x-intercepts are: "+(double)Math.round(xValue8*100)/100+" and "+(double)Math.round(nextXValue8*100)/100;
    static String incorrect1Answer8 = "The x-intercepts are: "+(double)Math.round(randomized1middleX8*100)/100+" and "+(double)Math.round(randomized1YIntercept8*100)/100;
    static String incorrect2Answer8 = "The x-intercepts are: "+(double)Math.round(randomized2middleX8*100)/100+" and "+(double)Math.round(randomized2YIntercept8*100)/100;

    ///question9
    static double coefficientX9 = Q1.nextInt(3)+1;
    static double displayedMiddleX9 = Q1.nextInt(30)+13;
    static double leftEquationSide9 = Q1.nextInt(30)*-1-5;
    static double middleX9 = displayedMiddleX9+leftEquationSide9*-1;
    static double yIntercept9 = Q1.nextInt(10)+1;
    static double xValue9 = ((-1*middleX9+Math.sqrt(middleX9*middleX9-4*coefficientX9*yIntercept9))/(2*coefficientX9));
    static double nextXValue9 = ((-1*middleX9-Math.sqrt(middleX9*middleX9-4*coefficientX9*yIntercept9))/(2*coefficientX9));
    static double randomized1middleX9 = xValue9 +1 + Q1.nextInt(3);
    static double randomized2middleX9 = xValue9 +1 + Q1.nextInt(3);
    static double randomized1YIntercept9 = nextXValue9+1 + Q1.nextInt(8);
    static double randomized2YIntercept9 = nextXValue9+1 + Q1.nextInt(8);
    static String questionDisplayed9 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide9+"x = "+coefficientX9+"x^2 + "+displayedMiddleX9+"x + "+yIntercept9;
    static String rightAnswer9 = "The x-intercepts are: "+(double)Math.round(xValue9*100)/100+" and "+(double)Math.round(nextXValue9*100)/100;
    static String incorrect1Answer9 = "The x-intercepts are: "+(double)Math.round(randomized1middleX9*100)/100+" and "+(double)Math.round(randomized1YIntercept9*100)/100;
    static String incorrect2Answer9 = "The x-intercepts are: "+(double)Math.round(randomized2middleX9*100)/100+" and "+(double)Math.round(randomized2YIntercept9*100)/100;

    ///question10
    static double coefficientX10 = Q1.nextInt(3)+1;
    static double displayedMiddleX10 = Q1.nextInt(30)+13;
    static double leftEquationSide10 = Q1.nextInt(30)*-1-5;
    static double middleX10 = displayedMiddleX10+leftEquationSide10*-1;
    static double yIntercept10 = Q1.nextInt(10)+1;
    static double xValue10 = ((-1*middleX10+Math.sqrt(middleX10*middleX10-4*coefficientX10*yIntercept10))/(2*coefficientX10));
    static double nextXValue10 = ((-1*middleX10-Math.sqrt(middleX10*middleX10-4*coefficientX10*yIntercept10))/(2*coefficientX10));
    static double randomized1middleX10 = xValue10 +1 + Q1.nextInt(3);
    static double randomized2middleX10 = xValue10 +1 + Q1.nextInt(3);
    static double randomized1YIntercept10 = nextXValue10+1 + Q1.nextInt(8);
    static double randomized2YIntercept10 = nextXValue10+1 + Q1.nextInt(8);
    static String questionDisplayed10 = "Determine the x-intercepts for the following equation:\n"+leftEquationSide10+"x = "+coefficientX10+"x^2 + "+displayedMiddleX10+"x + "+yIntercept10;
    static String rightAnswer10 = "The x-intercepts are: "+(double)Math.round(xValue10*100)/100+" and "+(double)Math.round(nextXValue10*100)/100;
    static String incorrect1Answer10 = "The x-intercepts are: "+(double)Math.round(randomized1middleX10*100)/100+" and "+(double)Math.round(randomized1YIntercept10*100)/100;
    static String incorrect2Answer10 = "The x-intercepts are: "+(double)Math.round(randomized2middleX10*100)/100+" and "+(double)Math.round(randomized2YIntercept10*100)/100;

    //for the questions 11-15, the user will have to find the number of solutions to a quadratic using b^2-4ac. I will only comment the question directly below
    //question11
    static double coefficientX11 = Q1.nextInt(3)+1; //generate the coefficient of the quadratic
    static double middleRandomGenerator11 = Q1.nextInt(2); //generate this variable. This variable determines whether or not the middle-x term is positive or negative (See line 213 and below)
    static double middleX11 = Q1.nextInt(30)+1; //generate the middle x term

    static{
        if(middleRandomGenerator11==0){ //if this variable equals 0, set the middle-x term to negative
            middleX11 = middleX11*-1;
        }
        else{ //otherwise, do nothing
            System.out.println("");
        }
    }
    static double yIntercept11 = Q1.nextInt(50)+1; //generate the y-intercept of the quadratic
    static String questionDisplayed11 = "Determine the number of solutions to the following equation:\n"+coefficientX11+"x^2 + "+middleX11+"x + "+yIntercept11; //initialize the string that will contain the question
    static double doubleCorrectAnswer11 = middleX11*middleX11-4*coefficientX11*yIntercept11; //this variable contains the double-type answer to the formula b^2-4ac
    static double numberOfSolutions11;
    static{
        if (doubleCorrectAnswer11 > 0){ //if this variable is larger than 0, there are two solutions
            numberOfSolutions11 = 2;
        }
        else if(doubleCorrectAnswer11 == 0){ //if this variable equals 0, there is only one solution
            numberOfSolutions11 = 1;
        }
        else if(doubleCorrectAnswer11 < 0){ //if this variable is smaller than 0, there are no solutions to the quadratic
            numberOfSolutions11=0;
        }
    }
    static String rightAnswer11 = String.valueOf(numberOfSolutions11); //state the right and incorrect answer variables
    static String incorrect1Answer11 = String.valueOf(numberOfSolutions11+Q1.nextInt(5)+1);
    static String incorrect2Answer11 = String.valueOf(numberOfSolutions11+Q1.nextInt(5)+1);

    //question12
    static double coefficientX12 = Q1.nextInt(3)+1;
    static double middleRandomGenerator12 = Q1.nextInt(2);
    static double middleX12 = Q1.nextInt(30)+1;

    static{
        if(middleRandomGenerator12==0){
            middleX12 = middleX12*-1;
        }
        else{
            System.out.println("");
        }
    }
    static double yIntercept12 = Q1.nextInt(50)+1;
    static String questionDisplayed12 = "Determine the number of solutions to the following equation:\n"+coefficientX12+"x^2 + "+middleX12+"x + "+yIntercept12;
    static double doubleCorrectAnswer12 = middleX12*middleX12-4*coefficientX12*yIntercept12;
    static double numberOfSolutions12;
    static{
        if (doubleCorrectAnswer12 > 0){
            numberOfSolutions12 = 2;
        }
        else if(doubleCorrectAnswer12 == 0){
            numberOfSolutions12 = 1;
        }
        else if(doubleCorrectAnswer12 < 0){
            numberOfSolutions12=0;
        }
    }
    static String rightAnswer12 = String.valueOf(numberOfSolutions12);
    static String incorrect1Answer12 = String.valueOf(numberOfSolutions12+Q1.nextInt(5)+1);
    static String incorrect2Answer12 = String.valueOf(numberOfSolutions12+Q1.nextInt(5)+1);

    //question13
    static double coefficientX13 = Q1.nextInt(3)+1;
    static double middleRandomGenerator13 = Q1.nextInt(2);
    static double middleX13 = Q1.nextInt(30)+1;

    static{
        if(middleRandomGenerator13==0){
            middleX13 = middleX13*-1;
        }
        else{
            System.out.println("");
        }
    }
    static double yIntercept13 = Q1.nextInt(50)+1;
    static String questionDisplayed13 = "Determine the number of solutions to the following equation:\n"+coefficientX13+"x^2 + "+middleX13+"x + "+yIntercept13;
    static double doubleCorrectAnswer13 = middleX13*middleX13-4*coefficientX13*yIntercept13;
    static double numberOfSolutions13;
    static{
        if (doubleCorrectAnswer13 > 0){
            numberOfSolutions13 = 2;
        }
        else if(doubleCorrectAnswer13 == 0){
            numberOfSolutions13 = 1;
        }
        else if(doubleCorrectAnswer13 < 0){
            numberOfSolutions13=0;
        }
    }
    static String rightAnswer13 = String.valueOf(numberOfSolutions13);
    static String incorrect1Answer13 = String.valueOf(numberOfSolutions13+Q1.nextInt(5)+1);
    static String incorrect2Answer13 = String.valueOf(numberOfSolutions13+Q1.nextInt(5)+1);

    //question14
    static double coefficientX14 = Q1.nextInt(3)+1;
    static double middleRandomGenerator14 = Q1.nextInt(2);
    static double middleX14 = Q1.nextInt(30)+1;

    static{
        if(middleRandomGenerator14==0){
            middleX14 = middleX14*-1;
        }
        else{
            System.out.println("");
        }
    }
    static double yIntercept14 = Q1.nextInt(50)+1;
    static String questionDisplayed14 = "Determine the number of solutions to the following equation:\n"+coefficientX14+"x^2 + "+middleX14+"x + "+yIntercept14;
    static double doubleCorrectAnswer14 = middleX14*middleX14-4*coefficientX14*yIntercept14;
    static double numberOfSolutions14;
    static{
        if (doubleCorrectAnswer14 > 0){
            numberOfSolutions14 = 2;
        }
        else if(doubleCorrectAnswer14 == 0){
            numberOfSolutions14 = 1;
        }
        else if(doubleCorrectAnswer14 < 0){
            numberOfSolutions14=0;
        }
    }
    static String rightAnswer14 = String.valueOf(numberOfSolutions14);
    static String incorrect1Answer14 = String.valueOf(numberOfSolutions14+Q1.nextInt(5)+1);
    static String incorrect2Answer14 = String.valueOf(numberOfSolutions14+Q1.nextInt(5)+1);

    //question15
    static double coefficientX15 = Q1.nextInt(3)+1;
    static double middleRandomGenerator15 = Q1.nextInt(2);
    static double middleX15 = Q1.nextInt(30)+1;

    static{
        if(middleRandomGenerator15==0){
            middleX15 = middleX15*-1;
        }
        else{
            System.out.println("");
        }
    }
    static double yIntercept15 = Q1.nextInt(50)+1;
    static String questionDisplayed15 = "Determine the number of solutions to the following equation:\n"+coefficientX15+"x^2 + "+middleX15+"x + "+yIntercept15;
    static double doubleCorrectAnswer15 = middleX15*middleX15-4*coefficientX15*yIntercept15;
    static double numberOfSolutions15;
    static{
        if (doubleCorrectAnswer15 > 0){
            numberOfSolutions15 = 2;
        }
        else if(doubleCorrectAnswer15 == 0){
            numberOfSolutions15 = 1;
        }
        else if(doubleCorrectAnswer15 < 0){
            numberOfSolutions15=0;
        }
    }
    static String rightAnswer15 = String.valueOf(numberOfSolutions15);
    static String incorrect1Answer15 = String.valueOf(numberOfSolutions15+Q1.nextInt(5)+1);
    static String incorrect2Answer15 = String.valueOf(numberOfSolutions15+Q1.nextInt(5)+1);;

    ////////////////////////////////////question stuff ends

    public static String mathQuestion[] ={ //the questions displayed in the GUI are taken from here
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
        setContentView(R.layout.activity_test_questioning_page5); // set the .xml file in review to the corresponding test questioning page xml file

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
            Intent intent = new Intent(this, testRecap5.class);
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