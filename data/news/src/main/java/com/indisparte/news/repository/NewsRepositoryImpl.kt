package com.indisparte.news.repository

import com.indisparte.news.mapper.toDomainArticle
import com.indisparte.news.model.Article
import com.indisparte.news.network.NewsApiService
import com.indisparte.news.room.NewsDAO


private val TAG = NewsRepositoryImpl::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class NewsRepositoryImpl(private val newsApiService: NewsApiService, private val newsDAO: NewsDAO) :
    NewsRepository {

    override suspend fun getNewsArticle(): List<Article> {
        return try {
            val temp = newsApiService.getNewsArticles("us").articles.map { it.toDomainArticle() }
            newsDAO.insertList(temp)
            newsDAO.getNewsArticle()

        } catch (e: Exception) {
            newsDAO.getNewsArticle()
        }
    }

}