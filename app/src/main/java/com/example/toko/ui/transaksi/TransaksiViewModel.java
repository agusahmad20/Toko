package com.example.toko.ui.transaksi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TransaksiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TransaksiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Transaksi fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}