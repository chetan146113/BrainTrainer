package com.example.chetan.braintrainer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView Im;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Im = (ImageView) findViewById(R.id.imageView);

        Im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(MainActivity.this,R.raw.booms13);
                mp.start();
                Intent i=new Intent (MainActivity.this,secondactivity.class);
                startActivity(i);
            }
        });
    }
}
