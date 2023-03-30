package com.indisparte.news_domain.use_case

import com.indisparte.common_utils.Resources
import com.indisparte.news_domain.model.Article
import com.indisparte.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


private val TAG = GetNewsArticleUseCase::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class GetNewsArticleUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke(): Flow<Resources<List<Article>>> = flow {
        emit(Resources.Loading())
        try {
            emit(Resources.Success(data = newsRepository.getNewsArticle()))
        } catch (e: Exception) {
            emit(Resources.Error(message = e.message.toString()))
        }

    }
}