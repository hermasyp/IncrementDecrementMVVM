package com.catnip.incrementdecrementmvvm.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.catnip.incrementdecrementmvvm.data.CounterDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class MainViewModel(
    private val dataSource: CounterDataSource
) : ViewModel() {

    val counter: LiveData<Int>
        get() = dataSource.getCounterFlow().asLiveData(Dispatchers.Main)

    fun increment() {
        viewModelScope.launch {
            dataSource.increment()
        }
    }

    fun decrement() {
        viewModelScope.launch {
            dataSource.decrement()
        }
    }
}