package com.example.dailynews.di

import app.cash.sqldelight.db.SqlDriver
import com.example.dailynews.db.DatabaseDriverFactory
import com.example.dailynews.db.DailyNewsDatabase
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory().createDriver()!! }

    single<DailyNewsDatabase> { DailyNewsDatabase(get()) }
}