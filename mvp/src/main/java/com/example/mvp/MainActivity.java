package com.example.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.presenter.Presenter;
import com.example.mvp.view.IView;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private Button btn;
    private TextView tv;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new Presenter(this);
//        presenter.getmodelData();
    }

    private void initView() {

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                presenter.getmodelData();
                break;
        }
    }

    @Override
    public void updateUISuccess(String msg) {
        tv.setText(msg);
    }

    @Override
    public void updateUIFailed(String error) {
        tv.setText(error);
    }
}
