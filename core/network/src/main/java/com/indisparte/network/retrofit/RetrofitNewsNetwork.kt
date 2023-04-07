package com.indisparte.network.retrofit

import Retrofit
import com.indisparte.network.NewsDataSource
import com.indisparte.network.model.NetworkArticleResource

/**
 * Retrofit API declaration for News API
 *
 * @author Antonio Di Nuzzo (Indisparte)
 */
private interface RetrofitNewsNetworkApi {

    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String = "us",
        @Query("category") category: String = "business",
    ): NetworkResponse<NetworkArticleResource>


    @GET("everything")
    suspend fun getSearchArticles(
        @QueryMap map: MutableMap<String, String>
    ): NetworkResponse<NetworkArticleResource>

}

/**
 * Wrapper for data provided from the [API_URL]
 */
@Serializable
private data class NetworkResponse<T>(
    val articles: List<T>,
    val status: String,
    val totalResults: Int
)

private const val API_URL = BuildConfig.BACKEND_URL

/**
 * [Retrofit] backend [NewsDataSource]
 */
@Singleton
class RetrofitNewsNetwork
@Inject
constructor(
    okhttpCallFactory: Call.Factory,
) : NewsDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(API_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitNewsNetworkApi::class.java)

    override suspend fun getNewsArticles(
        country: String,
        category: String
    ): List<NetworkArticleResource> =
        networkApi.getNewsArticles(country, category).articles

    override suspend fun getSearchArticles(map: Map<String, String>): List<NetworkArticleResource> =
        networkApi.getSearchArticles(map).articles

}