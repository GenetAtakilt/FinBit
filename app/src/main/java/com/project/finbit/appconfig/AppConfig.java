package com.project.finbit.appconfig;

import android.app.Application;

import com.orm.SugarApp;
import com.orm.SugarContext;

public class AppConfig extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();

        SugarContext.init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
