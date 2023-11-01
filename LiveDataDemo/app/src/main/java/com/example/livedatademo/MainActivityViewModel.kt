package com.example.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(initialCount: Int) : ViewModel() {
    private var count = MutableLiveData<Int>()

    init {
        count.value = initialCount
    }

    val totalCount: LiveData<Int>
        get() = count

    fun updateCount(){
        count.value = count.value?.plus(1)
    }

}