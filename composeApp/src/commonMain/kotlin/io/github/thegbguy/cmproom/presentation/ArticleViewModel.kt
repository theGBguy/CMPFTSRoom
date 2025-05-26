package io.github.thegbguy.cmproom.presentation

import io.github.thegbguy.cmproom.data.Article
import io.github.thegbguy.cmproom.data.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val repository: ArticleRepository,
    private val viewModelScope: CoroutineScope
) {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        initializeData()
        observeArticles()
    }

    private fun initializeData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.insertSampleArticles()
            } catch (e: Exception) {
                // Articles might already exist, which is fine
            }
            _isLoading.value = false
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeArticles() {
        viewModelScope.launch {
            searchQuery
                .flatMapLatest { query ->
                    repository.searchArticles(query)
                }
                .collect { articleList ->
                    _articles.value = articleList
                }
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun addSampleData() {
        viewModelScope.launch {
            repository.insertSampleArticles()
        }
    }

    fun clearAllData() {
        viewModelScope.launch {
            repository.clearAllArticles()
        }
    }
}
