package com.example.tikuqimo2;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText mEditext;
    private Button mOutput, mOutput2;
    private TextView mResult;
    private String inputText;
    private Button sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        mEditext = findViewById(R.id.editext);
        mOutput = findViewById(R.id.output);
        mOutput2 = findViewById(R.id.output2);
        mResult = findViewById(R.id.result);
        sort = findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubbleSort();
            }
        });


        mOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initSort();

            }
        });

        mOutput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initSort2();
            }
        });
    }

    private void bubbleSort() {
        inputText = mEditext.getText().toString();
        if (inputText.matches("[0-9]+")) {
            int[] ints = {0, 9, 7, 3, 5, 6, 7, 8, 1};

            for (int i = 0; i < ints.length - 1; i++) {
                for (int j = 0; j < ints.length - i-1; j++) {
                    if (ints[j] > ints[j + 1]) {
                        int max = ints[j];
                        ints[j] = ints[j + 1];
                        ints[j + 1] = max;
                    }
                }
            }
            outputResult(Arrays.toString(ints));
        } else {
            Toast.makeText(this, "必须全部为数字", Toast.LENGTH_SHORT).show();
//            StringBuffer stringBuffer = new StringBuffer();
//            char[] chars = inputText.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                stringBuffer.append(chars[i] + ",");
//            }
//            String s = stringBuffer.toString();
//            String substring = s.substring(0, s.length() - 1);
//            String s1 = substring.replaceAll("\"", "");


        }


    }

    private void initSort2() {
        inputText = mEditext.getText().toString();
        Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show();
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = inputText.toCharArray();
        for (int i = chars.length - 1; i < chars.length && i >= 0; i--) {

            stringBuffer.append(chars[i]);
        }

        outputResult(stringBuffer.toString());


    }

    private void initSort() {
        inputText = mEditext.getText().toString();
        StringBuffer stringBuffer = new StringBuffer(inputText);
        StringBuffer reverse = stringBuffer.reverse();
        String s = reverse.toString();
        outputResult(s);
    }

    private void outputResult(String result) {
        Toast.makeText(this, "result:" + result, Toast.LENGTH_SHORT).show();
        mResult.setText("result:" + result);

    }


}
