package com.indisparte.news_domain.repository

import com.indisparte.news_domain.model.Article

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface NewsRepository {
    suspend fun getNewsArticle(): List<Article>
}