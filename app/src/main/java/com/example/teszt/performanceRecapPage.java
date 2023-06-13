package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.lang.Math;

public class performanceRecapPage extends AppCompatActivity {

    //the two variables below will be assigned to the GUI elements that exist in this file's corresponding .xml file
    public static TextView mathPerformance;

    public static TextView sciencePerformance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_recap_page); //set the GUI file we're looking at to activity_performance_recap_page.xml

        //the two lines of code below set the aforementioned textview elements to the GUI elements that exist in this file's corresponding .xml file
        mathPerformance = (TextView) findViewById(R.id.mathPerformance);
        sciencePerformance = (TextView) findViewById(R.id.sciencePerformance);

        //sets the math and science averages located in the "user" instance of the class "newStudent" to their proper values
        mainPage.user.setMathAverage();
        mainPage.user.setScienceAverage();

        //the two lines of code below set the GUI textview elements that exist in this .java file's corresponding .xml file to the math/science averages retrieved from the "user" instance using the get methods
        mathPerformance.setText("Math:\n~" + mainPage.user.getMathAverage() + "%");
        sciencePerformance.setText("Science:\n~" + mainPage.user.getScienceAverage() + "%");
    }
}