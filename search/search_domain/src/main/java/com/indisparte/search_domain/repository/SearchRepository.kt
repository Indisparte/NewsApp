package com.indisparte.search_domain.repository

import com.indisparte.search_domain.model.Article


private val TAG = SearchRepository::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface SearchRepository {

    suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article>
}