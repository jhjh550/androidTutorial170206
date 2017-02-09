package com.example.a.a17_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("myService", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myService", "onDestory");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("myService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
