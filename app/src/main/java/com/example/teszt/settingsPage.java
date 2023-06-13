package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settingsPage extends AppCompatActivity {

    /////////////////an explanation of a similar page (In terms of the code) to this is located in the "mathPage.java" file
    private Button button8;

    private Button button3;

    private Button startNewSessionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        button8 = (Button) findViewById(R.id.button8);

        startNewSessionButton = findViewById(R.id.button7);

        button3 = (Button) findViewById(R.id.button3);

        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });

        startNewSessionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity4();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, appInfoPage.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, performanceRecapPage.class);
        startActivity(intent);
    }

    public void openActivity4(){
        startNewSessionButton.setText("Close the app in the background and reopen it!"); //if the reset progress button is clicked, set the button's text to this

    }

}