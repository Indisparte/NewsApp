package com.indisparte.news.di.module

import android.content.Context
import com.indisparte.common_utils.Navigator
import com.indisparte.news.navigation.DefaultNavigator
import com.indisparte.news.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    @Singleton
    fun provideProvider(): Navigator.Provider {
        return DefaultNavigator()
    }

    @Singleton
    @Provides
    fun provideNewsDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providesNewsDAO(appDatabase: AppDatabase): NewsDAO {
        return appDatabase.getNewsDao()
    }
}