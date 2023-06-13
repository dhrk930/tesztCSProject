package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class mathTest1 extends AppCompatActivity {

    private Button proceedButton; //declare the proceed button gui variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_test1);

        //set the gui variable to the actual proceed button that exists in this file's .xml file
        proceedButton = (Button) findViewById(R.id.button2);

        // set an onClickListener function for this proceed button
        proceedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            } //if this button is clicked, open this function
        });

    }

    public void openActivity2(){ //this is opened if the proceed button is clicked
        Intent intent = new Intent(this, testQuestioningPage.class);
        if (MainActivity.unit1TestDone == 0) { //if the variable equals 0 (Means that the user has not done this test yet), open the test
            startActivity(intent);
        }
        else{ //otherwise, tell the user to begin a new session by setting the text of the button to the text below
            proceedButton.setText("Begin a new session to try this test again!");
        }
    }


}