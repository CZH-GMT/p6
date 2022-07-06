package com.example.qimoceshi;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements View.OnClickListener {

    private Button button;
    private ProgressBar progress;
    private Button mButton;
    private ProgressBar mProgress;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        initView(inflate);

        return inflate;
    }

    String download = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URLConnection urlConnection = new URL(download).openConnection();
                    int contentLength = urlConnection.getContentLength();
                    InputStream inputStream = urlConnection.getInputStream();
                    String s = Environment.getExternalStorageDirectory() + File.separator + "mm.apk";
                    FileOutputStream outputStream = new FileOutputStream(s);
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    int count=0;
                    while ((len = inputStream.read(bytes)) != -1) {


                        outputStream.write(bytes, 0,len);
                        count+=len;
                        int lenth=count*100/contentLength;
                        mProgress.setProgress(lenth);


                    }
















                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private void initView(View inflate) {

        mButton = (Button) inflate.findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mProgress = (ProgressBar) inflate.findViewById(R.id.progress);
        mProgress.setMax(100);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                initData();
                break;
            default:
                break;
        }
    }
}
