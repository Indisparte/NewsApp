package com.indisparte.news.mapper

import com.indisparte.news.model.Article
import com.indisparte.news.model.ArticleDTO


/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class ArticleMapper : BaseMapper<Article, ArticleDTO> {

    override fun mapFromEntity(type: Article): ArticleDTO {
        return ArticleDTO(
            author = type.author,
            content = type.content,
            description = type.description,
            title = type.title,
            urlToImage = type.urlToImage,
            source = null,
            url = null,
            publishedAt = null
        )
    }

    override fun mapToEntity(type: ArticleDTO): Article {
        return Article(
            author = type.author ?: "",
            content = type.content ?: "",
            description = type.description ?: "",
            title = type.title ?: "",
            urlToImage = type.urlToImage ?: ""
        )
    }

}