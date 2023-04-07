package com.indisparte.data.repository


/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class NewsSearchRepositoryImpl(private val newsApiService: NewsApiService, private val newsDAO: NewsDAO) :
    SearchRepository {

    override suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article> {
        return searchApi.getSearchArticles(map).articles.map { it.toDomainArticle() }
    }

}