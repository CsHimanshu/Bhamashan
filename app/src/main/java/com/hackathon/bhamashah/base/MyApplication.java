package com.hackathon.bhamashah.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by himanshukumarsingh on 26/02/17.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context=this;

    }

    public static Context getContext() {
        return context;
    }

}
