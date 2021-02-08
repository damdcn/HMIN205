package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TP1_Ex3_java extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView name_nom = new TextView(this);
        name_nom.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        TextView name_prenom = new TextView(this);
        name_prenom.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        TextView name_email = new TextView(this);
        name_email.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        TextView name_mdp = new TextView(this);
        name_mdp.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        name_nom.setText(R.string.form_name);
        name_prenom.setText(R.string.form_firstname);
        name_email.setText(R.string.form_email);
        name_mdp.setText(R.string.form_password);

        EditText et1 = new EditText(this);
        EditText et2 = new EditText(this);
        EditText et3 = new EditText(this);
        EditText et4 = new EditText(this);

        Button validate = new Button(this);
        validate.setText(R.string.form_confirm);
        validate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        LinearLayout mylayout = new LinearLayout(this);
        mylayout.setOrientation(LinearLayout.VERTICAL);
        mylayout.setPadding(20,20,20,20);

        mylayout.addView(name_nom);
        mylayout.addView(et1);
        mylayout.addView(name_prenom);
        mylayout.addView(et2);
        mylayout.addView(name_email);
        mylayout.addView(et3);
        mylayout.addView(name_mdp);
        mylayout.addView(et4);
        mylayout.addView(validate);

        setContentView(mylayout);
    }
}