package com.example.ceshitikusan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DDDD extends BroadcastReceiver {
    private static final String TAG = "DDDD";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: "+intent.getStringExtra("hhhh"));
        Toast.makeText(context, "收到广播", Toast.LENGTH_SHORT).show();
    }
}
