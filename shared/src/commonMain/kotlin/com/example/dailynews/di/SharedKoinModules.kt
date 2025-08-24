package com.example.dailynews.di

import com.example.dailynews.articles.di.articlesModule
import com.example.dailynews.sources.di.sourcesModule

/** Modules shared between different platforms */
val sharedKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule
)