package com.example.lenovo.preghelp;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class speak extends AppCompatActivity {

    private TextView tx1;
    private TextToSpeech mTTs;
    private EditText mEditText;
    private SeekBar mSeekBarPitch, getmSeekBarSpeed;
    private Button mButtonSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);

        tx1 = (TextView) findViewById(R.id.tv1);

        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener()
        {

            @Override
            public void onInit(int status) {

                if(status == TextToSpeech.SUCCESS)
                {
                    int result = mTTs.setLanguage(Locale.getDefault());

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.e("TTS", "Language not supported");
                    }
                    else
                    {
                        mButtonSpeak.setEnabled(true);
                    }
                }
                else
                {
                    Log.e("TTS", "Initialisation failed");
                }

            }
        });

        mEditText = (EditText) findViewById(R.id.edit_text);
        mSeekBarPitch = (SeekBar) findViewById(R.id.seek_bar_pitch);
        getmSeekBarSpeed = (SeekBar) findViewById(R.id.seek_bar_speed);
        mButtonSpeak = (Button) findViewById(R.id.button2);

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                speak();
            }
        });


    }

    public void speak()
    {

        String text = mEditText.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress() / 50;
        if(pitch < 0.1) pitch = 0.1f;
        float speed = (float) getmSeekBarSpeed.getProgress() / 50;
        if(speed < 0.1) speed = 0.1f;

        mTTs.setPitch(pitch);
        mTTs.setSpeechRate(speed);

        mTTs.speak(text, TextToSpeech.QUEUE_ADD, null);


    }

    public void getSpeechInput(View view)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());

        if(intent.resolveActivity(getPackageManager()) != null)
        {

            startActivityForResult(intent,10);
        }
        else
        {
            Toast.makeText(this, "Nah chal rha!!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected  void onDestroy()
    {
        if(mTTs != null)
        {
            mTTs.stop();
            mTTs.shutdown();
        }

        super .onDestroy();
    }

    @Override

    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode)
        {
            case 10:
                if(resultCode == RESULT_OK && data != null)
                {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tx1.setText(result.get(0));
                }
                break;
        }

    }
}
