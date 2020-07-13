package com.example.toko.ui.grafik;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GrafikViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public GrafikViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Grafik fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
