package com.example.dailynews.sources.data

import com.example.dailynews.db.DailyNewsDatabase

class SourcesDataSource(private val db: DailyNewsDatabase) {

    fun getAllSources(): List<SourceRaw> =
        db.dailyNewsDatabaseQueries.selectAllSources(::mapSource).executeAsList()

    fun clearSources() =
        db.dailyNewsDatabaseQueries.removeAllSources()

    private fun mapSource(
        id: String,
        name: String,
        desc: String,
        language: String,
        country: String
    ): SourceRaw {
        return SourceRaw(
            id,
            name,
            desc,
            language,
            country
        )
    }

    internal fun createSources(sources: List<SourceRaw>) {
        db.dailyNewsDatabaseQueries.transaction {
            sources.forEach { source ->
                insertSource(source)
            }
        }
    }

    private fun insertSource(source: SourceRaw) {
        db.dailyNewsDatabaseQueries.insertSource(
            source.id,
            source.name,
            source.desc,
            source.language,
            source.country,
        )
    }
}