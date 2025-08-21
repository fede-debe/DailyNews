package com.example.dailynews.articles.di

import com.example.dailynews.articles.service.ArticlesService
import com.example.dailynews.articles.service.ArticlesUseCase
import com.example.dailynews.articles.ui.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}