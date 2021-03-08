package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class TP3_Ex1 extends AppCompatActivity {

    private String user_id;
    private EditText user_name;
    private EditText user_firstname;
    private EditText user_age;
    private EditText user_number;
    private EditText user_password_entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p3__ex1);

        user_name = findViewById(R.id.txtName);
        user_firstname = findViewById(R.id.txtFirstName);
        user_age = findViewById(R.id.txtAge);
        user_number = findViewById(R.id.txtNumber);

        if (savedInstanceState == null) {
            setUser_id();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        EditText ETpassword = findViewById(R.id.txtPassword);
        ETpassword.setText("");

        ArrayList<String> data = new ArrayList<>();

        data.add(user_id);
        data.add(user_name.getText().toString());
        data.add(user_firstname.getText().toString());
        data.add(user_age.getText().toString());
        data.add(user_number.getText().toString());

        savedInstanceState.putStringArrayList("data", data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("data")) {
            ArrayList<String> data = savedInstanceState.getStringArrayList("data");
            user_id = data.get(0);
            user_name.setText(data.get(1));
            user_firstname.setText(data.get(2));
            user_age.setText(data.get(3));
            user_number.setText(data.get(4));
        }
    }

    private void setUser_id(){
        user_id = "user_"+Math.round(Math.random()*9999);
    }
}