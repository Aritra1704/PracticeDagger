package com.example.practicedagger.modules;


import android.content.Context;

import com.example.practicedagger.webservices.APICall;
import com.example.practicedagger.webservices.RetrofitService;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitModule {

    @Provides
    RetrofitService provideRetrofitService() {
        return new RetrofitService();//RetrofitService.createService(APICall.class);//new RetrofitService();
    }
}
