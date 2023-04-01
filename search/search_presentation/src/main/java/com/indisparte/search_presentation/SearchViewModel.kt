package com.indisparte.search_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indisparte.common_utils.Resources
import com.indisparte.search_domain.use_case.GetSearchArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


private val TAG = SearchViewModel::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@HiltViewModel
class SearchViewModel
@Inject
constructor(
    private val getSearchArticleUseCase: GetSearchArticleUseCase
) : ViewModel() {

    private val _searchArticles = MutableStateFlow(SearchState())
    val searchArticles: StateFlow<SearchState> get() = _searchArticles

    fun getSearchArticle(map: MutableMap<String, String>) {
        getSearchArticleUseCase(map).onEach {
            when (it) {
                is Resources.Loading -> {
                    _searchArticles.value = SearchState(isLoading = true)
                }
                is Resources.Error -> {
                    _searchArticles.value = SearchState(error = it.message)
                }
                is Resources.Success -> {
                    _searchArticles.value = SearchState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}