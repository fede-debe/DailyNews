package com.example.dailynews.di

import com.example.dailynews.articles.ui.ArticlesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {

    viewModelOf(::ArticlesViewModel)
}