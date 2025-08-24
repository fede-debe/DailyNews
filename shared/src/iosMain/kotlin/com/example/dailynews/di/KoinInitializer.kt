package com.example.dailynews.di

import com.example.dailynews.articles.presentation.ArticlesViewModel
import com.example.dailynews.sources.presentation.SourcesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    /** Dependency graph */
    val modules = sharedKoinModules + databaseModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}

class SourcesInjector : KoinComponent {
    val sourcesViewModel: SourcesViewModel by inject()
}