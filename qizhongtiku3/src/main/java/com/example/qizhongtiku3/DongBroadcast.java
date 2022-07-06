package com.example.qizhongtiku3;

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

public class DongBroadcast extends BroadcastReceiver {

    private static final String TAG = "DongBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: "+intent.getStringExtra("key"));
//        NotificationManager systemService = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        String id="666";
//        String name="熊二";
//        if (Build.VERSION.SDK_INT>=26){
//            NotificationChannel notificationChannel = new NotificationChannel(id,name,NotificationManager.IMPORTANCE_DEFAULT);
//            systemService.createNotificationChannel(notificationChannel);
//        }
//        Intent intent1 = new Intent(context,Home_Fragment.class);
//        PendingIntent activity = PendingIntent.getActivity(context, 1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
//        Notification build = new NotificationCompat.Builder(context, id)
//                .setSmallIcon(R.drawable.bone)
//                .setContentText("text通知")
//                .setContentTitle("title通知")
//                .setContentIntent(activity)
//                .setAutoCancel(true)
//                .build();
//        systemService.notify(1,build);

        NotificationManager systemService = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String id="666";
        String name="hhhhh";
        if (Build.VERSION.SDK_INT>=26){
            NotificationChannel notificationChannel = new NotificationChannel(id,name,NotificationManager.IMPORTANCE_DEFAULT);
            systemService.createNotificationChannel(notificationChannel);
        }
        Intent intent1 = new Intent(context,Main3Activity.class);
        PendingIntent activity1 = PendingIntent.getActivity(context, 1, intent1, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification build = new NotificationCompat.Builder(context, id)
                .setSmallIcon(R.drawable.bone)
                .setContentTitle("通知")
                .setContentText("text")
                .setContentIntent(activity1)
                .setAutoCancel(true)
                .build();
        systemService.notify(1,build);

    }


}
