package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class mathTest3 extends AppCompatActivity {
    ///////an explanation for the code is located in the "mathTest1.java" file
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_test3);

        proceedButton = (Button) findViewById(R.id.button2);

        proceedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, testQuestioningPage3.class);
        if (MainActivity.unit3TestDone==0) {
            startActivity(intent);
        }
        else{
            proceedButton.setText("Begin a new session to try this test again!");
        }
    }
}