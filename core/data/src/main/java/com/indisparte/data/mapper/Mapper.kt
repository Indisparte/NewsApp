package com.indisparte.data.mapper


/**
 * @author Antonio Di Nuzzo (Indisparte)
 */

fun ArticleResource.toDomainArticle(): Article {
    return ArticleResource(
        author = this.author?:"",
        content = this.content?:"",
        description = this.description?:"",
        title = this.title?:"",
        urlToImage = this.urlToImage?:""
    )
}

fun ArticleSearchResource.toDomainArticle(): Article {
    return Article(
        author = this.author ?: "",
        content = this.content ?: "",
        description = this.description ?: "",
        title = this.title ?: "",
        urlToImage = this.urlToImage ?: ""
    )
}