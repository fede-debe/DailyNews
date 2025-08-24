package com.example.dailynews.sources.data

import com.example.dailynews.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {
    suspend fun fetchSources(): List<SourceRaw> {

        val response: SourcesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=${Constants.NEWS_API_KEY}").body()
        return response.sources
    }
}