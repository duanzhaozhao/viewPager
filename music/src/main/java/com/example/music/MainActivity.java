package com.example.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.example.music.MediaUtil.getMusicMaps;

public class MainActivity extends AppCompatActivity {
    private ListView music_list;
    List<HashMap<String, String>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music_list = (ListView) findViewById(R.id.music_list);
        data = getMusicMaps(MediaUtil.getMp3Infos(this));
        MArrayAdapter arrayAdapter = new MArrayAdapter(this,data,R.layout.list_view);
        music_list.setAdapter(arrayAdapter);

    }


}


