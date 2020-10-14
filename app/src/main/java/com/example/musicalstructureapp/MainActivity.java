package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

/*
Autor @ Marwa Hatamleh
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MyList> myListData = Arrays.asList(new MyList[]{
                new MyList(R.drawable.music_icon, getString(R.string.song1), getString(R.string.band1)),
                new MyList(R.drawable.music_icon, getString(R.string.song3), getString(R.string.band3)),
                new MyList(R.drawable.music_icon, getString(R.string.song4), getString(R.string.band4)),
                new MyList(R.drawable.music_icon, getString(R.string.song5), getString(R.string.band5)),
                new MyList(R.drawable.music_icon, getString(R.string.song6), getString(R.string.band6)),
                new MyList(R.drawable.music_icon, getString(R.string.song7), getString(R.string.band7)),
                new MyList(R.drawable.music_icon, getString(R.string.song8), getString(R.string.band8)),
                new MyList(R.drawable.music_icon, getString(R.string.song9), getString(R.string.band9)),
                new MyList(R.drawable.music_icon, getString(R.string.song10), getString(R.string.band10)),
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(this, myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
