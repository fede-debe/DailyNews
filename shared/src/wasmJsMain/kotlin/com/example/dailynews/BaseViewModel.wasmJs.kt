package com.example.dailynews

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
actual open class BaseViewModel actual constructor() {
    actual val scope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Default)
}