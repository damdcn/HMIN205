package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TP2_Ex1 extends AppCompatActivity {


    SensorManager sensorManager;
    List<Sensor> sensorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice1);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        listSensor();
    }

    private void listSensor() {
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuffer sensorDesc = new StringBuffer();
        for (Sensor sensor : sensors) {
            sensorDesc.append("New sensor detected : \r\n");
            sensorDesc.append("\tName: " + sensor.getName() + "\r\n\n");
            //sensorDesc.append("\tType: " + sensor.getType() + "\r\n");
            //sensorDesc.append("Version: " + sensor.getVersion() + "\r\n");
            //sensorDesc.append("Resolution (in the sensor unit): " + sensor.getResolution() + "\r\n");
            //sensorDesc.append("Power in mA used by this sensor while in use" +  sensor.getPower() +"\r\n");
            //sensorDesc.append("Vendor: " + sensor.getVendor() + "\r\n");
            //sensorDesc.append("Maximum range of the sensor in the sensor's unit." +  sensor.getMaximumRange() + "\r\n");
            //sensorDesc.append("Minimum delay allowed between two events in  microsecond " + " or zero if this sensor only returns a  value when the data it's measuring changes " +  sensor.getMinDelay() + "\r\n");
        }
        TextView tv = findViewById(R.id.sensorList);

        tv.setText(sensorDesc);
    }
}