package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TP1_Ex8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p1__ex8);


        String ville1 = "Montpellier";
        String ville2 = "Paris";
        String ville3 = "Lyon";

        String h1 = "1h00 - 3h00";
        String h2 = "14h00 - 18h30";
        String h3 = "12h00 - 13h15";
        String h4 = "9h00 - 15h00";
        String h5 = "13h00 - 16h00";

        Itineraire i1 = new Itineraire(ville1, ville2, h1);
        Itineraire i2 = new Itineraire(ville2, ville3, h3);
        Itineraire i3 = new Itineraire(ville1, ville3, h1);
        Itineraire i4 = new Itineraire(ville3, ville2, h2);
        Itineraire i5 = new Itineraire(ville3, ville1, h5);
        Itineraire i6 = new Itineraire(ville2, ville1, h4);


        String[] cities={ville1,ville2,ville3};
        Itineraire[] data = {i1,i2,i3,i4,i5,i6};

        Spinner spin1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,cities);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(aa);
        spin2.setAdapter(aa);

        findViewById(R.id.btnTrain).setOnClickListener(v -> {
            TextView res = (TextView) findViewById(R.id.tvResult);
            String v1 = spin1.getSelectedItem().toString();
            String v2 = spin2.getSelectedItem().toString();
            String result = "";
            for (Itineraire i: data) {
                if(i.depart.equals(spin1) && i.arrivee.equals(spin2)){
                    result += i.horaires;
                    result += "\n";
                }
            }
            res.setText(result);

        });



    }
}


class Itineraire {
    public String depart;
    public String arrivee;
    public String horaires;

    public Itineraire (String d, String a, String h){
        this.arrivee = a;
        this.depart = d;
        this.horaires = h;
    }
}