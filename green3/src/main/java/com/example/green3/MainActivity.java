package com.example.green3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText insert;
    private Button insert_btn;
    private EditText delete;
    private Button delete_btn;
    private EditText updata;
    private Button updata_btn;
    private Button text;
    private TextView write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        insert = (EditText) findViewById(R.id.insert);
        insert_btn = (Button) findViewById(R.id.insert_btn);
        delete = (EditText) findViewById(R.id.delete);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        updata = (EditText) findViewById(R.id.updata);
        updata_btn = (Button) findViewById(R.id.updata_btn);
        text = (Button) findViewById(R.id.text);

        insert_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        updata_btn.setOnClickListener(this);
        text.setOnClickListener(this);
        write = (TextView) findViewById(R.id.write);
        write.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert_btn:
                String s = insert.getText().toString();
                if (s.contains(",")) {
                    String[] split = s.split(",");
                    DBUtil.insert(split[0], split[1]);
                }


                break;
            case R.id.delete_btn:
                String s1 = delete.getText().toString();
                DBUtil.delete(s1);

                break;
            case R.id.updata_btn:
                String s2 = updata.getText().toString();
                if (s2.contains(",")) {
                    String[] split = s2.split(",");
                    DBUtil.updata(split[0], split[1]);
                }

                break;
            case R.id.text:
                List<User> quary = DBUtil.quary();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i <quary.size() ; i++) {
                    User user = quary.get(i);
                    stringBuilder.append(user.getId()+"--"+user.getName());

                }
                write.setText(stringBuilder);




                break;


        }
    }


}
