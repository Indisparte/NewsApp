package com.indisparte.search_data.repository

import com.indisparte.search_data.mapper.toDomainArticle
import com.indisparte.search_data.network.SearchApi
import com.indisparte.search_domain.model.Article
import com.indisparte.search_domain.repository.SearchRepository


private val TAG = SearchRepositoryImpl::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class SearchRepositoryImpl(private val searchApi: SearchApi) : SearchRepository {
    override suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article> {
        return searchApi.getSearchArticles(map).articles.map { it.toDomainArticle() }
    }

}