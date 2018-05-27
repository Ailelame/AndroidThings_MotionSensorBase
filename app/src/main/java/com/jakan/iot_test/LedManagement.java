package com.jakan.iot_test;

import android.util.Log;

import com.google.android.things.pio.Gpio;

import java.io.IOException;

public class LedManagement  {

    private static final String TAG = LedManagement.class.getSimpleName();

    public static void toggleLed(Gpio led) {
        try {
            led.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            led.setValue(!led.getValue());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void turnLedOn(Gpio led){
        try {
            led.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            led.setValue(true);
            Log.d(TAG, "led"+led.getName()+" was turned on");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void turnLedOff(Gpio led){
        try {
            led.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            led.setValue(false);
            Log.d(TAG, "led"+led.getName()+" was turned on");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
