package com.indisparte.news.repository

import com.indisparte.news.model.Article

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface SearchRepository {
    suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article>

}