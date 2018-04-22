package com.example.dell.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;


class UserModel extends ViewModel {
    private MutableLiveData<Integer> calculatedValue;

    public void setValue(boolean value) {
        if (value) {
            calculatedValue.setValue(calculatedValue.getValue() + 1);
        } else {
            if (calculatedValue.getValue() != 0) {
                calculatedValue.setValue(calculatedValue.getValue() - 1);
            }
        }
    }

    public LiveData<Integer> getValue() {
        if (calculatedValue == null) {
            calculatedValue = new MutableLiveData<Integer>();
            calculatedValue.setValue(0);
        }
        return calculatedValue;
    }
}