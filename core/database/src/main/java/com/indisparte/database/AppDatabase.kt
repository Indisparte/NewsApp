package com.indisparte.database

import com.indisparte.database.dao.NewsDAO
import com.indisparte.database.model.ArticleEntity
import javax.naming.Context


/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@Database(entities = [ArticleEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDAO
}