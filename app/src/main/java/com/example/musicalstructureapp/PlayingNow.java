package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class PlayingNow extends AppCompatActivity {
    String songName;
    String bandName;
    SeekBar bar;
    MediaPlayer song;
    ImageButton imagebutton;
    private double startTime = 0;
    private double finalTime = 0;
    Handler seekHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing_activity);

        songName = getIntent().getStringExtra("song_name");
        bandName = getIntent().getStringExtra("band_name");
        TextView songTextView = (TextView) findViewById(R.id.song_name);
        TextView bandTextView = (TextView) findViewById(R.id.band_name);
        bar = findViewById(R.id.simpleSeekBar);
        imagebutton = findViewById(R.id.play_pause);
        songTextView.setText(songName);
        bandTextView.setText(bandName);
        song = MediaPlayer.create(this, R.raw.applause);
        bar.setClickable(false);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();

                bar.setMax(song.getDuration());
                song.start();
                seekUpdation();

            }
        });


    }
    Runnable run = new Runnable() {
        @Override
        public void run() {
            seekUpdation();
        }
    };
    public void seekUpdation() {
        bar.setProgress(song.getCurrentPosition());
        seekHandler.postDelayed(run, 1000);
    }
}