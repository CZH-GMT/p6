package com.example.ceshitiku4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText yonghu;
    private EditText mima;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        yonghu = (EditText) findViewById(R.id.yonghu);
        mima = (EditText) findViewById(R.id.mima);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);

    }

    private String shanghao="[1][0-9]{10}";
    private String miam="[0-9a-zA-Z]{6,16}";


    @Override
    public void onClick(View v) {

        SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);
        boolean user = sp.getBoolean("user", true);

        switch (v.getId()) {
            case R.id.btn:
                String s = yonghu.getText().toString();
                String s1 = mima.getText().toString();
                if (user){
                    for (int i = 0; i <=20 ; i++) {
                        App.daoSession.insert(new Bean("光头强"+i,435682934+i,"男"));
                    }

                }else {

                }
                sp.edit().putBoolean("user",false).commit();
                if (s.matches(shanghao)&&s1.matches(miam)){
                    startActivity(new Intent(this,Home_Activity.class));
                }else {
                    Toast.makeText(this, "输入不规范", Toast.LENGTH_SHORT).show();
                }



                break;
        }
    }


}
