package com.example.appbase;
package com.firebasedatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements SensorEventListener {


        private static final String TAG = "MainActivity";

        private SensorManager sensorManager;
        Sensor accelerometer;

        TextView xValue, yValue, zValue;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);

        Log.d(TAG, "onCreate : Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered accelerometer listener");
    }

        @Override
        public void onAccuracyChanged (Sensor sensor,int i){

    }
,
        @Override
        public void onSensorChanged (SensorEvent sensorEvent){
        Log.d(TAG, "onSensorChanged: X:" + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]);
        xValue.setText("xvalue:" + sensorEvent.values[0]);
        yValue.setText("yvalue:" + sensorEvent.values[1]);
        zValue.setText("zvalue:" + sensorEvent.values[2]);

        locationrequest = LocationRequest.create();
        locationrequest.setInterval(1000);
        loationclient.requestLocationUpdates(locationrequest,new com.google.android.gms.location.LocationListener());


        try {
            if(sensorEvent.values[0]/9>=1.5 ||sensorEvent.values[1]/9>=1.5||sensorEvent.values[2]/9>=1.5) {

            }
            if(sensorEvent.values[0]/9>=3 || sensorEvent.values[0]/9>=3 || sensorEvent.values[0]/9>=3){
                URL url = new URL("https://herohack1.herokuapp.com/?number=+91801062552&lat=?&long=?");

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                String str = in.readLine();
                System.out.println(str);
            }
    }
        catch(MalformedURLException e){}
        catch(IOException e){}
    }

 }