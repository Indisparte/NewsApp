package com.indisparte.news_presentation

import com.indisparte.news_domain.model.Article


private val TAG = NewsState::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
data class NewsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Article>? = null
)