package com.example.lenovo.preghelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.lenovo.preghelp.Track_medicine.flag;

public class Camera2 extends AppCompatActivity {
    TextView tv1;
    Button b1;
    ImageView img;
//    private static final int CAM_REQUEST=1313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);

//        final String flag1=getIntent().getStringExtra(flag);

        tv1=(TextView)findViewById(R.id.textView2);
//        b1=(Button)findViewById(R.id.button);
//        img=(ImageView)findViewById(R.id.imageView2);

        tv1.setText("hello");
    }
}
