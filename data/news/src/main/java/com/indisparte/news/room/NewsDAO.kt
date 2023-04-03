package com.indisparte.news.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.indisparte.news.model.Article


/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<Article>)

    @Query("SELECT * FROM ARTICLE")
    suspend fun getNewsArticle(): List<Article>
}