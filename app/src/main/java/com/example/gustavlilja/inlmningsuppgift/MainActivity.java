package com.example.gustavlilja.inlmningsuppgift;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when user presses send button
     */
    public void runCompass(View view) {
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    public void runAcc(View view) {
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }


}
