package com.blackjacksmart.reddragon.notificationapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int NOTIFICATION_ID = 555;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Define an intent to trigger when notification is selected
//        Intent intent = new Intent(this, SecondActivity.class);
//
//        // Turn this nto a Pending Intent
//        int requestID = (int) System.currentTimeMillis();
//        int flags = PendingIntent.FLAG_CANCEL_CURRENT;
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);
//
//        Notification notification = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.drawable.notification_icon)
//                .setContentTitle("MY MAIN ACTIVITY")
//                .setContentText("Hello World!")
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true)
//                .build();
//
//// Get the notification manager system service
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        // Setting a notification ID allows you to update the notification later on.
//        notificationManager.notify(NOTIFICATION_ID, notification);

        launchTestService();
//
        scheduleAlarm();
    }

    public void launchTestService(){

        Intent i = new Intent(this, MyNotificationService.class);
        startService(i);
    }

    // Setup a recurring alarm every half hour
    public void scheduleAlarm() {

        // Construct an intent that will execute the AlarmReceiver
        Intent intent = new Intent(getApplicationContext(), MyAlarmReceiver.class);

        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long firstMillis = System.currentTimeMillis(); // alarm is set right away

        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, 60000L, pendingIntent);
    }

}
