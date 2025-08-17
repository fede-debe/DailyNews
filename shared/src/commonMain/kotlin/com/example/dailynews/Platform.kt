package com.example.dailynews

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform