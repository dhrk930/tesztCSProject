package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mathPage extends AppCompatActivity {

    //gui variables declared below
    private Button test1;
    private Button test2;
    private Button test3;
    private Button test4;
    private Button test5;
    private Button test6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_page);


        //below, the gui variables are set to the gui elements that exist in this file's .xml file and an onClickListener function is set for each GUI button/element
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

        test4 = (Button) findViewById(R.id.test4);
        test4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity5();
            }
        });

        test5 = (Button) findViewById(R.id.test5);
        test5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity6();
            }
        });

        test6 = (Button) findViewById(R.id.test6);
        test6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity7();
            }
        });
    }

    //each method below opens a different test page/activity respectively
    public void openActivity2(){
        Intent intent = new Intent(this, mathTest1.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, mathTest2.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this, mathTest3.class);
        startActivity(intent);
    }

    public void openActivity5(){
        Intent intent = new Intent(this, mathTest4.class);
        startActivity(intent);
    }

    public void openActivity6(){
        Intent intent = new Intent(this, mathTest5.class);
        startActivity(intent);
    }

    public void openActivity7(){
        Intent intent = new Intent(this, mathTest6.class);
        startActivity(intent);
    }
}