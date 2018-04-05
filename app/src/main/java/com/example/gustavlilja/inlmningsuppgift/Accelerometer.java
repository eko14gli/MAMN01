package com.example.gustavlilja.inlmningsuppgift;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import static android.view.KeyCharacterMap.ALPHA;

/**
 * @see //https://www.youtube.com/watch?v=YrI2pCZC8cc
 */
public class Accelerometer extends Activity implements SensorEventListener {
    private TextView xView, yView, zView;
    private Sensor mySensor;
    private SensorManager SM;
    private LowPassFilter lowPassFilter;
    static final float ALPHA = 0.25f;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        // Create our SensorManager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register our sensor listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextViews
        xView = (TextView)findViewById(R.id.xView);
        yView = (TextView)findViewById(R.id.yView);
        zView = (TextView)findViewById(R.id.zView);
    }

    // Low-pass filter for accelerometer
    protected float[] lowPassAcc( float[] input, float[] output ) {
        if (output == null) {
            return input;
        }
        for (int i = 0; i<input.length; i++) {
            output[i] = output[i] + ALPHA * (input[i] - output [i]);
        }
        return output;
    }

    // xView, yView and zView are the coordinates shown on the display
    @Override
    public void onSensorChanged(SensorEvent event) {

        lowPassFilter = new LowPassFilter();
        float[] output;
        output = lowPassFilter.filter(event.values.clone(), event.values);


        xView.setText("X: " + output[0]);
        yView.setText("Y: " + output[1]);
        zView.setText("Z: " + output[2]);

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }



}
