package com.example.day_02_zuoye2;

import android.app.Application;

public class BaseApp extends Application {
    private static BaseApp baseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
    }

    public static BaseApp getBaseApp() {
        return baseApp;
    }
}
