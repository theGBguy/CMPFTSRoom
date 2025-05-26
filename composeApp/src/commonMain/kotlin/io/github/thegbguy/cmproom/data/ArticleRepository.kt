package io.github.thegbguy.cmproom.data

import kotlinx.coroutines.flow.Flow

class ArticleRepository(private val database: AppDatabase) {
    private val articleDao = database.articleDao()

    fun getAllArticles(): Flow<List<Article>> = articleDao.getAllArticles()

    fun searchArticles(query: String): Flow<List<Article>> {
        return if (query.isBlank()) {
            getAllArticles()
        } else {
//            articleDao.searchArticles(query)
            articleDao.searchArticlesWithFts(query)
        }
    }

    suspend fun insertArticle(article: Article) {
        articleDao.insertArticle(article)
    }

    suspend fun insertSampleArticles() {
        val sampleArticles = listOf(
            Article(
                title = "Introduction to Kotlin Multiplatform",
                content = "Kotlin Multiplatform allows you to share code between Android, iOS, and other platforms. It's a powerful technology that can save development time and ensure consistency across platforms.",
                author = "John Developer",
                publishDate = "2024-01-15"
            ),
            Article(
                title = "Room Database with FTS",
                content = "Full Text Search (FTS) in Room database enables powerful search capabilities. You can search through text content efficiently using SQL queries and get relevant results quickly.",
                author = "Jane Database",
                publishDate = "2024-01-20"
            ),
            Article(
                title = "Compose Multiplatform UI",
                content = "Compose Multiplatform brings the declarative UI toolkit to multiple platforms. You can build beautiful user interfaces that work across Android, iOS, desktop, and web.",
                author = "UI Expert",
                publishDate = "2024-01-25"
            ),
            Article(
                title = "Mobile Development Best Practices",
                content = "When developing mobile applications, it's important to follow best practices for performance, user experience, and maintainability. This includes proper state management and efficient data handling.",
                author = "Mobile Guru",
                publishDate = "2024-01-30"
            ),
            Article(
                title = "Search Implementation Guide",
                content = "Implementing search functionality requires careful consideration of user experience, performance, and relevance. FTS provides an excellent foundation for building robust search features.",
                author = "Search Specialist",
                publishDate = "2024-02-05"
            )
        )
        articleDao.insertArticles(sampleArticles)
    }

    suspend fun clearAllArticles() {
        articleDao.deleteAllArticles()
    }
}