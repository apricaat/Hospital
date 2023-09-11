package com.example.hospital.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel(), CoroutineScope {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }
    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext = job + Dispatchers.IO + coroutineExceptionHandler

    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }

    private fun parseError(t: Throwable) {

    }
}