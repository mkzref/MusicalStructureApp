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
    Handler seekHandler = new Handler();
    Runnable runnable;
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
        song = MediaPlayer.create(this, R.raw.nolove);
        bar.setClickable(false);
          runnable = new Runnable() {
            @Override
            public void run() {
                bar.setProgress(song.getCurrentPosition());
                seekHandler.postDelayed(runnable , 1000);
            }

        };



        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();


                song.start();
                bar.setMax(song.getDuration());
                seekHandler.postDelayed(runnable , 0);
                imagebutton.setImageResource(R.drawable.ic_action_playback_pause);

            }
        });


}


}