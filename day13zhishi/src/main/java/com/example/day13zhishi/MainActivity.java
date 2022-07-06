package com.example.day13zhishi;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private Button btn2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        text = (TextView) findViewById(R.id.text);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                break;
            case R.id.btn2:
                retrofit();
                break;
        }
    }

    private static final String TAG = "MainActivity";
    private void retrofit() {



        String header="";


        //path->file
        String path= Environment.getExternalStorageState()+"/a2.jpg";
     //   String externalStorageState = Environment.getExternalStorageState();
        File file = new File(path);
        //文件不存在
        if (!file.exists()){
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
            return;
        }
        //file->requestbody
        RequestBody requestBody = RequestBody.create(MediaType.parse("iamge/jpg"), file);

        //requestbody->multipartbody.part
        MultipartBody.Part multipart = MultipartBody.Part.createFormData("file", file.getName(), requestBody);



        new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
               .baseUrl(ApiService.url)
                .build()
                .create(ApiService.class)
                .getdata(header,multipart)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String string = response.body().string();
                            Log.d(TAG, "onResponse: "+string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable throwable) {

                    }
                });



    }
}
