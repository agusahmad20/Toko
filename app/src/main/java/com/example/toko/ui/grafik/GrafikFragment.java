package com.example.toko.ui.grafik;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.toko.R;

public class GrafikFragment extends Fragment {
    private GrafikViewModel grafikViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        grafikViewModel =
                new ViewModelProvider(this).get(GrafikViewModel.class);
        View root = inflater.inflate(R.layout.f_grafik, container, false);
        final TextView textView = root.findViewById(R.id.text_grafik);

        grafikViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
