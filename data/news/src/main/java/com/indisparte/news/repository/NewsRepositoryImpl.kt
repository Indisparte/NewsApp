package com.indisparte.news.repository

import com.indisparte.news.mapper.ArticleMapper
import com.indisparte.news.model.Article
import com.indisparte.news.network.NewsApiService
import com.indisparte.news.room.NewsDAO
import javax.inject.Inject


private val TAG = NewsRepositoryImpl::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class NewsRepositoryImpl
@Inject
constructor(
    private val newsApiService: NewsApiService,
    private val newsDAO: NewsDAO
) : NewsRepository {

    override suspend fun getNewsArticle(): List<Article> {
        return try {
            val temp = newsApiService.getNewsArticles("us").articles.map { ArticleMapper().mapToEntity(it) }
            newsDAO.insertList(temp)
            newsDAO.getNewsArticle()

        } catch (e: Exception) {
            newsDAO.getNewsArticle()
        }
    }

}