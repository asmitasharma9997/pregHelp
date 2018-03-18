package com.example.lenovo.preghelp;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.vision.text.TextRecognizer;


public class camcheck extends AppCompatActivity {

    Button btnpic,b1;
    ImageView imgTakenPic;
    private static final int CAM_REQUEST=1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camcheck);

        btnpic = (Button) findViewById(R.id.button);
        imgTakenPic = (ImageView)findViewById(R.id.imageView);
        btnpic.setOnClickListener(new btnTakePhotoClicker());
        b1= (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(camcheck.this,output.class);
                startActivity(intent);
            }
        });
    }

//    public void getTextfromImage(View v)
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgTakenPic.setImageBitmap(bitmap);
        }
    }

class btnTakePhotoClicker implements  Button.OnClickListener{

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAM_REQUEST);
    }
}

}