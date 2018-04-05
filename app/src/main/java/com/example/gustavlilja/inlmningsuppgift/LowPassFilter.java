package com.example.gustavlilja.inlmningsuppgift;

/**
 * Created by gustavlilja on 2018-04-05.
 */

/**
 * This is a lowpassfilter used in the accelerometer
 *
 * @see //http://www.java2s.com/Open-Source/Android_Free_Code/Sensor/compass/com_jwetherell_compass_commonLowPassFilter_java.htm
 */
public class LowPassFilter {

    public static final float ALPHA = 0.2f;

    public LowPassFilter() {

    }

    public static float[] filter(float[] input, float[] output) {
        if (input == null || output == null) {
            throw new NullPointerException("input and output float arrays must be non-Null");
        }
        if (input.length != output.length) {
            throw new IllegalArgumentException("Input and output must be the same length");
        }

        for (int i = 0; i < input.length; i++) {
            output[i] = output[i] + ALPHA * (input[i] - output[i]);
        }
        return output;
    }

}
