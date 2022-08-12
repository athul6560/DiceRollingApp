package com.zeezaglobal.dicerollingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class sharedPref {
    private static final String CUSTOM_SIDES = "myVals";
    private static final String CURRENT_DATA = "current_data";

    public static void storeCurrentData(Context context, int myVal) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean myValShared = prefs.edit().putInt(CURRENT_DATA, myVal).commit();

    }

    public static int getCurrentdata(Context context) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(CURRENT_DATA, 0);

    }
    public static void storeMyVal(Context context, String myVal) {

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            Boolean myValShared = prefs.edit().putString(CUSTOM_SIDES, myVal).commit();

    }

    public static String getMyVal(Context context) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(CUSTOM_SIDES, "");

    }



}
