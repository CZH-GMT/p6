package com.example.mvpwangluo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpwangluo.presenter.LoginPresenter;
import com.example.mvpwangluo.view.IView;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private Button btn;
    private TextView tv;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loginPresenter = new LoginPresenter(this);


    }

    @Override
    public void loginSuccess(String msg) {
        tv.setText(msg);
    }

    @Override
    public void loginFailed(String error) {
        tv.setText(error);
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                loginPresenter.getLoginData("111111", "111111");
                break;
        }
    }
}
