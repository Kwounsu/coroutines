package com.example.mvvmtestingdemo.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.*

open class MainRepo {
    open suspend fun getData():String = withContext(Dispatchers.IO) {
        delay(5000)
        UUID.randomUUID().toString()
    }
}