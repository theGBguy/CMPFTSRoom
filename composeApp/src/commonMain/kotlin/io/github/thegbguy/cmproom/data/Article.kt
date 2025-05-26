package io.github.thegbguy.cmproom.data

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val author: String,
    val publishDate: String
)

@Fts4(contentEntity = Article::class)
@Entity(tableName = "articleFts")
data class ArticleFts(
    val content: String
)
