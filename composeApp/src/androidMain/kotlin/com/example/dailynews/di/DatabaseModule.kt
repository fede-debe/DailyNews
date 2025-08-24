package com.example.dailynews.di

import app.cash.sqldelight.db.SqlDriver
import com.example.dailynews.db.DatabaseDriverFactory
import com.example.dailynews.db.DailyNewsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    /** Instance needed to create the database*/
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyNewsDatabase> { DailyNewsDatabase(get()) }
}