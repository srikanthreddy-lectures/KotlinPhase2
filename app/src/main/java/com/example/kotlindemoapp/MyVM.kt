package com.example.kotlindemoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyVM : ViewModel() {
    private var name = MutableLiveData<String>()

    public fun setData(n: String){
        name.value = n
    }

    public fun getData():LiveData<String>{
        return name
    }
}