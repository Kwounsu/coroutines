package com.example.mvvmtestingdemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory: create multiple objects without specifying the exact class of object that will be created.
 * Reason to use: to create code more testable.
 */
class MainViewFactory(private val repo: MainRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repo) as T
        } else {
            throw IllegalArgumentException("This class only produces MainViewModel")
        }
    }
}