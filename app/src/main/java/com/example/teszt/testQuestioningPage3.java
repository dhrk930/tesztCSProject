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

public class testQuestioningPage3 extends AppCompatActivity implements View.OnClickListener{

    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = mathQuestion.length;
    public static int score = 0;
    int ongoingQuestion = 0;
    String choosenAnswer = "";

    ////////////////////////////////all question stuff below
    static Random Q1 = new Random();

    //for the questions 1-5, the user has to expand a binomial factored equation (ax+b)(cx+d). Because the following questions are of the same type, I will only comment the question below.
    //question1
    static double C1X = Q1.nextInt(6)+1; //generate the value of a (I'm referring to the sample factoring in line 32 right above).
    static double C1Y = Q1.nextInt(15)+1; //generate the value of b
    static double C2X = Q1.nextInt(6)+1; //generate the value of c
    static double C2Y = Q1.nextInt(15)+1; //generate the value of d
    static double coefficientX = C1X*C2X; //Now the expanding begins. Here the leading coefficient's x-value is found.
    static double middleX = C1X*C2Y+C1Y*C2X; // the middle x (For example, in the equation x^2+3x+9, I'd consider 3 as the middle x) is found
    static double yIntercept = C1Y*C2Y; // the last term of a quadratic, the y-intercept is found
    static double coefficient1X = C1X*C2X+Q1.nextInt(5)+1; // from this line (line 41) to line 46, the coefficient, middle x and y-intercept values are all randomized - as stated in previous units, these variables are for the incorrect answers.
    static double middle1X = C1X*C2Y+C1Y*C2X+ Q1.nextInt(5)+1;
    static double y1Intercept = C1Y*C2Y+Q1.nextInt(5)+1;
    static double coefficient2X = C1X*C2X+Q1.nextInt(5)+1;
    static double middle2X = C1X*C2Y+C1Y*C2X+ Q1.nextInt(5)+1;
    static double y2Intercept = C1Y*C2Y+Q1.nextInt(5)+1;
    static String rightAnswer = coefficientX+"x^2 + "+middleX+"x + "+yIntercept; //initialize the correct and incorrect answers
    static String incorrect1Answer = coefficient1X+"x^2 + "+middle1X+"x + "+y1Intercept;
    static String incorrect2Answer = coefficient2X+"x^2 + "+middle2X+"x + "+y2Intercept;

    //question2
    static double C1X2 = Q1.nextInt(6)+1;
    static double C1Y2 = Q1.nextInt(15)+1;
    static double C2X2 = Q1.nextInt(6)+1;
    static double C2Y2 = Q1.nextInt(15)+1;
    static double coefficientX2 = C1X2*C2X2;
    static double middleX2 = C1X2*C2Y2+C1Y2*C2X2;
    static double yIntercept2 = C1Y2*C2Y2;
    static double coefficient1X2 = C1X2*C2X2+Q1.nextInt(5)+1;
    static double middle1X2 = C1X2*C2Y2+C1Y2*C2X2+ Q1.nextInt(5)+1;
    static double y1Intercept2 = C1Y2*C2Y2+Q1.nextInt(5)+1;
    static double coefficient2X2 = C1X2*C2X2+Q1.nextInt(5)+1;
    static double middle2X2 = C1X2*C2Y2+C1Y2*C2X2+ Q1.nextInt(5)+1;
    static double y2Intercept2 = C1Y2*C2Y2+Q1.nextInt(5)+1;
    static String rightAnswer2 = coefficientX2+"x^2 + "+middleX2+"x + "+yIntercept2;
    static String incorrect1Answer2 = coefficient1X2+"x^2 + "+middle1X2+"x + "+y1Intercept2;
    static String incorrect2Answer2 = coefficient2X2+"x^2 + "+middle2X2+"x + "+y2Intercept2;

    //question3
    static double C1X3 = Q1.nextInt(6)+1;
    static double C1Y3 = Q1.nextInt(15)+1;
    static double C2X3 = Q1.nextInt(6)+1;
    static double C2Y3 = Q1.nextInt(15)+1;
    static double coefficientX3 = C1X3*C2X3;
    static double middleX3 = C1X3*C2Y3+C1Y3*C2X3;
    static double yIntercept3 = C1Y3*C2Y3;
    static double coefficient1X3 = C1X3*C2X3+Q1.nextInt(5)+1;
    static double middle1X3 = C1X3*C2Y3+C1Y3*C2X3+ Q1.nextInt(5)+1;
    static double y1Intercept3 = C1Y3*C2Y3+Q1.nextInt(5)+1;
    static double coefficient2X3 = C1X3*C2X3+Q1.nextInt(5)+1;
    static double middle2X3 = C1X3*C2Y3+C1Y3*C2X3+ Q1.nextInt(5)+1;
    static double y2Intercept3 = C1Y3*C2Y3+Q1.nextInt(5)+1;
    static String rightAnswer3 = coefficientX3+"x^2 + "+middleX3+"x + "+yIntercept3;
    static String incorrect1Answer3 = coefficient1X3+"x^2 + "+middle1X3+"x + "+y1Intercept3;
    static String incorrect2Answer3 = coefficient2X3+"x^2 + "+middle2X3+"x + "+y2Intercept3;

    //question4
    static double C1X4 = Q1.nextInt(6)+1;
    static double C1Y4 = Q1.nextInt(15)+1;
    static double C2X4 = Q1.nextInt(6)+1;
    static double C2Y4 = Q1.nextInt(15)+1;
    static double coefficientX4 = C1X4*C2X4;
    static double middleX4 = C1X4*C2Y4+C1Y4*C2X4;
    static double yIntercept4 = C1Y4*C2Y4;
    static double coefficient1X4 = C1X4*C2X4+Q1.nextInt(5)+1;
    static double middle1X4 = C1X4*C2Y4+C1Y4*C2X4+ Q1.nextInt(5)+1;
    static double y1Intercept4 = C1Y4*C2Y4+Q1.nextInt(5)+1;
    static double coefficient2X4 = C1X4*C2X4+Q1.nextInt(5)+1;
    static double middle2X4 = C1X4*C2Y4+C1Y4*C2X4+ Q1.nextInt(5)+1;
    static double y2Intercept4 = C1Y4*C2Y4+Q1.nextInt(5)+1;
    static String rightAnswer4 = coefficientX4+"x^2 + "+middleX4+"x + "+yIntercept4;
    static String incorrect1Answer4 = coefficient1X4+"x^2 + "+middle1X4+"x + "+y1Intercept4;
    static String incorrect2Answer4 = coefficient2X4+"x^2 + "+middle2X4+"x + "+y2Intercept4;

    //question5
    static double C1X5 = Q1.nextInt(6)+1;
    static double C1Y5 = Q1.nextInt(15)+1;
    static double C2X5 = Q1.nextInt(6)+1;
    static double C2Y5 = Q1.nextInt(15)+1;
    static double coefficientX5 = C1X5*C2X5;
    static double middleX5 = C1X5*C2Y5+C1Y5*C2X5;
    static double yIntercept5 = C1Y5*C2Y5;
    static double coefficient1X5 = C1X5*C2X5+Q1.nextInt(5)+1;
    static double middle1X5 = C1X5*C2Y5+C1Y5*C2X5+ Q1.nextInt(5)+1;
    static double y1Intercept5 = C1Y5*C2Y5+Q1.nextInt(5)+1;
    static double coefficient2X5 = C1X5*C2X5+Q1.nextInt(5)+1;
    static double middle2X5 = C1X5*C2Y5+C1Y5*C2X5+ Q1.nextInt(5)+1;
    static double y2Intercept5 = C1Y5*C2Y5+Q1.nextInt(5)+1;
    static String rightAnswer5 = coefficientX5+"x^2 + "+middleX5+"x + "+yIntercept5;
    static String incorrect1Answer5 = coefficient1X5+"x^2 + "+middle1X5+"x + "+y1Intercept5;
    static String incorrect2Answer5 = coefficient2X5+"x^2 + "+middle2X5+"x + "+y2Intercept5;

    //in the questions 6-10, the user will have to factor a quadratic. Because these questions are of the same type, I will only comment the question below.
    //question6
    static double coefficientX6 = Q1.nextInt(3)+1; //randomly generate the coefficient, the middlex and the y intercept of the quadratic equation
    static double middleX6 = Q1.nextInt(30)+13;
    static double yIntercept6 = Q1.nextInt(10)+1;
    static double x6Value = ((-1* middleX6 +Math.sqrt(middleX6 * middleX6 -4* coefficientX6 * yIntercept6))/(2* coefficientX6)); //find the solutions (x-intercepts with the x-axis) of the randomly generated equation using the quadratic formula and assign these solutions to these two variables
    static double nextX6Value = ((-1* middleX6 -Math.sqrt(middleX6 * middleX6 -4* coefficientX6 * yIntercept6))/(2* coefficientX6));
    static double randomized1CoefficientX6 = coefficientX6+1 + Q1.nextInt(3); //from lines 130 to lines 135, everything is randomly generated once again in order to serve the purpose of creating the incorrect answers.
    static double randomized2CoefficientX6 = coefficientX6+1 + Q1.nextInt(3);
    static double randomized1middleX6 = x6Value +1 + Q1.nextInt(3);
    static double randomized2middleX6 = x6Value +1 + Q1.nextInt(3);
    static double randomized1YIntercept6 = nextX6Value +1 + Q1.nextInt(8);
    static double randomized2YIntercept6 = nextX6Value +1 + Q1.nextInt(8);
    static String rightAnswer6 = coefficientX6+"(x - "+ (double)Math.round(x6Value*100)/100 +")(x - "+ (double)Math.round(nextX6Value*100)/100 +")"; //initialize the right answer
    static String incorrect1Answer6 = randomized1CoefficientX6+"(x - "+(double)Math.round(randomized1middleX6*100)/100+")(x - "+(double)Math.round(randomized1YIntercept6*100)/100+")"; //initialize the incorrect answers using the randomized variables from the lines above
    static String incorrect2Answer6 = randomized2CoefficientX6+"(x - "+(double)Math.round(randomized2middleX6*100)/100+")(x - "+(double)Math.round(randomized2YIntercept6*100)/100+")";

    //question7
    static double coefficientX7 = Q1.nextInt(3)+1;
    static double middleX7 = Q1.nextInt(30)+13;
    static double yIntercept7 = Q1.nextInt(10)+1;
    static double x7Value = ((-1* middleX7 +Math.sqrt(middleX7 * middleX7 -4* coefficientX7 * yIntercept7))/(2* coefficientX7));
    static double nextX7Value = ((-1* middleX7 -Math.sqrt(middleX7 * middleX7 -4* coefficientX7 * yIntercept7))/(2* coefficientX7));
    static double randomized1CoefficientX7 = coefficientX7+1 + Q1.nextInt(3);
    static double randomized2CoefficientX7 = coefficientX7+1 + Q1.nextInt(3);
    static double randomized1middleX7 = x7Value +1 + Q1.nextInt(3);
    static double randomized2middleX7 = x7Value +1 + Q1.nextInt(3);
    static double randomized1YIntercept7 = nextX7Value +1 + Q1.nextInt(8);
    static double randomized2YIntercept7 = nextX7Value +1 + Q1.nextInt(8);
    static String rightAnswer7 = coefficientX7+"(x - "+ (double)Math.round(x7Value*100)/100 +")(x - "+ (double)Math.round(nextX7Value*100)/100 +")";
    static String incorrect1Answer7 = randomized1CoefficientX7+"(x - "+(double)Math.round(randomized1middleX7*100)/100+")(x - "+(double)Math.round(randomized1YIntercept7*100)/100+")";
    static String incorrect2Answer7 = randomized2CoefficientX7+"(x - "+(double)Math.round(randomized2middleX7*100)/100+")(x - "+(double)Math.round(randomized2YIntercept7*100)/100+")";

    //question8
    static double coefficientX8 = Q1.nextInt(3)+1;
    static double middleX8 = Q1.nextInt(30)+13;
    static double yIntercept8 = Q1.nextInt(10)+1;
    static double x8Value = ((-1* middleX8 +Math.sqrt(middleX8 * middleX8 -4* coefficientX8 * yIntercept8))/(2* coefficientX8));
    static double nextX8Value = ((-1* middleX8 -Math.sqrt(middleX8 * middleX8 -4* coefficientX8 * yIntercept8))/(2* coefficientX8));
    static double randomized1CoefficientX8 = coefficientX8+1 + Q1.nextInt(3);
    static double randomized2CoefficientX8 = coefficientX8+1 + Q1.nextInt(3);
    static double randomized1middleX8 = x8Value +1 + Q1.nextInt(3);
    static double randomized2middleX8 = x8Value +1 + Q1.nextInt(3);
    static double randomized1YIntercept8 = nextX8Value +1 + Q1.nextInt(8);
    static double randomized2YIntercept8 = nextX8Value +1 + Q1.nextInt(8);
    static String rightAnswer8 = coefficientX8+"(x - "+ (double)Math.round(x8Value*100)/100 +")(x - "+ (double)Math.round(nextX8Value*100)/100 +")";
    static String incorrect1Answer8 = randomized1CoefficientX8+"(x - "+(double)Math.round(randomized1middleX8*100)/100+")(x - "+(double)Math.round(randomized1YIntercept8*100)/100+")";
    static String incorrect2Answer8 = randomized2CoefficientX8+"(x - "+(double)Math.round(randomized2middleX8*100)/100+")(x - "+(double)Math.round(randomized2YIntercept8*100)/100+")";

    //question9
    static double coefficientX9 = Q1.nextInt(3)+1;
    static double middleX9 = Q1.nextInt(30)+13;
    static double yIntercept9 = Q1.nextInt(10)+1;
    static double x9Value = ((-1* middleX9 +Math.sqrt(middleX9 * middleX9 -4* coefficientX9 * yIntercept9))/(2* coefficientX9));
    static double nextX9Value = ((-1* middleX9 -Math.sqrt(middleX9 * middleX9 -4* coefficientX9 * yIntercept9))/(2* coefficientX9));
    static double randomized1CoefficientX9 = coefficientX9+1 + Q1.nextInt(3);
    static double randomized2CoefficientX9 = coefficientX9+1 + Q1.nextInt(3);
    static double randomized1middleX9 = x9Value +1 + Q1.nextInt(3);
    static double randomized2middleX9 = x9Value +1 + Q1.nextInt(3);
    static double randomized1YIntercept9 = nextX9Value +1 + Q1.nextInt(8);
    static double randomized2YIntercept9 = nextX9Value +1 + Q1.nextInt(8);
    static String rightAnswer9 = coefficientX9+"(x - "+ (double)Math.round(x9Value*100)/100 +")(x - "+ (double)Math.round(nextX9Value*100)/100 +")";
    static String incorrect1Answer9 = randomized1CoefficientX9+"(x - "+(double)Math.round(randomized1middleX9*100)/100+")(x - "+(double)Math.round(randomized1YIntercept9*100)/100+")";
    static String incorrect2Answer9 = randomized2CoefficientX9+"(x - "+(double)Math.round(randomized2middleX9*100)/100+")(x - "+(double)Math.round(randomized2YIntercept9*100)/100+")";

    //question10
    static double coefficientX10 = Q1.nextInt(3)+1;
    static double middleX10 = Q1.nextInt(30)+13;
    static double yIntercept10 = Q1.nextInt(10)+1;
    static double x10Value = ((-1* middleX10 +Math.sqrt(middleX10 * middleX10 -4* coefficientX10 * yIntercept10))/(2* coefficientX10));
    static double nextX10Value = ((-1* middleX10 -Math.sqrt(middleX10 * middleX10 -4* coefficientX10 * yIntercept10))/(2* coefficientX10));
    static double randomized1CoefficientX10 = coefficientX10+1 + Q1.nextInt(3);
    static double randomized2CoefficientX10 = coefficientX10+1 + Q1.nextInt(3);
    static double randomized1middleX10 = x10Value +1 + Q1.nextInt(3);
    static double randomized2middleX10 = x10Value +1 + Q1.nextInt(3);
    static double randomized1YIntercept10 = nextX10Value +1 + Q1.nextInt(8);
    static double randomized2YIntercept10 = nextX10Value +1 + Q1.nextInt(8);
    static String rightAnswer10 = coefficientX10+"(x - "+ (double)Math.round(x10Value*100)/100 +")(x - "+ (double)Math.round(nextX10Value*100)/100 +")";
    static String incorrect1Answer10 = randomized1CoefficientX10+"(x - "+(double)Math.round(randomized1middleX10*100)/100+")(x - "+(double)Math.round(randomized1YIntercept10*100)/100+")";
    static String incorrect2Answer10 = randomized2CoefficientX10+"(x - "+(double)Math.round(randomized2middleX10*100)/100+")(x - "+(double)Math.round(randomized2YIntercept10*100)/100+")";

    //in the rest of the questions on this test, the user will have to expand a linear equation that has been raised to a randomized exponent using pascal's triangle. Because the following questions are of the same type, I will only comment the question below
    //question11
    static double C1Y11 = Q1.nextInt(15); //The equation formed that the user will have to expand looks like this: (x+b)^c. Here, b is randomly generated
    static double exponent11 = Q1.nextInt(3)+2; //The exponent or in other words C is randomly generated.
    static double first1RandomizedTerm = C1Y11 + Q1.nextInt(15)+1; //variables are randomized from this line to line 215.
    static double second1RandomizedTerm = C1Y11*C1Y11 + Q1.nextInt(15)+1;
    static double third1RandomizedTerm = C1Y11*C1Y11*C1Y11 + Q1.nextInt(15)+1;
    static double fourth1RandomizedTerm = C1Y11*C1Y11*C1Y11*C1Y11 + Q1.nextInt(15)+1;
    static double first2RandomizedTerm = C1Y11 + Q1.nextInt(15)+1;
    static double second2RandomizedTerm = C1Y11*C1Y11 + Q1.nextInt(15)+1;
    static double third2RandomizedTerm = C1Y11*C1Y11*C1Y11 + Q1.nextInt(15)+1;
    static double fourth2RandomizedTerm = C1Y11*C1Y11*C1Y11*C1Y11 + Q1.nextInt(15)+1;
    static String rightAnswer11; //right and incorrect answers are stated.
    static String incorrect1Answer11;
    static String incorrect2Answer11;

    static{ //expanding an equation such as (x+b)^c using pascal's triangle very much depends on the value of C. Below, the right and incorrect answers are assigned differently depending on the randomly generated exponent.
        if (exponent11 == 4){
            rightAnswer11 = "x^4 + "+(4*C1Y11)+"x^3 + "+(6*C1Y11*C1Y11)+"x^2 + "+(4*C1Y11*C1Y11*C1Y11)+ "x +" +(C1Y11*C1Y11*C1Y11*C1Y11);
            incorrect1Answer11 = "x^4 + "+(first1RandomizedTerm)+"x^3 + "+(second1RandomizedTerm)+"x^2 + "+(third1RandomizedTerm)+ "x + " +(fourth1RandomizedTerm);
            incorrect2Answer11 = "x^4 + "+(first2RandomizedTerm)+"x^3 + "+(second2RandomizedTerm)+"x^2 + "+(third2RandomizedTerm)+ "x + " +(fourth2RandomizedTerm);

        }
        else if (exponent11 == 3){
            rightAnswer11 = "x^3 + "+(3*C1Y11)+"x^2 + "+(3*C1Y11*C1Y11)+"x + "+(C1Y11*C1Y11*C1Y11);
            incorrect1Answer11 = "x^3 + "+(first1RandomizedTerm)+"x^2 + "+(second1RandomizedTerm)+"x + "+(third1RandomizedTerm);
            incorrect2Answer11 = "x^3 + "+(first2RandomizedTerm)+"x^2 + "+(second2RandomizedTerm)+"x + "+(third2RandomizedTerm);
        }
        else if (exponent11 == 2){
            rightAnswer11 = "x^2 + "+(2*C1Y11)+"x + "+(C1Y11*C1Y11);
            incorrect1Answer11 = "x^2 + "+(first1RandomizedTerm)+"x + "+(second1RandomizedTerm);
            incorrect2Answer11 = "x^2 + "+(first2RandomizedTerm)+"x + "+(second2RandomizedTerm);
        }
    }

    //question12
    static double C1Y12 = Q1.nextInt(15);
    static double exponent12 = Q1.nextInt(3)+2;
    static double first1RandomizedTerm12 = C1Y12 + Q1.nextInt(15)+1;
    static double second1RandomizedTerm12 = C1Y12*C1Y12 + Q1.nextInt(15)+1;
    static double third1RandomizedTerm12 = C1Y12*C1Y12*C1Y12 + Q1.nextInt(15)+1;
    static double fourth1RandomizedTerm12 = C1Y12*C1Y12*C1Y12*C1Y12 + Q1.nextInt(15)+1;
    static double first2RandomizedTerm12 = C1Y12 + Q1.nextInt(15)+1;
    static double second2RandomizedTerm12 = C1Y12*C1Y12 + Q1.nextInt(15)+1;
    static double third2RandomizedTerm12 = C1Y12*C1Y12*C1Y12 + Q1.nextInt(15)+1;
    static double fourth2RandomizedTerm12 = C1Y12*C1Y12*C1Y12*C1Y12 + Q1.nextInt(15)+1;
    static String rightAnswer12;
    static String incorrect1Answer12;
    static String incorrect2Answer12;

    static{
        if (exponent12 == 4){
            rightAnswer12 = "x^4 + "+(4*C1Y12)+"x^3 + "+(6*C1Y12*C1Y12)+"x^2 + "+(4*C1Y12*C1Y12*C1Y12)+ "x +" +(C1Y12*C1Y12*C1Y12*C1Y12);
            incorrect1Answer12 = "x^4 + "+(first1RandomizedTerm12)+"x^3 + "+(second1RandomizedTerm12)+"x^2 + "+(third1RandomizedTerm12)+ "x + " +(fourth1RandomizedTerm12);
            incorrect2Answer12 = "x^4 + "+(first2RandomizedTerm12)+"x^3 + "+(second2RandomizedTerm12)+"x^2 + "+(third2RandomizedTerm12)+ "x + " +(fourth2RandomizedTerm12);

        }
        else if (exponent12 == 3){
            rightAnswer12 = "x^3 + "+(3*C1Y12)+"x^2 + "+(3*C1Y12*C1Y12)+"x + "+(C1Y12*C1Y12*C1Y12);
            incorrect1Answer12 = "x^3 + "+(first1RandomizedTerm12)+"x^2 + "+(second1RandomizedTerm12)+"x + "+(third1RandomizedTerm12);
            incorrect2Answer12 = "x^3 + "+(first2RandomizedTerm12)+"x^2 + "+(second2RandomizedTerm12)+"x + "+(third2RandomizedTerm12);
        }
        else if (exponent12 == 2){
            rightAnswer12 = "x^2 + "+(2*C1Y12)+"x + "+(C1Y12*C1Y12);
            incorrect1Answer12 = "x^2 + "+(first1RandomizedTerm12)+"x + "+(second1RandomizedTerm12);
            incorrect2Answer12 = "x^2 + "+(first2RandomizedTerm12)+"x + "+(second2RandomizedTerm12);
        }
    }

    //question13
    static double C1Y13 = Q1.nextInt(15);
    static double exponent13 = Q1.nextInt(3)+2;
    static double first1RandomizedTerm13 = C1Y13 + Q1.nextInt(15)+1;
    static double second1RandomizedTerm13 = C1Y13*C1Y13 + Q1.nextInt(15)+1;
    static double third1RandomizedTerm13 = C1Y13*C1Y13*C1Y13 + Q1.nextInt(15)+1;
    static double fourth1RandomizedTerm13 = C1Y13*C1Y13*C1Y13*C1Y13 + Q1.nextInt(15)+1;
    static double first2RandomizedTerm13 = C1Y13 + Q1.nextInt(15)+1;
    static double second2RandomizedTerm13 = C1Y13*C1Y13 + Q1.nextInt(15)+1;
    static double third2RandomizedTerm13 = C1Y13*C1Y13*C1Y13 + Q1.nextInt(15)+1;
    static double fourth2RandomizedTerm13 = C1Y13*C1Y13*C1Y13*C1Y13 + Q1.nextInt(15)+1;
    static String rightAnswer13;
    static String incorrect1Answer13;
    static String incorrect2Answer13;

    static{
        if (exponent13 == 4){
            rightAnswer13= "x^4 + "+(4*C1Y13)+"x^3 + "+(6*C1Y13*C1Y13)+"x^2 + "+(4*C1Y13*C1Y13*C1Y13)+ "x +" +(C1Y13*C1Y13*C1Y13*C1Y13);
            incorrect1Answer13 = "x^4 + "+(first1RandomizedTerm13)+"x^3 + "+(second1RandomizedTerm13)+"x^2 + "+(third1RandomizedTerm13)+ "x + " +(fourth1RandomizedTerm13);
            incorrect2Answer13 = "x^4 + "+(first2RandomizedTerm13)+"x^3 + "+(second2RandomizedTerm13)+"x^2 + "+(third2RandomizedTerm13)+ "x + " +(fourth2RandomizedTerm13);

        }
        else if (exponent13 == 3){
            rightAnswer13 = "x^3 + "+(3*C1Y13)+"x^2 + "+(3*C1Y13*C1Y13)+"x + "+(C1Y13*C1Y13*C1Y13);
            incorrect1Answer13 = "x^3 + "+(first1RandomizedTerm13)+"x^2 + "+(second1RandomizedTerm13)+"x + "+(third1RandomizedTerm13);
            incorrect2Answer13 = "x^3 + "+(first2RandomizedTerm13)+"x^2 + "+(second2RandomizedTerm13)+"x + "+(third2RandomizedTerm13);
        }
        else if (exponent13 == 2){
            rightAnswer13 = "x^2 + "+(2*C1Y13)+"x + "+(C1Y13*C1Y13);
            incorrect1Answer13 = "x^2 + "+(first1RandomizedTerm13)+"x + "+(second1RandomizedTerm13);
            incorrect2Answer13 = "x^2 + "+(first2RandomizedTerm13)+"x + "+(second2RandomizedTerm13);
        }
    }

    //question14
    static double C1Y14 = Q1.nextInt(15);
    static double exponent14 = Q1.nextInt(3)+2;
    static double first1RandomizedTerm14 = C1Y14 + Q1.nextInt(15)+1;
    static double second1RandomizedTerm14 = C1Y14*C1Y14 + Q1.nextInt(15)+1;
    static double third1RandomizedTerm14 = C1Y14*C1Y14*C1Y14 + Q1.nextInt(15)+1;
    static double fourth1RandomizedTerm14 = C1Y14*C1Y14*C1Y14*C1Y14 + Q1.nextInt(15)+1;
    static double first2RandomizedTerm14 = C1Y14 + Q1.nextInt(15)+1;
    static double second2RandomizedTerm14 = C1Y14*C1Y14 + Q1.nextInt(15)+1;
    static double third2RandomizedTerm14 = C1Y14*C1Y14*C1Y14 + Q1.nextInt(15)+1;
    static double fourth2RandomizedTerm14 = C1Y14*C1Y14*C1Y14*C1Y14 + Q1.nextInt(15)+1;
    static String rightAnswer14;
    static String incorrect1Answer14;
    static String incorrect2Answer14;

    static{
        if (exponent14 == 4){
            rightAnswer14 = "x^4 + "+(4*C1Y14)+"x^3 + "+(6*C1Y14*C1Y14)+"x^2 + "+(4*C1Y14*C1Y14*C1Y14)+ "x +" +(C1Y14*C1Y14*C1Y14*C1Y14);
            incorrect1Answer14 = "x^4 + "+(first1RandomizedTerm14)+"x^3 + "+(second1RandomizedTerm14)+"x^2 + "+(third1RandomizedTerm14)+ "x + " +(fourth1RandomizedTerm14);
            incorrect2Answer14 = "x^4 + "+(first2RandomizedTerm14)+"x^3 + "+(second2RandomizedTerm14)+"x^2 + "+(third2RandomizedTerm14)+ "x + " +(fourth2RandomizedTerm14);

        }
        else if (exponent14 == 3){
            rightAnswer14 = "x^3 + "+(3*C1Y14)+"x^2 + "+(3*C1Y14*C1Y14)+"x + "+(C1Y14*C1Y14*C1Y14);
            incorrect1Answer14= "x^3 + "+(first1RandomizedTerm14)+"x^2 + "+(second1RandomizedTerm14)+"x + "+(third1RandomizedTerm14);
            incorrect2Answer14= "x^3 + "+(first2RandomizedTerm14)+"x^2 + "+(second2RandomizedTerm14)+"x + "+(third2RandomizedTerm14);
        }
        else if (exponent14 == 2){
            rightAnswer14 = "x^2 + "+(2*C1Y14)+"x + "+(C1Y14*C1Y14);
            incorrect1Answer14 = "x^2 + "+(first1RandomizedTerm14)+"x + "+(second1RandomizedTerm14);
            incorrect2Answer14 = "x^2 + "+(first2RandomizedTerm14)+"x + "+(second2RandomizedTerm14);
        }
    }

    //question15
    static double C1Y15 = Q1.nextInt(15);
    static double exponent15 = Q1.nextInt(3)+2;
    static double first1RandomizedTerm15 = C1Y15 + Q1.nextInt(15)+1;
    static double second1RandomizedTerm15 = C1Y15*C1Y15 + Q1.nextInt(15)+1;
    static double third1RandomizedTerm15 = C1Y15*C1Y15*C1Y15 + Q1.nextInt(15)+1;
    static double fourth1RandomizedTerm15 = C1Y15*C1Y15*C1Y15*C1Y15 + Q1.nextInt(15)+1;
    static double first2RandomizedTerm15 = C1Y15 + Q1.nextInt(15)+1;
    static double second2RandomizedTerm15 = C1Y15*C1Y15 + Q1.nextInt(15)+1;
    static double third2RandomizedTerm15 = C1Y15*C1Y15*C1Y15 + Q1.nextInt(15)+1;
    static double fourth2RandomizedTerm15 = C1Y15*C1Y15*C1Y15*C1Y15 + Q1.nextInt(15)+1;
    static String rightAnswer15;
    static String incorrect1Answer15;
    static String incorrect2Answer15;

    static{
        if (exponent15 == 4){
            rightAnswer15 = "x^4 + "+(4*C1Y15)+"x^3 + "+(6*C1Y15*C1Y15)+"x^2 + "+(4*C1Y15*C1Y15*C1Y15)+ "x +" +(C1Y15*C1Y15*C1Y15*C1Y15);
            incorrect1Answer15 = "x^4 + "+(first1RandomizedTerm15)+"x^3 + "+(second1RandomizedTerm15)+"x^2 + "+(third1RandomizedTerm15)+ "x + " +(fourth1RandomizedTerm15);
            incorrect2Answer15 = "x^4 + "+(first2RandomizedTerm15)+"x^3 + "+(second2RandomizedTerm15)+"x^2 + "+(third2RandomizedTerm15)+ "x + " +(fourth2RandomizedTerm15);

        }
        else if (exponent15 == 3){
            rightAnswer15 = "x^3 + "+(3*C1Y15)+"x^2 + "+(3*C1Y15*C1Y15)+"x + "+(C1Y15*C1Y15*C1Y15);
            incorrect1Answer15 = "x^3 + "+(first1RandomizedTerm15)+"x^2 + "+(second1RandomizedTerm15)+"x + "+(third1RandomizedTerm15);
            incorrect2Answer15 = "x^3 + "+(first2RandomizedTerm15)+"x^2 + "+(second2RandomizedTerm15)+"x + "+(third2RandomizedTerm15);
        }
        else if (exponent15 == 2){
            rightAnswer15 = "x^2 + "+(2*C1Y15)+"x + "+(C1Y15*C1Y15);
            incorrect1Answer15 = "x^2 + "+(first1RandomizedTerm15)+"x + "+(second1RandomizedTerm15);
            incorrect2Answer15 = "x^2 + "+(first2RandomizedTerm15)+"x + "+(second2RandomizedTerm15);
        }
    }

    ////////////////////////////////////question stuff ends

    public static String mathQuestion[] ={ //the questions displayed in the GUI are taken from here
            "Expand and simplify the following equation:\n("+C1X+"x+"+C1Y+") ("+C2X+"x+"+C2Y+")",
            "Expand and simplify the following equation:\n("+C1X2+"x+"+C1Y2+") ("+C2X2+"x+"+C2Y2+")",
            "Expand and simplify the following equation:\n("+C1X3+"x+"+C1Y3+") ("+C2X3+"x+"+C2Y3+")",
            "Expand and simplify the following equation:\n("+C1X4+"x+"+C1Y4+") ("+C2X4+"x+"+C2Y4+")",
            "Expand and simplify the following equation:\n("+C1X5+"x+"+C1Y5+") ("+C2X5+"x+"+C2Y5+")",
            "Factor the following equation:\n"+coefficientX6+"x^2 + "+middleX6+"x + "+ yIntercept6,
            "Factor the following equation:\n"+coefficientX7+"x^2 + "+middleX7+"x + "+ yIntercept7,
            "Factor the following equation:\n"+coefficientX8+"x^2 + "+middleX8+"x + "+ yIntercept8,
            "Factor the following equation:\n"+coefficientX9+"x^2 + "+middleX9+"x + "+ yIntercept9,
            "Factor the following equation:\n"+coefficientX10+"x^2 + "+middleX10+"x + "+ yIntercept10,
            "Expand the following equation:\n(x + "+C1Y11+")^"+exponent11,
            "Expand the following equation:\n(x + "+C1Y12+")^"+exponent12,
            "Expand the following equation:\n(x + "+C1Y13+")^"+exponent13,
            "Expand the following equation:\n(x + "+C1Y14+")^"+exponent14,
            "Expand the following equation:\n(x + "+C1Y15+")^"+exponent15,


    };
    public static String selectChoices[][] = { //this array is where all the text/strings for the multiple-choice buttons is located
            {rightAnswer, incorrect2Answer, incorrect1Answer},
            {incorrect1Answer2, rightAnswer2, incorrect2Answer2},
            {incorrect1Answer3, incorrect2Answer3, rightAnswer3},
            {rightAnswer4, incorrect2Answer4, incorrect1Answer4},
            {rightAnswer5, incorrect1Answer5, incorrect2Answer5},
            {rightAnswer6, incorrect2Answer6, incorrect1Answer6},
            {incorrect1Answer7, rightAnswer7, incorrect2Answer7},
            {incorrect2Answer8, incorrect1Answer8, rightAnswer8},
            {incorrect2Answer9, incorrect1Answer9, rightAnswer9},
            {incorrect2Answer10, incorrect1Answer10, rightAnswer10},
            {incorrect2Answer11, incorrect1Answer11, rightAnswer11},
            {incorrect1Answer12, rightAnswer12, incorrect2Answer12},
            {rightAnswer13, incorrect1Answer13, incorrect2Answer13},
            {rightAnswer14, incorrect1Answer14, incorrect2Answer14},
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
        setContentView(R.layout.activity_test_questioning_page3); // set the .xml file in review to the corresponding test questioning page xml file

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
            Intent intent = new Intent(this, testRecap3.class);
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
