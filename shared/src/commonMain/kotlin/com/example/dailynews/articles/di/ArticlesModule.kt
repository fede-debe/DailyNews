package com.example.dailynews.articles.di

import com.example.dailynews.articles.data.ArticlesDataSource
import com.example.dailynews.articles.data.ArticlesRepository
import com.example.dailynews.articles.data.ArticlesService
import com.example.dailynews.articles.application.ArticlesUseCase
import com.example.dailynews.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(getOrNull()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}