package com.example.dailynews.sources.di

import com.example.dailynews.sources.application.SourcesUseCase
import com.example.dailynews.sources.data.SourcesDataSource
import com.example.dailynews.sources.data.SourcesRepository
import com.example.dailynews.sources.data.SourcesService
import com.example.dailynews.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {

    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
}