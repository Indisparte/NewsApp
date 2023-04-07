package com.indisparte.data.repository

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface SearchRepository {
    suspend fun getSearchArticles(map: MutableMap<String, String>): List<ArticleSearchResource>

}