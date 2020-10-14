package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PlayingNow extends AppCompatActivity {
    String songName;
    String bandName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        songName = getIntent().getStringExtra("song_name");
        bandName = getIntent().getStringExtra("band_name");

        TextView songTextView = (TextView) findViewById(R.id.song_name);
        TextView bandTextView = (TextView) findViewById(R.id.band_name);

        songTextView.setText(songName);
        bandTextView.setText(bandName);
    }
}