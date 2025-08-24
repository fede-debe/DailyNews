package com.example.dailynews.di

import com.example.dailynews.articles.presentation.ArticlesViewModel
import com.example.dailynews.sources.presentation.SourcesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {

    viewModelOf(::ArticlesViewModel)
    viewModelOf(::SourcesViewModel)
}