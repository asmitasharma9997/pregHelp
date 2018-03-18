package com.example.lenovo.preghelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private final int REQ_CODE_SPEECH_INPUT = 100;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 98;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alert(View view) {
        Intent intent = new Intent(MainActivity.this, alert.class);
        startActivity(intent);
    }

    public void track(View view) {
        Intent intent = new Intent(MainActivity.this, Track_medicine.class);
        startActivity(intent);
    }

    public void diet(View view) {
        Intent intent = new Intent(MainActivity.this, dietplanner.class);
        startActivity(intent);
    }
    public void task(View view) {
        Intent intent = new Intent(MainActivity.this, taskscheduler.class);
        startActivity(intent);
    }

}
