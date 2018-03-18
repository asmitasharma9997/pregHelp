package com.example.lenovo.preghelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class output extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        tv1=(TextView)findViewById(R.id.textView25);

        tv1.setText("HCQS " + "\n" + "The symptoms are :-"+ "\n"+ "1. arithritis" + "\n" +"2. type 2 diabetes" + "\n\n"+ "The side effects are :-" + "\n" +"1. headache" + "\n" + "2.diarrhoea" + "\n" + "3. mood swings");
    }
}
