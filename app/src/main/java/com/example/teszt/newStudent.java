package com.example.teszt;
//a new instance of this class is created every time the user opens the app
//an instance of this class contains the user's math and science averages so they can be shown on the performance recap screen in the settings

public class newStudent {

    //variables
    private double mathAverage;
    private double scienceAverage;

    //constructor
    public newStudent (double a, double b){
        this.mathAverage = a;
        this.scienceAverage = b;
    }

    //get methods
    public double getMathAverage(){
        return mathAverage;
    }

    public double getScienceAverage(){
        return scienceAverage;
    }

    //set methods
    public void setMathAverage(){
        mathAverage = ((double)testQuestioningPage.score + (double)testQuestioningPage2.score + (double)testQuestioningPage3.score + (double)testQuestioningPage4.score + (double)testQuestioningPage5.score + (double)testQuestioningPage6.score)/90*100; //adds up all the test scores and finds the average
        mathAverage = (double)Math.round(mainPage.user.getMathAverage()*100)/100; //rounds to two decimal places
    }

    public void setScienceAverage(){
        scienceAverage = ((double)scienceTestQuestioningPage.score + (double)scienceTestQuestioningPage2.score + (double)scienceTestQuestioningPage3.score)/45*100; //adds up all the scores and finds the average
        scienceAverage = (double)Math.round(mainPage.user.getScienceAverage()*100)/100; //rounds to two decimal places
    }

}
