package com.example.dailynews.articles.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.dailynews.db.DailyNewsDatabase

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = DailyNewsDatabase.Schema,
            context = context,
            name = "DailyNews.Database.db"
        )
}