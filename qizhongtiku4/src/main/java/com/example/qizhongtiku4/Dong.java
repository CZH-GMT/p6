package com.example.qizhongtiku4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Dong extends BroadcastReceiver {
    private static final String TAG = "Dong";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: "+intent.getStringExtra("key"));
        Toast.makeText(context, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show();
    }
}
