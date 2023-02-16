package com.cagriucuncu.counterapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceService{

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private final String KEY_VALUE = "KEY_VALUE";

    public SharedPreferenceService(Context context){

        sharedPreferences = context.getSharedPreferences("Pref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public int getValue(String name){
        return sharedPreferences.getInt(KEY_VALUE + name, 0);
    }

    public void setValue(String name, int number){

        editor.putInt(KEY_VALUE + name, number);
        editor.commit();
    }
}
