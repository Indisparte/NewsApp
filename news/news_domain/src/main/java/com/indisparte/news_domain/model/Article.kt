package com.indisparte.news_domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Tutto quello che siamo interessati a mostrare nel presentation layer
 *
 * @author Antonio Di Nuzzo (Indisparte)
 */
@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val urlToImage: String
)
