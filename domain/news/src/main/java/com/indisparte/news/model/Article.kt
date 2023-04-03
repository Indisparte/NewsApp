package com.indisparte.news.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
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
