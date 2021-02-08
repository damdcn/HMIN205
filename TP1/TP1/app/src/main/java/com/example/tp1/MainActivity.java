package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tp1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(v -> { startActivity(new Intent(this, TP1_Ex3_XML.class)); });
        findViewById(R.id.button2).setOnClickListener(v -> { startActivity(new Intent(this, TP1_Ex3_java.class)); });
        findViewById(R.id.button3).setOnClickListener(v -> { startActivity(new Intent(this, TP1_Ex5.class)); });
        findViewById(R.id.button4).setOnClickListener(v -> { startActivity(new Intent(this, TP1_Ex6.class)); });
        findViewById(R.id.button5).setOnClickListener(v -> { startActivity(new Intent(this, TP1_Ex7.class)); });
        findViewById(R.id.button6).setOnClickListener(v -> { startActivity(new Intent(this, TP1_Ex8.class)); });
    }
}
