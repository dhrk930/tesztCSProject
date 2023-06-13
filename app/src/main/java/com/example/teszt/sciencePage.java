package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sciencePage extends AppCompatActivity {

    ///////////////an explanation of this code is located in the "mathPage.java" file - it's the same code hence no reason to repeat the same comments here
    private Button test1;
    private Button test2;
    private Button test3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_page);

        test1 = (Button) findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
        test2 = (Button) findViewById(R.id.test2);
        test2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });

        test3 = (Button) findViewById(R.id.test3);
        test3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity4();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, scienceTest1.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, scienceTest2.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this, scienceTest3.class);
        startActivity(intent);
    }


}