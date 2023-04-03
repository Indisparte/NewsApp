package com.indisparte.news.repository

import com.indisparte.news.model.Article

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface NewsRepository {
    suspend fun getNewsArticle(): List<Article>

}