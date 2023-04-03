package com.indisparte.news.di

import com.indisparte.news.network.NewsApiService
import com.indisparte.news.network.SearchApi
import com.indisparte.news.repository.NewsRepository
import com.indisparte.news.repository.NewsRepositoryImpl
import com.indisparte.news.repository.SearchRepository
import com.indisparte.news.repository.SearchRepositoryImpl
import com.indisparte.news.room.NewsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@InstallIn(SingletonComponent::class)
@Module
object NewsDataModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    fun provideNewsRepository(newsApiService: NewsApiService, newsDAO: NewsDAO): NewsRepository {
        return NewsRepositoryImpl(newsApiService, newsDAO)
    }

    @Provides
    fun providesSearchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    @Provides
    fun provideSearchRepository(searchApi: SearchApi): SearchRepository {
        return SearchRepositoryImpl(searchApi)
    }


}