package com.indisparte.model.data

/**
 * External data layer representation  of fully populated Article resource
 */
data class ArticleResource(
    val author: String,
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String
)