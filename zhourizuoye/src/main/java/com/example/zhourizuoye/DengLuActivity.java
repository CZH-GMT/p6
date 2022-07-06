package com.example.zhourizuoye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DengLuActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText yonghu;
    private EditText password;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        boolean hh = user.getBoolean("hh", false);
        if (hh){
            startActivity(new Intent(this,HomeActivity.class));
        }else{

        }
        boolean hh1 = user.edit().putBoolean("hh", true).commit();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);
        initView();
    }

    private void initView() {
        yonghu = (EditText) findViewById(R.id.yonghu);
        password = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                String yonghuString = yonghu.getText().toString().trim();
                if (TextUtils.isEmpty(yonghuString)) {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }

                String passwordString = password.getText().toString().trim();
                if (TextUtils.isEmpty(passwordString)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }



                if (yonghuString.equals("H2003xs")&&passwordString.equals("H2003")){
                    Toast.makeText(this, "输入正确", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this,HomeActivity.class));
                }else {
                    Toast.makeText(this, "输入错误", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }


}
