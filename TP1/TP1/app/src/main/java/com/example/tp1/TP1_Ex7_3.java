package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class TP1_Ex7_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p1__ex7_3);

        Intent myIntent = getIntent();
        String number = myIntent.getStringExtra("number");

        TextView tv = findViewById(R.id.tvNumber2);

        tv.setText(number.equals("") ? "none" : number);


        findViewById(R.id.btnCall).setOnClickListener(v -> {

            if (ContextCompat.checkSelfPermission(TP1_Ex7_3.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(TP1_Ex7_3.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+number));
                startActivity(i);
            }
        });
    }
}