package com.example.kadianxiazai;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;

public class ItemTask implements Runnable {


    /**
     * 已经结束的线程数量
     */
    private static int finishThreadNum = 3;

    private int startPos;
    private int endPos;
    private String targetFilePathAndName;
    private IUpdateProgressListener iUpdateProgressListener;
    private RandomAccessFile randomAccessFile;

    public ItemTask(int startPos, int endPos, String targetFilePathAndName, IUpdateProgressListener iUpdateProgressListener) {
        this.startPos = startPos;

        this.endPos = endPos;
        this.targetFilePathAndName = targetFilePathAndName;
        this.iUpdateProgressListener = iUpdateProgressListener;

        try {

            randomAccessFile = new RandomAccessFile(targetFilePathAndName, "rw");

            //从何处开始下载
            randomAccessFile.seek(startPos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String downUrl = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";

    @Override
    public void run() {

//        开始下载啦
        try {
            HttpURLConnection connection = HttpUtil.getConnection(downUrl, startPos, endPos);

            InputStream inputStream = connection.getInputStream();

            byte[] bytes = new byte[1024 * 4];
            int len = 0;

            while ((len = inputStream.read(bytes)) != -1) {

                Log.d(TAG, "run: " + len);
                randomAccessFile.write(bytes, 0, len);

                iUpdateProgressListener.update(len);
            }
            inputStream.close();
            randomAccessFile.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            finishThreadNum--;

            if (finishThreadNum == 0) {
                Log.d(TAG, "run: 整个文件下载完成");
            }
        }


    }

    private static final String TAG = "ItemTask";

    public interface IUpdateProgressListener {
        void update(int len);
    }
}
