package com.example.green;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.DbUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText insert;
    private Button insert_btn;
    private EditText delete;
    private Button delete_btn;
    private EditText update;
    private Button update_btn;
    private Button quary_btn;
    private TextView text;

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
        update = (EditText) findViewById(R.id.update);
        update_btn = (Button) findViewById(R.id.update_btn);
        quary_btn = (Button) findViewById(R.id.quary_btn);
        text = (TextView) findViewById(R.id.text);

        insert_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        update_btn.setOnClickListener(this);
        quary_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert_btn:
                String s = insert.getText().toString();
                if (s.contains(",")){
                    String[] split1 = s.split(",");

                    DbUtil.insert(split1[0],split1[1]);
                    Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delete_btn:
                String s1 = delete.getText().toString();
                DbUtil.delete(s1);

                break;
            case R.id.update_btn:
                String s2 = update.getText().toString();
                if (s2.contains(",")){
                    String[] split = s2.split(",");
                    DbUtil.Update(split[0],split[1]);
                }


                break;
            case R.id.quary_btn:
                List<User> users = DbUtil.queryAll();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i <users.size() ; i++) {
                    User user = users.get(i);
                    stringBuilder.append(user.getId()+"——"+user.getName()+"\n");


                }
                text.setText(stringBuilder.toString());

                break;
        }
    }


}
