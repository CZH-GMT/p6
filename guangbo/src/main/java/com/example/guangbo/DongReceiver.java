package com.example.guangbo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DongReceiver extends BroadcastReceiver {
    private static final String TAG = "DongReceiver";


        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: "+intent.getStringExtra("msg"));
        }
    };



