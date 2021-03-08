package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.widget.TextView;

public class TP3_Ex4_2_Planning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p3__ex4_2__planning);

        PlanningModel pm = new PlanningModel();

        String title = "Planning :\n";

        String data = this.getResources().getString(R.string.time_1) + " : " + pm.getTask1() + "\n";
        data += this.getResources().getString(R.string.time_2) + " : " + pm.getTask2() + "\n";
        data += this.getResources().getString(R.string.time_3) + " : " + pm.getTask3() + "\n";
        data += this.getResources().getString(R.string.time_4) + " : " + pm.getTask4();

        TextView tv = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);

        tv.setText(title);
        tv2.setText(data);

    }
}

class PlanningModel extends ViewModel {
    private String task1 = "Rencontre client Dupont";
    private String task2 = "Travailler le dossier recrutement";
    private String task3 = "Réunion équipe";
    private String task4 = "Préparation dossier vente";

    public String getTask1(){
        return task1;
    }

    public String getTask2(){
        return task2;
    }

    public String getTask3(){
        return task3;
    }

    public String getTask4(){
        return task4;
    }
}