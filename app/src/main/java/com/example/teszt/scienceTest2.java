package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class scienceTest2 extends AppCompatActivity {
    ///////an explanation for similar code is located in the "mathTest1.java" file
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_test2);

        proceedButton = (Button) findViewById(R.id.button2);

        proceedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, scienceTestQuestioningPage2.class);
        if (MainActivity.scienceUnit2TestDone == 0) {
            startActivity(intent);
        }
        else{
            proceedButton.setText("Begin a new session to try this test again!");
        }
    }


}