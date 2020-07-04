package com.example.toko.ui.pengaturan;

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

public class PengaturanFragment extends Fragment {
    private PengaturanViewModel pengaturanViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pengaturanViewModel =
                ViewModelProviders.of(this).get(PengaturanViewModel.class);
        View root = inflater.inflate(R.layout.f_pengaturan, container, false);
        final TextView textView = root.findViewById(R.id.text_pengaturan);
        pengaturanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
