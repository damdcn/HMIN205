package com.example.tp2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TP2_Ex3 extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor accelerometre;
    private float sum;
    private boolean color = false;
    private boolean hasCameraFlash;
    private boolean flash = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_p2__ex3);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
            Toast.makeText(this, R.string.ok_accelerometer, Toast.LENGTH_LONG).show();
            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            accelerometre = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            mSensorManager.registerListener((SensorEventListener) this, accelerometre, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, R.string.no_accelerometer, Toast.LENGTH_LONG).show();
        }


        if (ContextCompat.checkSelfPermission(TP2_Ex3.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(TP2_Ex3.this, new String[]{Manifest.permission.CAMERA}, 123);
        } else {
            hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

            toggleFlashCamera();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener((SensorEventListener) this); // unregister sensor
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener) this, accelerometre, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Rien à faire la plupart du temps
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Récupérer les valeurs du capteur
        float x, y, z;
        float lastSum = sum;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];

            ((TextView)findViewById(R.id.axex)).setText("Axe X: "+x+"m/s^2");
            ((TextView)findViewById(R.id.axey)).setText("Axe Y: "+y+"m/s^2");
            ((TextView)findViewById(R.id.axez)).setText("Axe Z: "+z+"m/s^2");

            sum = x+y+z;

            if(lastSum!=sum){
                toggleBgColor();
                toggleFlashCamera();
            }

        }
    }

    @SuppressLint("ResourceAsColor")
    public void toggleBgColor(){
        LinearLayout ll = findViewById(R.id.LLex3);
        if(color){
            ll.setBackgroundColor(R.color.purple_200);
        } else {
            ll.setBackgroundColor(R.color.teal_200);
        }
        color = !color;
    }

    public void toggleFlashCamera(){
        if(hasCameraFlash){
            CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            if(flash){ // flash allumé
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], true);
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            } else { // flash eteint
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], false);
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        flash = !flash;
    }
}