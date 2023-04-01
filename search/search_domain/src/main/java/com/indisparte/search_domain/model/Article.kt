package com.indisparte.search_domain.model


/**
 * Tutto quello che siamo interessati a mostrare nel presentation layer
 *
 * @author Antonio Di Nuzzo (Indisparte)
 */
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String
)
