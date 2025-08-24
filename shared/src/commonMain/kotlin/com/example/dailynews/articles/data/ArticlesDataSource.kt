package com.example.dailynews.articles.data

import com.example.dailynews.db.DailyNewsDatabase

class ArticlesDataSource(private val database: DailyNewsDatabase) {

    fun getAllArticles(): List<ArticleRaw> =
        database.dailyNewsDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    /**
      A transaction is a block of queries that must all be successful.
      If even one of the queries fails, the entire transaction and all of
      its preceding queries must be reverted.

      Essentially, all queries inside the transaction block must execute
      successfully as a single, atomic unit.
    */
    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyNewsDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() =
        database.dailyNewsDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.dailyNewsDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.desc,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleRaw =
        ArticleRaw(
            title,
            desc,
            date,
            url
        )
}