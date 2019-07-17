package com.example.practicedagger.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.practicedagger.R;
import com.example.practicedagger.common.AppPreference;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PrefModule {
    private Context context;

    @Inject
    public PrefModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public AppPreference provideAppPreference() {
        return new AppPreference(context);
    }

    @Singleton
    @Provides
    public SharedPreferences providePreferences() {
        return context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }
}
