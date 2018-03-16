package com.example.lenovo.preghelp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        getMenuInflater().inflate(R.menu.menu1,menu1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.dietplanner:
            {
                Intent intent = new Intent(MainActivity.this,taskscheduler.class);

                startActivity(intent);
                return true;
            }
            case R.id.task_schedule:
            {
                Intent intent = new Intent(MainActivity.this,dietplanner.class);

                startActivity(intent);

                return true;
            }
            case R.id.med_track:
            {
                Intent intent = new Intent(MainActivity.this,Track_medicine.class);
                startActivity(intent);

                return true;
            }
            case R.id.alert:
            {
                Intent intent = new Intent(MainActivity.this,alert.class);
                startActivity(intent);

                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
