package com.indisparte.data.repository

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface NewsRepository {
    suspend fun getNewsArticle(): List<Article>

}