package io.github.thegbguy.cmproom.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles ORDER BY id DESC")
    fun getAllArticles(): Flow<List<Article>>

    @Insert
    suspend fun insertArticle(article: Article)

    @Insert
    suspend fun insertArticles(articles: List<Article>)

    @Query(
        """
        SELECT * FROM articles 
        WHERE title LIKE '%' || :searchQuery || '%' 
        OR content LIKE '%' || :searchQuery || '%'
        ORDER BY id DESC
    """
    )
    fun searchArticles(searchQuery: String): Flow<List<Article>>

    @Query("SELECT articles.id, articles.title, snippet(articleFts) as content, articles.author, articles.publishDate FROM articles JOIN articleFts ON articleFts.docid = articles.id WHERE articleFts.content MATCH :searchQuery || '*' ORDER BY articles.id DESC")
    fun searchArticlesWithFts(searchQuery: String): Flow<List<Article>>

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()
}
