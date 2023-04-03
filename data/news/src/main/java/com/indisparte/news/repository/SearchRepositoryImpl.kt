package com.indisparte.news.repository

import com.indisparte.news.mapper.toDomainArticle
import com.indisparte.news.model.Article
import com.indisparte.news.network.SearchApi


private val TAG = SearchRepositoryImpl::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class SearchRepositoryImpl(private val searchApi: SearchApi) : SearchRepository {
    override suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article> {
        return searchApi.getSearchArticles(map).articles.map { it.toDomainArticle() }
    }

}