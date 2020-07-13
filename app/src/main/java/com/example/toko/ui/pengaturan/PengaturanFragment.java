package com.example.toko.ui.pengaturan;

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
import androidx.lifecycle.ViewModelProviders;

import com.example.toko.Login;
import com.example.toko.Nav;
import com.example.toko.Preferences;
import com.example.toko.R;

public class PengaturanFragment extends Fragment {
    private PengaturanViewModel pengaturanViewModel;
    Preferences sharedPreferences;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedPreferences= new Preferences(getContext());
        pengaturanViewModel =
                ViewModelProviders.of(this).get(PengaturanViewModel.class);
        View root = inflater.inflate(R.layout.f_pengaturan, container, false);
        final TextView textView = root.findViewById(R.id.text_pengaturan);
        Button keluar = root.findViewById(R.id.b_logout);

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.saveSPBoolean(sharedPreferences.LOGGED,false);
                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finish();
            }
        });

        pengaturanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
