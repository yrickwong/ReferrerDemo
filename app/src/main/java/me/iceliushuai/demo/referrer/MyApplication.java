package me.iceliushuai.demo.referrer;

import android.app.Application;

/**
 * Created by yrickwong on 15/9/10.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化GA
        AnalyticsTrackers.initialize(this);
    }
}
