package com.example.mapremiereappli2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Exercice5 extends AppCompatActivity {

    private CheckBox linux, macos, windows;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5);
        addListenerOnChkWindows();addListenerOnButton();
    }

    public void addListenerOnChkWindows() {
        windows = findViewById(R.id.windows_option);
        windows.setOnClickListener(v -> {
            if (((CheckBox) v).isChecked()) {
                Toast.makeText(Exercice5.this,"Bro, try Linux :)", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addListenerOnButton() {
        linux = findViewById(R.id.linux_option);
        macos = findViewById(R.id.macos_option);
        windows = findViewById(R.id.windows_option);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            StringBuffer result = new StringBuffer();
            result.append("Linux check : ").append(linux.isChecked());
            result.append("\nMac OS check : ").append(macos.isChecked());
            result.append("\nWindows check :").append(windows.isChecked());
            Toast.makeText(Exercice5.this, result.toString(), Toast.LENGTH_LONG).show();
        });
    }
}