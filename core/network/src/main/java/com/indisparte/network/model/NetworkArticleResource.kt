package com.indisparte.network.model

/**
 * Network representation of [ArticleResource] when fetched from /top-headlines
 */
@Serializable
data class NetworkArticleResource(
    val author: String,
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String
)
