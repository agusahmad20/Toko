package com.example.toko.ui.pegawai;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.toko.Login;
import com.example.toko.Preferences;
import com.example.toko.R;

public class PegawaiFragment extends Fragment {
    private PegawaiViewModel pengaturanViewModel;
    Preferences sharedPreferences;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedPreferences= new Preferences(getContext());
        pengaturanViewModel =
                new ViewModelProvider(this).get(PegawaiViewModel.class);
        View root = inflater.inflate(R.layout.f_pegawai, container, false);
        final TextView textView = root.findViewById(R.id.text_pegawai);


        pengaturanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
