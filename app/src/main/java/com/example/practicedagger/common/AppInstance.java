package com.example.practicedagger.common;

import android.app.Application;

import com.example.practicedagger.modules.AppComponent;
import com.example.practicedagger.modules.DaggerAppComponent;
import com.example.practicedagger.modules.PrefModule;

public class AppInstance extends Application {

    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().prefModule(new PrefModule(this)).build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
