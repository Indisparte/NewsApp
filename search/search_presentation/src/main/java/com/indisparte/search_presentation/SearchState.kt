package com.indisparte.search_presentation

import com.indisparte.search_domain.model.Article


private val TAG = SearchState::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
data class SearchState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Article>? = null
)