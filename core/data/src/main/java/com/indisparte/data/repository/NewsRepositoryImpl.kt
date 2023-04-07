package com.indisparte.data.repository


/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class NewsRepositoryImpl(private val newsApiService: NewsApiService, private val newsDAO: NewsDAO) :
    NewsRepository {

    override suspend fun getNewsArticle(): List<ArticleResource> {
        return try {
            val temp = newsApiService.getNewsArticles("us").articles.map { it.toDomainArticle() }
            newsDAO.insertList(temp)
            newsDAO.getNewsArticle()

        } catch (e: Exception) {
            newsDAO.getNewsArticle()
        }
    }



}