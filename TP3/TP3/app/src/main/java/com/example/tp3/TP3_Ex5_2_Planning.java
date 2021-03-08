package com.example.tp3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

public class TP3_Ex5_2_Planning extends AppCompatActivity {

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

        AlarmManager mAlarmManger = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, MyAlarmReceiver.class);
        intent.putExtra("uur", "1e"); // if you want
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        mAlarmManger .set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

    }
}

class PlanningModel2 extends ViewModel {

    private MutableLiveData<String> task1;
    private MutableLiveData<String> task2;
    private MutableLiveData<String> task3;
    private MutableLiveData<String> task4;

    public PlanningModel2() {
        task1 = new MutableLiveData<String>();
        task2 = new MutableLiveData<String>();
        task3 = new MutableLiveData<String>();
        task4 = new MutableLiveData<String>();
        task1.setValue("Rencontre client Dupont");
        task2.setValue("Travailler le dossier recrutement");
        task3.setValue("Réunion équipe");
        task4.setValue("Préparation dossier vente");

    }

    public MutableLiveData<String> getTask1(){
        return task1;
    }
    public MutableLiveData<String> getTask2(){
        return task2;
    }
    public MutableLiveData<String> getTask3(){
        return task3;
    }
    public MutableLiveData<String> getTask4(){
        return task4;
    }

    public void setTask1(String t){ task1.setValue(t);}
    public void setTask2(String t){ task2.setValue(t);}
    public void setTask3(String t){ task3.setValue(t);}
    public void setTask4(String t){ task4.setValue(t);}
}

class MyAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // faire une tâche
    }

    private String readFromFile(Context context, String filename) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(filename);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("Exception", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Exception", "Can not read file: " + e.toString());
        }

        return ret;
    }
}