package com.example.dailynews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

/** lifecycle aware, when user interface is destroyed,
 * the scope and its data are destroyed as well.
 * We do this in order to optimize the memory usage
 * and avoid memory leaks.
 * */
actual open class BaseViewModel : ViewModel () {
    actual val scope = viewModelScope
}