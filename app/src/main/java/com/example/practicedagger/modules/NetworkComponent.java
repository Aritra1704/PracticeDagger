package com.example.practicedagger.modules;

import com.example.practicedagger.MainActivity;
import com.example.practicedagger.annotations.ApplicationScope;
import com.example.practicedagger.webservices.APICall;
import com.example.practicedagger.webservices.RetrofitService;

import javax.inject.Singleton;

import dagger.Subcomponent;

@ApplicationScope
@Subcomponent(modules = {RetrofitModule.class})
public interface NetworkComponent {
    RetrofitService inject(RetrofitService activity);

//    RetrofitService getApiCall();
}
