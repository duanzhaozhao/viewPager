package com.example.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.util.ServiceConfigurationError;

/**
 * Created by skysoft on 2016/7/8.
 */
public class MusicService extends Service {

    class MyBinder extends Binder {
        public MusicService getService(){
            return MusicService.this;
        }
    }
    MyBinder myBinder = new MyBinder();
    MediaPlayer mediaPlayer;
    String path;
    @Override
    public IBinder onBind(Intent intent) {
        path = intent.getStringExtra("path");//没得到path
        Log.i("pathttt",path);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    mediaPlayer.setDataSource(path);
                    mediaPlayer.prepare();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        mediaPlayer = new MediaPlayer();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
