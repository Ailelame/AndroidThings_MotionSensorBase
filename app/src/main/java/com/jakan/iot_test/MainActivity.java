package com.jakan.iot_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;



public class MainActivity extends Activity implements MotionSensor.Listener{
    private static final String TAG = "ButtonActivity";
    private static final String MOTION_SENSOR_PIN_NAME = "BCM4"; // GPIO port wired to the button
    private static final String LED_PIN_NAME = "BCM6"; // GPIO port wired to the button

    private Gpio ledGpio;
    private PirMotionSensor motionSensor;
    PeripheralManager peripheralManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Initialization du programme. Bienvenue dans la matrice ");

        startGPIO();

    }

    private void startGPIO(){
        peripheralManager = PeripheralManager.getInstance();
        try {
            ledGpio = peripheralManager.openGpio(LED_PIN_NAME);
        } catch (IOException e) {
            Log.e(TAG, "Error on PeripheralIO API", e);
        }
        LedManagement.turnLedOn(ledGpio);

        Gpio motionSensorGpioBus = null;
        try {
            motionSensorGpioBus = PeripheralManager.getInstance().openGpio(MOTION_SENSOR_PIN_NAME);
        } catch (IOException e) {
            throw new IllegalStateException("Can't open GPIO - can't create app.", e);
        }
        motionSensor = new PirMotionSensor(motionSensorGpioBus, this);
        motionSensor.startup();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onMovement() {
        Log.d("Motion Sensor","motion detected");
    }
}