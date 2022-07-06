package com.example.mp4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SurfaceView sfv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        sfv = (SurfaceView) findViewById(R.id.sfv);

        final MediaPlayer mediaPlayer = new MediaPlayer();
        sfv.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                String s = Environment.getExternalStorageDirectory() + File.separator + "aaa.mp4";

                File file = new File(s);
                if (!file.exists()){
                    Toast.makeText(MainActivity.this, "文件未找到", Toast.LENGTH_SHORT).show();
                }
                try {
                    mediaPlayer.setDataSource(s);
                    mediaPlayer.prepare();
                    mediaPlayer.setDisplay(sfv.getHolder());

                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

    }
}
