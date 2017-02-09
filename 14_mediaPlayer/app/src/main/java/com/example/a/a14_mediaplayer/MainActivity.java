package com.example.a.a14_mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        seekBar = (SeekBar) findViewById(R.id.playSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    if(mp != null){
                        mp.seekTo(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        String path = Environment.getExternalStorageDirectory()+"/Download";
//        File dir = new File(path);
//        File[] files = dir.listFiles();
//        files[0].getName()
    }

    public void onPlayClick(View v){
        mp = new MediaPlayer();
        String path = Environment.getExternalStorageDirectory()
                +"/Samsung/Music/Over the Horizon.mp3";

        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
            seekBar.setMax(mp.getDuration());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(mp != null) {
                        try {
                            seekBar.setProgress(mp.getCurrentPosition());
                            Thread.sleep(100);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onStopClick(View v){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
