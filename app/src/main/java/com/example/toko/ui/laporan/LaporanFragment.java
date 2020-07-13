package com.example.toko.ui.laporan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.toko.R;

public class LaporanFragment extends Fragment {
    private LaporanViewModel laporanViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        laporanViewModel =
                ViewModelProviders.of(this).get(LaporanViewModel.class);
        View root = inflater.inflate(R.layout.f_laporan, container, false);
        final TextView textView = root.findViewById(R.id.text_laporan);

        laporanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
