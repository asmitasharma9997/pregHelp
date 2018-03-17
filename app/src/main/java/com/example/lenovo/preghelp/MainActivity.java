package com.example.lenovo.preghelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alert(View view) {
        Intent intent = new Intent(this, alert.class);
        startActivity(intent);
    }

    public void track(View view) {
        Intent intent = new Intent(this, Track_medicine.class);
        startActivity(intent);
    }

    public void dietplaner(View view) {
        Intent intent = new Intent(this, dietplanner.class);
        startActivity(intent);
    }

    public void task(View view) {
        Intent intent = new Intent(this, taskscheduler.class);
        startActivity(intent);
    }

}
