package com.example.dailynews

import androidx.compose.ui.window.ComposeUIViewController
import com.example.dailynews.ui.App
import com.example.dailynews.ui.screens.ArticlesScreen

/** MainViewController is like fragment/activity in Android */
fun MainViewController() = ComposeUIViewController {
    /** whatever composable function we put inside here,
     *  is going to be the entry point and what the iOS emulator is going to show. */
    App()
}