package com.example.dailynews.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dailynews.articles.application.Article
import com.example.dailynews.articles.presentation.ArticlesState
import com.example.dailynews.articles.presentation.ArticlesViewModel
import com.example.dailynews.ui.screens.elements.ErrorMessage
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url
import org.koin.compose.koinInject

@Composable
fun ArticlesScreen(
    articlesViewModel: ArticlesViewModel = koinInject()
) {

    val articlesState = articlesViewModel.articlesState.collectAsStateWithLifecycle()

    Column {
        AppBar()

        when {
            articlesState.value.error != null -> ErrorMessage(articlesState.value.error!!)
            articlesState.value.articles.isNotEmpty() -> ArticlesListView(
                articlesState = articlesState.value,
                onGetArticles = { articlesViewModel.getArticles(true) })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = {}) {
//                Icon(
//                    imageVector = Icons.AutoMirrored.Outlined.List,
//                    contentDescription = "Sources Button",
//                )
            }
            IconButton(onClick = {}) {
//                Icon(
//                    imageVector = Icons.Outlined.Info,
//                    contentDescription = "About Device Button",
//                )
            }
        }
    )
}

//@Composable
//fun ArticlesListView(articlesState: ArticlesState, onGetArticles: () -> Unit) {
//
//    SwipeRefresh(
//        state = SwipeRefreshState(articlesState.loading),
//        onRefresh = onGetArticles
//    ) {
//        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(articlesState.articles) { article ->
//                ArticleItemView(article = article)
//            }
//        }
//    }
//}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ArticlesListView(articlesState: ArticlesState, onGetArticles: () -> Unit) {

    val state = rememberPullRefreshState(
        refreshing = articlesState.loading,
        onRefresh = onGetArticles
    )

    Box(
        modifier = Modifier.pullRefresh(state = state)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(articlesState.articles) { article ->
                ArticleItemView(article = article)
            }
        }
        PullRefreshIndicator(
            refreshing = articlesState.loading,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Composable
fun ArticleItemView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        KamelImage(
            resource = { asyncPainterResource(data = Url(article.imageUrl)) },
            contentDescription = "article image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(200.dp),
            onLoading = {
                ErrorMessage("Loading")
            },
            onFailure = {
                ErrorMessage("Error getting the image")
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}