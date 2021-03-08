package com.example.tp3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TP3_Ex4 extends AppCompatActivity {

    private Utilisation use;

    private String user_id;
    private EditText user_name;
    private EditText user_firstname;
    private EditText user_age;
    private EditText user_number;
    private EditText user_password_entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p3__ex4);

        use = new Utilisation();
        getLifecycle().addObserver(use);

        user_name = findViewById(R.id.txtName);
        user_firstname = findViewById(R.id.txtFirstName);
        user_age = findViewById(R.id.txtAge);
        user_number = findViewById(R.id.txtNumber);

        if (savedInstanceState == null) {
            setUser_id();
        }

        findViewById(R.id.btnSubmit).setOnClickListener(v -> {
            String data = this.getResources().getString(R.string.usage)+" : "+this.use.NombreUtilisation()+"\n";
            if(!user_id.isEmpty()){
                data += "ID : "+user_id+"\n";
                if(!user_name.getText().toString().isEmpty()) data += this.getResources().getString(R.string.form_name)+" : "+user_name.getText().toString()+"\n";
                if(!user_firstname.getText().toString().isEmpty()) data += this.getResources().getString(R.string.form_firstname)+" : "+user_firstname.getText().toString()+"\n";
                if(!user_age.getText().toString().isEmpty()) data += this.getResources().getString(R.string.form_age)+" : "+user_age.getText().toString()+"\n";
                if(!user_number.getText().toString().isEmpty()) data += this.getResources().getString(R.string.form_number)+" : "+user_number.getText().toString()+"\n";
            }
            writeToFile(data, this);

            Intent i = new Intent(this, TP3_Ex2_2.class);
            startActivity(i);
        });

        findViewById(R.id.btnPlanning).setOnClickListener(v -> {
            Intent i = new Intent(this, TP3_Ex4_2_Planning.class);
            startActivity(i);
        });
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

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}