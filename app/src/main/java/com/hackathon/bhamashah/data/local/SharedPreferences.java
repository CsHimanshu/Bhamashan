package com.hackathon.bhamashah.data.local;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Created by himanshukumarsingh on 22/02/17.
 */

public class SharedPreferences {
    //SharedPrefrence Name
    public static final String PREFERENCE_NAME = "bhamashah_local_storage";
    //  SharedPrefrence Key
    public static final String KEY_MOBILE_NUMBER = "";
    public static final String KEY_BID = "";
    public static final String KEY_HOD_DETAIL = "";
    public static final String KEY_MEMBERLIST = "";
    public static final String KEY_IsLOGIN = "";


    public static boolean getBoolean(String key, boolean defValue, Context context) {
        return getSharedPreferences(context).getBoolean(key, defValue);
    }
    public static float getFloat(String key, float defValue, Context context) {
        return getSharedPreferences(context).getFloat(key, defValue);
    }
    public static int getInt(String key, int defValue, Context context) {
        return getSharedPreferences(context).getInt(key, defValue);
    }
    public static long getLong(String key, long defValue, Context context) {
        return getSharedPreferences(context).getLong(key, defValue);
    }
    public static String getString(String key, String defValue, Context context) {
        return getSharedPreferences(context).getString(key, defValue);
    }
    public static void putBoolean(String key, boolean value, Context context) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    public static void putFloat(String key, float value, Context context) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putFloat(key, value);
        editor.commit();
    }
    public static void putInt(String key, int value, Context context) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public static void putLong(String key, long value, Context context) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putLong(key, value);
        editor.commit();
    }
    public static void putString(String key, String value, Context context) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putObject(String key, Object myObject, Context context) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        Gson gson = new Gson();
        String json = gson.toJson(myObject);
        editor.putString(key, json);
        editor.commit();
    }

    public static Object getObject(String key,Object object, Context context) {
        if(object==null)
            return null;
        Gson gson = new Gson();
        String json = getSharedPreferences(context).getString(key, null);
        if(json!=null){
            return gson.fromJson(json,object.getClass());
        }else{
            return null;
        }
    }

    public static void clearAll(Context context) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.clear();
        editor.commit();
    }

    private static android.content.SharedPreferences getSharedPreferences(Context context) {
        android.content.SharedPreferences pref = context.getSharedPreferences(SharedPreferences.PREFERENCE_NAME, Context.MODE_PRIVATE);
        return pref;
    }
}
