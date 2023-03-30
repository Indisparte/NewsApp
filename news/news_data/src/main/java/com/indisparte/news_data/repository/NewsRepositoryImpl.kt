package com.indisparte.news_data.repository

import com.indisparte.news_data.mapper.toDomainArticle
import com.indisparte.news_data.network.NewsApiService
import com.indisparte.news_domain.model.Article
import com.indisparte.news_domain.repository.NewsRepository


private val TAG = NewsRepositoryImpl::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class NewsRepositoryImpl(private val newsApiService: NewsApiService) : NewsRepository {

    override suspend fun getNewsArticle(): List<Article> {
        return newsApiService.getNewsArticles("us").articles.map { it.toDomainArticle() }
    }

}