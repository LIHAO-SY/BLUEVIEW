package com.blueview.led.ui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UserViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is USER fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
