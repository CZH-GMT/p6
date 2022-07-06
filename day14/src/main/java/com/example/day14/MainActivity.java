package com.example.day14;



import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mClick;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mClick = (Button) findViewById(R.id.click);
        mClick.setOnClickListener(this);
        mResult = (TextView) findViewById(R.id.result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click:
                // TODO 20/12/29
                uploadHttp();
                break;
            default:
                break;
        }
    }

    // 分割符,自己定义即可
    private static final String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";

    String uploadUrl ="https://www.liulongbin.top:8888/api/private/v1/upload";
    /**
     * 文件上传
     *https://www.liulongbin.top:8888/api/private/v1/upload
     *
     * post
     *
     * 请求头  authorization
     * 参数: file -- 文件
     *
     */
    private void uploadHttp() {

        new Thread(){

            @Override
            public void run() {
                super.run();

                String path = Environment.getExternalStorageDirectory()+"/a.jpg";
                File file = new File(path);
                try {

                    uploadForm(file);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();


    }

    /**
     * 上传文件
     */
    private void uploadForm(File uploadFile) throws IOException {
        String header="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjUwMCwicmlkIjowLCJpYXQiOjE2MDkyMDg4MjcsImV4cCI6MTYwOTI5NTIyN30.uT--JB6mcprmtTiuPALB9_owEPtyrZZI4d4D6E0TQ_0";

        StringBuilder sb = new StringBuilder();

        /**
         * 上传文件的头
         * 表单类型 file
         * 传送的数据类型
         */
        sb.append("--" + BOUNDARY + "\r\n");
        sb.append("Content-Disposition: form-data; name=file; filename=" + uploadFile.getName()
                + "\r\n");
        sb.append("Content-Type: application/octet-stream" + "\r\n");// 如果服务器端有文件类型的校验，必须明确指定ContentType
        sb.append("\r\n");

        byte[] headerInfo = sb.toString().getBytes("UTF-8");
        byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
//------------------------------------------请求头部数据---------------------------------------------------------------
        URL url = new URL(uploadUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

//        链接的配置项
        httpURLConnection.setRequestMethod("POST");

        httpURLConnection.setRequestProperty("authorization",header);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
        httpURLConnection.setRequestProperty("Content-Length",  String.valueOf(headerInfo.length + uploadFile.length() + endInfo.length));
        httpURLConnection.setDoOutput(true);

//        ----------------------------------以上为链接的配置--------------------------------------

        //流为了上传文件
        OutputStream outputStream = httpURLConnection.getOutputStream();
        InputStream inputStream = new FileInputStream(uploadFile);


        //上传头部信息
        outputStream.write(headerInfo);

//        上传文件
        byte[] bytes = new byte[1024*4];

        int len=0;
        while ((len=inputStream.read(bytes))!=-1){

            outputStream.write(bytes,0,len);
        }
        outputStream.write(endInfo);

        inputStream.close();
        outputStream.close();
//        -----------------以上----向服务器写入数据--------------------------

        InputStream inputStream1 = httpURLConnection.getInputStream();

        byte[] bb = new byte[1024*4];
        int ll=0;
        StringBuilder stringBuilder = new StringBuilder();

        while ((ll=inputStream1.read(bb))!=-1){
            stringBuilder.append(  new String(bb,0,ll));
        }

        Log.d(TAG, "uploadForm: "+stringBuilder);
        inputStream1.close();


    }

    private static final String TAG = "MainActivity";
}
