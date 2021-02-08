package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TP1_Ex7_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p1__ex6_2);


        Intent myIntent = getIntent();
        String name = myIntent.getStringExtra("name");
        String firstname = myIntent.getStringExtra("firstname");
        String email = myIntent.getStringExtra("email");
        String number = myIntent.getStringExtra("number");

        TextView tv1 = findViewById(R.id.tvName);
        TextView tv2 = findViewById(R.id.tvFirstname);
        TextView tv3 = findViewById(R.id.tvEmail);
        TextView tv4 = findViewById(R.id.tvNumber);

        tv1.setText(name.equals("") ? "none" : name);
        tv2.setText(firstname.equals("") ? "none" : firstname);
        tv3.setText(email.equals("") ? "none" : email);
        tv4.setText(number.equals("") ? "none" : number);


        findViewById(R.id.btnOk).setOnClickListener(v -> {
            Intent i = new Intent(this, TP1_Ex7_3.class);
            i.putExtra("number", number);
            startActivity(i);
        });

        findViewById(R.id.btnBack).setOnClickListener(v -> {
            this.finish();
        });



    }
}