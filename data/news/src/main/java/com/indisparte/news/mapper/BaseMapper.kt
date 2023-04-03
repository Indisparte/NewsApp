package com.indisparte.news.mapper

import com.indisparte.news.model.Article
import com.indisparte.news.model.ArticleDTO

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <T> the cached model input type
 * @param <T> the remote model input type
 * @param <V> the model return type
 */
interface BaseMapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E
}