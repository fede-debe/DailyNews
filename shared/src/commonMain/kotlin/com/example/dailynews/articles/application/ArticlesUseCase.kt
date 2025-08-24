package com.example.dailynews.articles.application

import com.example.dailynews.Constants
import com.example.dailynews.articles.data.ArticlesRepository
import com.example.dailynews.articles.data.ArticleRaw
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class ArticlesUseCase(private val repository: ArticlesRepository) {

    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articlesRaw = repository.getArticles(forceFetch)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            raw.title,
            raw.desc ?: "Click to find out more",
            getDaysAgoString(raw.date),
            raw.imageUrl
                ?: Constants.DEFAULT_IMAGE_URL
        )
    }
    /** Use the clock system with the current system's default time zone.
     * A line returns how many days ago the input date is compared to today.
     * This returns zero if the date is the current date, or a negative integer
     * indicating how many days have passed.
     *
     * Then, we construct the result string.
     * The 'daysAgo' value is a negative integer, so we get its absolute value.
     * - If the absolute difference is more than 1, the result is "{value} days ago".
     * - If the absolute difference is exactly 1, the result is "Yesterday".
     * - Otherwise, the difference is 0, and the result is "Today".
     * */
    @OptIn(ExperimentalTime::class)
    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.Companion.currentSystemDefault())
        val days = today.daysUntil(
            Instant.Companion.parse(date).toLocalDateTime(TimeZone.Companion.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}