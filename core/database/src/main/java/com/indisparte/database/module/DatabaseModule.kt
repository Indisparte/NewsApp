package com.indisparte.database.module

import com.indisparte.database.AppDatabase

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_db",
    ).build()
}