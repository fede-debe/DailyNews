package com.example.dailynews.articles.ui

import com.example.dailynews.BaseViewModel
import com.example.dailynews.articles.domain.Article
import com.example.dailynews.articles.service.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


/** Default values are set to be able to update one value at the time */
data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    /** So we are going to use the reactive programming and streams
     * in order to facilitate the communication between the ViewModel
     * and the UI. In coroutines, the streams are called flows.
     * State flow is obligated to have an initial state
     *
     * Now this could work perfectly, but a very common technique
     * is actually never to expose a public mutable state flow,
     * because anyone outside of this ViewModel could actually
     * add information inside our stream, and this is something
     * we want to avoid.
     * */
    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = useCase.getArticles()

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}