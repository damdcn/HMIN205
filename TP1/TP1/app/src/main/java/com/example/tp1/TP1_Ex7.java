package com.example.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class TP1_Ex7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p1__ex7);


        findViewById(R.id.btnSubmit).setOnClickListener(v -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(R.string.dialog_title);
            builder.setMessage(R.string.dialog_message);
            builder.setPositiveButton(R.string.form_confirm,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), R.string.dialog_positive, Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), TP1_Ex7_2.class);
                            EditText e1 = findViewById(R.id.txtName);
                            EditText e2 = findViewById(R.id.txtFirstname);
                            EditText e3 = findViewById(R.id.txtEmail);
                            EditText e4 = findViewById(R.id.txtNumber);
                            i.putExtra("name", e1.getText().toString());
                            i.putExtra("firstname", e2.getText().toString());
                            i.putExtra("email", e3.getText().toString());
                            i.putExtra("number", e4.getText().toString());
                            startActivity(i);
                        }
                    }
            );
            builder.setNegativeButton(R.string.form_cancel,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), R.string.dialog_negative, Toast.LENGTH_LONG).show();
                        }
                    }
            );

            builder.show();
        });




    }
}