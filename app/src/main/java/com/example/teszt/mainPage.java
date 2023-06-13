package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainPage extends AppCompatActivity {

    //these three button variables below will be set to the actual GUI buttons that exist in this .java file's corresponding .xml file
    private Button mathButton;
    private Button scienceButton;
    private Button settingsButton;

    //creates an instance of the new student class. This instance will contain the user's math and science averages. Default averages of 0 are assigned as you can see in the arguments below.
    static newStudent user = new newStudent(0, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page); //sets the .xml file in regard to this .java file's corresponding .xml file


        //below, the program sets the buttons variables from this file to the actual button GUI elements that exist in this file's corresponding .xml file
        mathButton = (Button) findViewById(R.id.mathButton);
        scienceButton = (Button) findViewById(R.id.scienceButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);

        //an onclick listener is set for all of the 3 buttons below - if any button is clicked, the onClickListener for that button opens a certain activity
        mathButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            } //for example, this onClickListener opens activity two for the math button
        });

        scienceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity4();
            }
        });


    }

    //this method opens the math page
    public void openActivity2(){
        Intent intent = new Intent(this, mathPage.class); //an intent is initialized which opens the mathPage
        startActivity(intent); //the intent is opened/started
    }

    //this opens the science page
    public void openActivity3(){
        Intent intent = new Intent(this, sciencePage.class);
        startActivity(intent);
    }

    //this opens the settings page
    public void openActivity4(){
        Intent intent = new Intent(this, settingsPage.class);
        startActivity(intent);
    }
}