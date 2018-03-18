package com.example.lenovo.preghelp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import static com.example.lenovo.preghelp.Track_medicine.flag;

public class cameracapture extends AppCompatActivity {


    Button btnpic;
    ImageView imgTakenPic;
    private static final int CAM_REQUEST=1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpic = (Button) findViewById(R.id.button);
        imgTakenPic = (ImageView)findViewById(R.id.imageView2);

        btnpic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent,CAM_REQUEST);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);

            }
        });

    }

   //


//        public void getTextfromImage(View v)
//    {
//        Bitmap bitmap= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.hcs);
//
//        TextRecognizer textRecognizer=new TextRecognizer.Builder(getApplicationContext()).build();
//
//        tv1.setText(" ");
//        if(!textRecognizer.isOperational())
//        {
//            Toast.makeText(getApplicationContext(),"could not find image",Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Frame frame=new Frame.Builder().setBitmap(bitmap).build();
//
//            SparseArray<TextBlock> items= textRecognizer.detect(frame);
//
//            StringBuilder sb=new StringBuilder();
//
//            for(int i=0; i<items.size();++i)
//            {
//                TextBlock myItem=items.valueAt(i);
//                sb.append(myItem.getValue());
//                sb.append("\n");
//            }
//
//            tv1.setText(sb.toString());
//        }
//
//    }
}

