package com.example.toko.ui.barang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BarangViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public BarangViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is barang fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
