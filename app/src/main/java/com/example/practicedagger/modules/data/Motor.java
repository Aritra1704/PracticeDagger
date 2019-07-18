package com.example.practicedagger.modules.data;

import javax.inject.Inject;

public class Motor {
    private int rpm = 10;

    @Inject
    public Motor(){
        this.rpm = 10;
    }

    public int getRpm(){
        return rpm;
    }

    public void accelerate(int value){
        rpm = rpm + value;
    }

    public void brake(){
        rpm = 0;
    }
}
