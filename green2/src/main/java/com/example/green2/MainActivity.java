package com.example.green2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_insert;
    private Button insert;
    private EditText et_delete;
    private Button delete;
    private EditText et_updata;
    private Button updata;
    private Button query;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_insert = (EditText) findViewById(R.id.et_insert);
        insert = (Button) findViewById(R.id.insert);
        et_delete = (EditText) findViewById(R.id.et_delete);
        delete = (Button) findViewById(R.id.delete);
        et_updata = (EditText) findViewById(R.id.et_updata);
        updata = (Button) findViewById(R.id.updata);
        query = (Button) findViewById(R.id.query);
        text = (TextView) findViewById(R.id.text);

        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        updata.setOnClickListener(this);
        query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                String s = et_insert.getText().toString().trim();
                if (s.contains(",")){
                    String[] split = s.split(",");
                    DBUtil.insert(split[0],split[1]);
                    Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.delete:
                String s1 = et_delete.getText().toString();
                DBUtil.delete(s1);

                break;
            case R.id.updata:
                String s2 = et_updata.getText().toString();
                Toast.makeText(this, "修改", Toast.LENGTH_SHORT).show();
                if (s2.contains(",")){
                    String[] split = s2.split(",");
                    DBUtil.upDta(split[0],split[1]);
                }


                break;
            case R.id.query:
                List<User> queryall = DBUtil.queryall();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i <queryall.size() ; i++) {
                    User user = queryall.get(i);
                    stringBuilder.append(user.getId()+"--"+user.getName()+"\n");

                }
                text.setText(stringBuilder.toString());

                break;
        }
    }


}
