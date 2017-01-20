package com.blackjacksmart.reddragon.notificationapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by RedDragon on 12/4/16.
 */

public class  BootBroadcastReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context, MyNotificationService.class);
        startWakefulService(context, startServiceIntent);
    }
}
