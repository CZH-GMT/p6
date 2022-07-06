package com.example.ceshitikusan;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class Dong extends BroadcastReceiver {
    private static final String TAG = "Dong";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: "+intent.getStringExtra("key"));

        NotificationManager systemService = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String id="123";
        String name="hh";
        if (Build.VERSION.SDK_INT>=26){
            NotificationChannel notificationChannel = new NotificationChannel(id,name,NotificationManager.IMPORTANCE_DEFAULT);
            systemService.createNotificationChannel(notificationChannel);
        }
        Intent intent1 = new Intent(context,NewActivity.class);
        PendingIntent activity = PendingIntent.getActivity(context, 1, intent1, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification build = new NotificationCompat.Builder(context, id)
                .setSmallIcon(R.drawable.bone)
                .setContentText("通知")
                .setContentTitle("标题")
                .setAutoCancel(true)
                .setContentIntent(activity)
                .build();
        systemService.notify(1,build);

    }
}
