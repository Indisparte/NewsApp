package com.indisparte.network

import com.indisparte.network.model.NetworkArticleResource

/**
 * Interface representing network calls to the News backend
 */
interface NewsDataSource {

    suspend fun getNewsArticles(
        country: String,
        category: String
    ): List<NetworkArticleResource>

    suspend fun getSearchArticles(map: Map<String, String>): List<NetworkArticleResource>
}