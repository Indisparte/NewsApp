package com.indisparte.news.di

import com.indisparte.news.repository.NewsRepository
import com.indisparte.news.use_case.GetNewsArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@InstallIn(SingletonComponent::class)
@Module
object NewsDomainModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsArticleUseCase {
        return GetNewsArticleUseCase(newsRepository)
    }
}