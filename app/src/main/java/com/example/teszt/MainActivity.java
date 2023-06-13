package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //gui button variable declared
    public static Button button;

    //all the variables below will be added to in the event that the user completes a certain test. For example, if the user finishes math test Unit 1, the unit1TestDone variable will be added to so that the user can't redo this same math test in the same session
    public static int unit1TestDone = 0;
    public static int unit2TestDone = 0;
    public static int unit3TestDone = 0;
    public static int unit4TestDone = 0;
    public static int unit5TestDone = 0;
    public static int unit6TestDone = 0;
    public static int scienceUnit1TestDone = 0;
    public static int scienceUnit2TestDone = 0;
    public static int scienceUnit3TestDone = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //sets the .xml file in regard to this .java file's corresponding .xml file



        button = (Button) findViewById(R.id.button); //sets the button variable from this file to the actual button GUI element that exists in this file's corresponding .xml file

        //set an onClickListener function for this button
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            } // open this method if the button is clicked
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent); //open the intent initialized above which opens the main page where the user can select their subject, etc
    }

    @Override
    public void onBackPressed(){
        return;
    } //disables the back button on this page only
}