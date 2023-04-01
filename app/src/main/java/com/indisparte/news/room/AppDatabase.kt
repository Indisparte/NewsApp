package com.indisparte.news.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indisparte.news_data.room.NewsDAO
import com.indisparte.news_domain.model.Article


private val TAG = AppDatabase::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                .fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getNewsDao(): NewsDAO
}