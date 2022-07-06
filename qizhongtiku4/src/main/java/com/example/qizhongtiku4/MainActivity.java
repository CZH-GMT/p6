package com.example.qizhongtiku4;

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

    private EditText edt;
    private EditText pasw;
    private Button btn;
    private SharedPreferences user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        edt = (EditText) findViewById(R.id.edt);
        pasw = (EditText) findViewById(R.id.pasw);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);


    }
String guize="[1][0-9]{10}";
    String mima="[a-zA-Z0-9]{6,16}";
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                String s = edt.getText().toString();
                String s1 = pasw.getText().toString();
                user = getSharedPreferences("user", MODE_PRIVATE);
                boolean isok = this.user.getBoolean("user", true);
                if (isok){
                    for (int i = 0; i <=20 ; i++) {
                        App.daoSession.insert(new Bean(null,"光头强"+i,"12345678"+i,30,"1325357897"));


                    }
                }else {

                }





                if (s.matches(guize)&&s1.matches(mima)){
                    user.edit().putBoolean("user",false).commit();
                    startActivity(new Intent(MainActivity.this,Home_Activity.class));

                }else {
                    Toast.makeText(this, "输入不规范", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


}
