package com.example.dailynews.di

import com.example.dailynews.articles.di.articlesModule

/** Modules shared between different platforms */
val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)