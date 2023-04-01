package com.indisparte.news_data.network

import com.indisparte.common_utils.Constants
import com.indisparte.news_data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface NewsApiService {

    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String = "us",
        @Query("category") category: String = "business",
        @Query("apikey") apiKey: String = Constants.API_KEY
    ): NewsResponse
}