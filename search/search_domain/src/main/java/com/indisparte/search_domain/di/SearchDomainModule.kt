package com.indisparte.search_domain.di

import com.indisparte.search_domain.repository.SearchRepository
import com.indisparte.search_domain.use_case.GetSearchArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@InstallIn(SingletonComponent::class)
@Module
object SearchDomainModule {

    @Provides
    fun provideSearchUseCase(searchRepository: SearchRepository): GetSearchArticleUseCase {
        return GetSearchArticleUseCase(searchRepository)
    }


}