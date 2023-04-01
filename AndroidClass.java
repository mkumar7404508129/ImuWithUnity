package com.example.extraunity;
//import com.epson.moverio.hardware.sensor.SensorDataListener;
//import com.epson.moverio.hardware.sensor.SensorData;
//import com.epson.moverio.hardware.sensor.SensorManager;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import android.util.Log;

import com.epson.moverio.hardware.sensor.SensorData;
import com.epson.moverio.hardware.sensor.SensorDataListener;
import com.epson.moverio.hardware.sensor.SensorManager;

public class AndroidClass implements SensorDataListener {
//    android.hardware.SensorManager mSensorManager;
    Context context ;
//    private Callback callback;
//    public int stationary=0;
//    String TAG="AnndroiUnity";
//    Sensor accelerometer;
//    public AndroidClass(Activity activity, Callback callback) {
//        this.callback = callback;
//        Context context= activity.getApplicationContext();
//        mSensorManager = (android.hardware.SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
//        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
//        Log.i(TAG,"Constructur called");
//        mSensorManager.registerListener(this, accelerometer, android.hardware.SensorManager.SENSOR_DELAY_NORMAL);
//    }
//    @Override
//    public void onSensorChanged(SensorEvent sensorEvent) {
//            triggerCallback(sensorEvent.values,sensorEvent.sensor.getType(), stationary);
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int i) {
//
//    }
    String TAG="AnndroiUnity";
    public int stationary=0;
    SensorManager mSensorManager = null;
    private Callback callback;
    public AndroidClass(Activity activity, Callback callback) {
        this.callback = callback;
        Context context= activity.getApplicationContext();
        mSensorManager= new SensorManager(context);
        open();
        Log.i(TAG,"Constructur called");
    }
    public void triggerCallback(float array[],int type,int stationary) {
        callback.onCallback( array, type,stationary);
    }
    @Override
    public void onSensorDataChanged(SensorData sensorData) {
        Log.i(TAG,"Sensor data getting");
        triggerCallback(sensorData.values,sensorData.type,stationary);

    }
    public boolean open(){

        if(mSensorManager!=null){
            try {

                mSensorManager.open(SensorManager.TYPE_ROTATION_VECTOR,this);
//                mSensorManager.open(SensorManager.TYPE_LINEAR_ACCELERATION,this);
                mSensorManager.open(SensorManager.TYPE_GYROSCOPE,this);
//                mSensorManager.open(SensorManager.TYPE_ACCELEROMETER,this);
                Log.i(TAG,"Sensor Started");
                return  true;
            }
            catch (Exception e){
                return  false;
            }

        }
        return false;
    }
}
