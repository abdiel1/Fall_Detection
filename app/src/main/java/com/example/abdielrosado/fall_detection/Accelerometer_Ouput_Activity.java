package com.example.abdielrosado.fall_detection;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Accelerometer_Ouput_Activity extends Activity implements SensorEventListener{
    private SensorManager sensorManager;
    private Sensor sensor;
    private static boolean sensorOn = false;
    private TextView textView;
    private  File file;
    private File path;
    private StringBuffer stringBuffer;
    private long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer__ouput_);
        textView = (TextView) findViewById(R.id.textView);


        path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        file = new File(path, "FallDetectionData.txt");


        stringBuffer = new StringBuffer();



        //Sensor setup
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void onClickStart(View view){
        sensorOn = true;
        stringBuffer.delete(0, stringBuffer.length());
        time = System.currentTimeMillis();
        try{
            textView.setText(file.getCanonicalPath());
        } catch (IOException e){
            textView.setText(e.getLocalizedMessage());
        }



    }

    public void onClickStop(View view){
        sensorOn = false;
        textView.setText("stoped");

        BufferedWriter bufferedWriter;
        try{
            path.mkdir();
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.close();

        } catch (IOException e){
            textView.setText(e.getLocalizedMessage());
        }

    }

     @Override
     public final void onAccuracyChanged(Sensor sensor,int accuracy){

     }

    @Override
    public final void onSensorChanged(SensorEvent event){
        if(sensorOn){
            printValues(event.values[0], event.values[1], event.values[2]);

        }
    }

    private void printValues(Float x, Float y, Float z){
        stringBuffer.append(System.currentTimeMillis() - time + "," + x.toString() + "," + y.toString() + "," + z.toString() + "\n");

    }


}
