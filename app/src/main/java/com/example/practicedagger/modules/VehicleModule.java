package com.example.practicedagger.modules;

import com.example.practicedagger.modules.data.Motor;
import com.example.practicedagger.modules.data.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {

    @Provides
    @Singleton
    Motor provideMotor() {
        return new Motor();
    }

    @Provides
    @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Motor());
    }
}
