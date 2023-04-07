package com.indisparte.database.dao

import com.indisparte.database.model.ArticleEntity

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<ArticleEntity>)

    @Query("SELECT * FROM ARTICLE")
    suspend fun getNewsArticle(): List<ArticleEntity>
}