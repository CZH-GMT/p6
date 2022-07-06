package com.example.kadianxiazai;


import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mClick;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mClick = (Button) findViewById(R.id.click);
        mClick.setOnClickListener(this);
        mProgress = (ProgressBar) findViewById(R.id.progress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click:
                // TODO 20/12/30

                moreThreadDownLoad();
                break;
            default:
                break;
        }
    }

    String downUrl = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";

    //即将下载的文件路径
    String targetFilePathAndName;

    /**
     * 多线程下载
     * 1.获取文件的大小
     */
    private void moreThreadDownLoad() {


        new Thread(new Runnable() {
            public void run() {

                targetFilePathAndName = Environment.getExternalStorageDirectory() + File.separator + "qq.apk";

                try {

                    // 创建本地的临时文件
                    RandomAccessFile file = new RandomAccessFile(targetFilePathAndName, "rw");


                    HttpURLConnection connection = HttpUtil.getConnection(downUrl, 0, 0);
                    // 文件的大小
                    int contentLength = connection.getContentLength();//10

                    mProgress.setMax(contentLength);

                    file.setLength(contentLength);// 设置本地文件的大小
                    file.close();

                    ExecutorService executorService = Executors.newFixedThreadPool(3);

                    int partSize = contentLength / 3;//0-2  3-5 6-9

                    for (int i = 0; i < 3; i++) {

//                        起点  终点
                        int startPos = i * partSize;
                        int endPos;

                        //是否是最后一个线程
                        if (i == 2) {
                            endPos = contentLength - 1;
                        } else {
                            endPos = (i + 1) * partSize - 1;
                        }
                        ItemTask itemTask = new ItemTask(startPos, endPos, targetFilePathAndName, new ItemTask.IUpdateProgressListener() {
                            @Override
                            public void update(int len) {
                                //自增形式的进度值
                                mProgress.incrementProgressBy(len);
                            }
                        });

                        executorService.execute(itemTask);

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }
}