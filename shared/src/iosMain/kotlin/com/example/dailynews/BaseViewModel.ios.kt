package com.example.dailynews

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

/**
 * We don't have the life cycle where a ViewModel scope like in Android.
 * So we are going to manually create an asynchronous scope ourselves.
 * We don't have the life cycle where a ViewModel scope like in Android.
 * So we are going to manually create an asynchronous scope ourselves.
 *
 * Dispatchers.IO --> input/output thread
 * We are going to create a function 'clear()' that we can manually clear
 * this scope and cancel all the work. Remember that when we use the actual
 * expect mechanism, our only obligation is to create actual implementations
 * for all the expected ones, but it is not forbidden to add more functions
 * and more values than the expected.
 * */
actual open class BaseViewModel {
    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun clear() {
        scope.cancel()
    }
}