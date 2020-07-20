package com.example.mvvmtestingdemo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class MainViewModel(private val repo: MainRepo) : ViewModel() {
    val resultObserver = MutableLiveData<String>()

    fun getNewData() {
        viewModelScope.launch {
            val result = repo.getData()
            resultObserver.postValue(result)
        }
    }

    fun testLengthEven(text: String): Boolean {
        return text.length%2 == 0
    }
}