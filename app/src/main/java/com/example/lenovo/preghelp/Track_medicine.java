package com.example.lenovo.preghelp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.CardView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class Track_medicine extends AppCompatActivity {


    Button b1;
    Button b2;
    TextView tv1;
    public static final String flag="0";
//    CardView CardView1, CardView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_medicine);


        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button1);
        tv1=(TextView)findViewById(R.id.textView1);
    //    CardView1=(CardView)findViewById(R.id.CardView1);
      //  CardView2=(CardView)findViewById(R.id.CardView2);



        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Track_medicine.this,speak.class);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Track_medicine.this, camcheck.class);

                startActivity(intent);

            }
        });
    }



}
