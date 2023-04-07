package com.indisparte.database.model

@Entity(
    tableName = "article"
)
data class ArticleEntity(
    val author: String,
    val content: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val title: String,
    @ColumnInfo(name = "url_to_image")
    val urlToImage: String
)

fun ArticleEntity.asExternalModel() = ArticleResource(
    author = author,
    content = content,
    description = description,
    title = title,
    urlToImage = urlToImage
)