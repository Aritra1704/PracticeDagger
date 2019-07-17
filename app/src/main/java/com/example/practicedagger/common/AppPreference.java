package com.example.practicedagger.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.practicedagger.R;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.MODE_PRIVATE;

public class AppPreference {
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    public AppPreference(Context context) {
//        preferences		=	PreferenceManager.getDefaultSharedPreferences(context);
        preferences		=	context.getSharedPreferences(context.getString(R.string.app_name), MODE_PRIVATE);
        edit			=	preferences.edit();
    }

    public void setDataPref(String strKey, String strValue) {
        edit.putString(strKey, strValue);
        commitPreference();
    }

    public void removeFromPreference(String strKey) {
        edit.remove(strKey);
    }

    private void commitPreference()
    {
        edit.commit();
    }

    public String getDataPref(String strKey) {
        return preferences.getString(strKey, "");
    }

    public void clear() {
        edit.clear();
        commitPreference();
    }
}
