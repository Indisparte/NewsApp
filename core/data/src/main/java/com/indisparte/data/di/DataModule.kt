package com.indisparte.data.di

import com.indisparte.data.repository.NewsRepository
import com.indisparte.data.repository.NewsRepositoryImpl
import com.indisparte.data.repository.NewsSearchRepositoryImpl

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindsNewsRepository(
        newsRepository: NewsRepositoryImpl
    ): NewsRepository

    @Binds
    fun bindsSearchNewsRepository(
        newsRepository: NewsSearchRepositoryImpl
    ): NewsRepository
}