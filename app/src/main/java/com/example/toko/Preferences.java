package com.example.toko;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    public static final String USER="user";
    public static final String LOGGED= "logged";
    public static final String NAMA="nama";
    public static final  String JABATAN="jabatan";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public Preferences(Context context){
        sp = context.getSharedPreferences(USER, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getNama(){
        return sp.getString(NAMA, "");
    }
    public String getJabatan(){
        return sp.getString(JABATAN, "");
    }
    public Boolean getLogged(){
        return sp.getBoolean(LOGGED, false);
    }
}