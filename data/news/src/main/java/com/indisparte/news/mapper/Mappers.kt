package com.indisparte.news.mapper

import com.indisparte.news.model.Article
import com.indisparte.news.model.ArticleDTO

fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author ?: "",
        content = this.content ?: "",
        description = this.description ?: "",
        title = this.title ?: "",
        urlToImage = this.urlToImage ?: ""
    )
}