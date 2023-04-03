package com.indisparte.home

import com.indisparte.news.model.Article



/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
data class NewsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Article>? = null
)