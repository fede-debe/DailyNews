package com.example.dailynews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.dailynews.articles.ArticlesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        Platform().logSystemInfo()

        val articlesViewModel: ArticlesViewModel by viewModels()

        setContent {
            App(viewModel = articlesViewModel)
        }
    }
}