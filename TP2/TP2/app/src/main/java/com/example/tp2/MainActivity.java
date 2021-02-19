package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(v -> { startActivity(new Intent(this, TP2_Ex1.class)); });
        findViewById(R.id.button2).setOnClickListener(v -> { startActivity(new Intent(this, TP2_Ex3.class)); });
        //findViewById(R.id.button3).setOnClickListener(v -> { startActivity(new Intent(this, TP2_Ex6.class)); });
        //findViewById(R.id.button4).setOnClickListener(v -> { startActivity(new Intent(this, TP2_Ex4.class)); });
        //findViewById(R.id.button5).setOnClickListener(v -> { startActivity(new Intent(this, TP2_Ex5.class)); });
        //findViewById(R.id.button6).setOnClickListener(v -> { startActivity(new Intent(this, TP2_Ex6.class)); });
    }
}