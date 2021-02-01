package com.example.mapremiereappli2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Exercice4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice4);

        Button long_button = findViewById(R.id.button3);
        long_button.setOnLongClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Ceci est un message Toast", Toast.LENGTH_LONG).show();
            return true;
        });
    }

    public void onClickToast(View v) {
        Toast.makeText(this, "Ceci est un message Toast", Toast.LENGTH_LONG).show();
    }

    public void onClickSecret(View v) {
        TextView text = findViewById(R.id.txt_cache);
        Button btn = findViewById(R.id.button2);
        if(text.getVisibility() == View.VISIBLE){
            text.setVisibility(View.INVISIBLE);
            btn.setText("Afficher");
        } else {
            text.setVisibility(View.VISIBLE);
            btn.setText("Cacher");
        }
    }


}