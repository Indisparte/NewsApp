package com.indisparte.database.module

import com.indisparte.database.AppDatabase
import com.indisparte.database.dao.NewsDAO

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesNewsDao(
        database: AppDatabase,
    ): NewsDAO = database.getNewsDao()
}