package com.indisparte.news.repository

import com.indisparte.news.mapper.ArticleMapper
import com.indisparte.news.model.Article
import com.indisparte.news.network.SearchApi
import javax.inject.Inject


private val TAG = SearchRepositoryImpl::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class SearchRepositoryImpl
@Inject
constructor(
    private val searchApi: SearchApi
) : SearchRepository {
    override suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article> {
        return searchApi.getSearchArticles(map).articles.map { ArticleMapper().mapToEntity(it) }
    }

}