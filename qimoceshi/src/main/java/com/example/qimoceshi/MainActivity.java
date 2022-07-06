package com.example.qimoceshi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText password;
    private Button btn;
    private String name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getdata("111111","111111").enqueue(new Callback<RequestBody>() {
            @Override
            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                name1 = response.body().toString();

            }

            @Override
            public void onFailure(Call<RequestBody> call, Throwable t) {
              //  Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                String s = name.getText().toString();
                String s1 = password.getText().toString();
                if (!s.isEmpty()&&!s1.isEmpty()){
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }


                break;
        }
    }


}
