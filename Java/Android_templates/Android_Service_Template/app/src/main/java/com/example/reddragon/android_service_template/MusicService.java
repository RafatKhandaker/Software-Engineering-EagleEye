package com.example.reddragon.android_service_template;


import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by RedDragon on 1/30/17.
 */

public class MusicService extends android.app.Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
