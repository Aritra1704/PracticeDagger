package com.example.practicedagger;

import android.os.Bundle;

import com.example.practicedagger.common.AppInstance;
import com.example.practicedagger.common.AppPreference;
import com.example.practicedagger.modules.AppComponent;
import com.example.practicedagger.modules.DaggerAppComponent;
import com.example.practicedagger.modules.NetworkComponent;
import com.example.practicedagger.modules.RetrofitModule;
import com.example.practicedagger.modules.VehicleModule;
import com.example.practicedagger.modules.data.Vehicle;
import com.example.practicedagger.webservices.APICall;
import com.example.practicedagger.webservices.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import javax.inject.Inject;

//https://android.jlelse.eu/dagger-2-the-simplest-approach-3e23502c4cab

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName().toString();

    private AppComponent appComponent;
    @Inject
    AppPreference preference;

    @Inject
    Vehicle vehicle;

    RetrofitService apiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((AppInstance) getApplicationContext()).getComponent().inject(this);

//        appComponent = DaggerAppComponent.builder().vehicleModule(new VehicleModule()).build();
//        vehicle = appComponent.vehicle();

        if(preference != null)
            Log.d(TAG, "preference is not null");
        else
            Log.d(TAG, "preference is null");

        if(vehicle != null)
            Log.d(TAG, "vehicle is not null: "+ vehicle.getSpeed());
        else
            Log.d(TAG, "vehicle is null");

        apiCall = ((AppInstance) getApplicationContext()).getComponent().plus(new RetrofitModule()).inject(new RetrofitService());
//        networkComponent = appComponent.getNetwork(new RetrofitModule());
//        apiCall = networkComponent.getApiCall();
//
        if(apiCall != null)
            Log.d(TAG, "apiCall is not null");
        else
            Log.d(TAG, "apiCall is null");

//        apiCall.getTrackDevice();
        bindControls();
    }

    int count = 0;
    void bindControls() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click: " + preference.getDataPref("Click"), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                preference.setDataPref("Click", ++count + "");
            }
        });
    }
}
