package com.example.mapremiereappli2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button2).setOnClickListener(v -> { startActivity(new Intent(this, Exercice1.class)); });
        findViewById(R.id.button3).setOnClickListener(v -> { startActivity(new Intent(this, Exercice2.class)); });
        findViewById(R.id.button4).setOnClickListener(v -> { startActivity(new Intent(this, Exercice3.class)); });
        findViewById(R.id.button5).setOnClickListener(v -> { startActivity(new Intent(this, Exercice4.class)); });
        findViewById(R.id.button6).setOnClickListener(v -> { startActivity(new Intent(this, Exercice5.class)); });
        findViewById(R.id.button7).setOnClickListener(v -> { startActivity(new Intent(this, TP1_xml.class)); });
        findViewById(R.id.button8).setOnClickListener(v -> { startActivity(new Intent(this, TP1_java.class)); });
    }
}
