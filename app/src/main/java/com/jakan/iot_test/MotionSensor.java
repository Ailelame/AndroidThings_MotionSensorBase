package com.jakan.iot_test;

public interface MotionSensor {
    void startup();

    void shutdown();

    interface Listener {
        void onMovement();
    }

}
