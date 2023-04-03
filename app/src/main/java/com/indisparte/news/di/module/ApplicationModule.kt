package com.indisparte.news.di.module

import android.content.Context
import com.indisparte.common_utils.Navigator
import com.indisparte.news.DefaultNavigator
import com.indisparte.news.application.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@InstallIn(SingletonComponent::class)
@Module
object ApplicationModule {

    @Provides
    @Singleton
    fun provideProvider(): Navigator.Provider {
        return DefaultNavigator()
    }

    @Provides
    @Singleton
    fun provideApplicationContext(app: BaseApplication): Context {
        return app.applicationContext
    }


}