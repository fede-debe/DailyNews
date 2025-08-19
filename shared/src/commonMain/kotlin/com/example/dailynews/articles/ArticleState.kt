package com.example.dailynews.articles

/** Default values are set to be able to update one value at the time */
data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)