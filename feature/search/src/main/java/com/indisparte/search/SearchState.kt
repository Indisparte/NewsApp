package com.indisparte.search

import com.indisparte.news.model.Article


private val TAG = SearchState::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
data class SearchState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Article>? = null
)