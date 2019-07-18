package com.example.practicedagger.modules;

import android.content.Context;

import com.example.practicedagger.MainActivity;
import com.example.practicedagger.common.AppPreference;
import com.example.practicedagger.modules.data.Vehicle;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {VehicleModule.class, PrefModule.class})
public interface AppComponent {
    void inject(MainActivity activity);

    AppPreference preferences();
    Vehicle vehicle();
    NetworkComponent plus(RetrofitModule retrofitModule); //getNetwork(RetrofitModule retrofitModule);
}
