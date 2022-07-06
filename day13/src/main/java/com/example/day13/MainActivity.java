package com.example.day13;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String url="https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png";
    private Button btn;
    private ImageView image;
    private Imagecache imagecache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        imagecache = new Imagecache();

    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        image = (ImageView) findViewById(R.id.image);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Bitmap bitmap = imagecache.getBitmap(url);
                if(bitmap!=null){
                    image.setImageBitmap(bitmap);
                }else {
                    getimageBitmap();
                }


                break;
        }
    }

    private void getimageBitmap() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream inputStream = new URL(url).openConnection().getInputStream();
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    imagecache.put(url,bitmap);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            image.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }
}
