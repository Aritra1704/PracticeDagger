package com.example.practicedagger.webservices;

import com.example.practicedagger.modules.data.Vehicle;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {

    @GET
    Call<Vehicle> getTrackDevice();
}
