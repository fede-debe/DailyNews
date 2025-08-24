package com.example.dailynews.sources.presentation

import com.example.dailynews.sources.application.Source

data class SourcesState (
    val sources: List<Source>,
    val loading: Boolean = false,
    val error: String? = null
)