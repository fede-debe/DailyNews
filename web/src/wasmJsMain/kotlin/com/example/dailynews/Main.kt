package com.example.dailynews

import androidx.compose.foundation.layout.fillMaxSize
import com.example.dailynews.di.initKoin
import com.example.dailynews.ui.App
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()

    CanvasBasedWindow("DailyNews") {
        Surface(modifier = Modifier.fillMaxSize()) {
            App()
        }
    }
}
