package com.example.onsite1;

import android.graphics.Path;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Fragment1ViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Path> path = new MutableLiveData<>();
    public void setPath(Path input) {
        path.setValue(input);
    }
    public LiveData<Path> getPath() {
        return path;
    }
}