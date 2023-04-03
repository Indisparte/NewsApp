package com.indisparte.news.network

import com.indisparte.news.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface SearchApi {
    @GET("everything")
    suspend fun getSearchArticles(
        @QueryMap map: MutableMap<String, String>
    ): NewsResponse
}