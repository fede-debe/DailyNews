package com.example.dailynews.articles.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.dailynews.db.DailyNewsDatabase

actual class DatabaseDriverFactory() {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = DailyNewsDatabase.Schema,
            name = "DailyNewsDatabase.db"
        )
}