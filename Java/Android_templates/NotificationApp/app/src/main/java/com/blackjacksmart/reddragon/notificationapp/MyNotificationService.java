package com.blackjacksmart.reddragon.notificationapp;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by RedDragon on 12/4/16.
 */
public class MyNotificationService extends IntentService{

    private static final String SERVICE_NAME = "notification-service";

    public MyNotificationService() {
        super(SERVICE_NAME);
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    protected void onHandleIntent(Intent intent) {

        int NOTIFICATION_ID = 556;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My Notification Service")
                .setContentText("Hello Boot!");

// Get the notification manager system service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Setting a notification ID allows you to update the notification later on.
        notificationManager.notify(NOTIFICATION_ID, builder.build());

    }
}
