package com.example.mapremiereappli2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exercice1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("Hello, Android");

        EditText et = new EditText(this);

        LinearLayout mylayout = new LinearLayout(this);
        mylayout.setOrientation(LinearLayout.VERTICAL);
        mylayout.setPadding(20,20,20,20);

        mylayout.addView(tv);
        mylayout.addView(et);

        setContentView(mylayout);
    }

}