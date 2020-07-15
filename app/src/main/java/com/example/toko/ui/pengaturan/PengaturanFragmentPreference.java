package com.example.toko.ui.pengaturan;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.toko.Login;
import com.example.toko.Preferences;
import com.example.toko.R;

public class PengaturanFragmentPreference extends PreferenceFragmentCompat {

    Preferences sharedPreferences;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        Preference keluar;

        keluar= findPreference("keluar");
        keluar.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                logout();

                return true;
            }
        });



    }

    public void logout(){
        sharedPreferences= new Preferences(getContext());
        sharedPreferences.saveString(sharedPreferences.LOGGED,"");
        sharedPreferences.saveString(sharedPreferences.LOGGED,"");
        sharedPreferences.saveBoolean(sharedPreferences.LOGGED,false);
        startActivity(new Intent(getActivity(), Login.class));
        getActivity().finish();
    }
}
