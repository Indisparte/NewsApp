package com.indisparte.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indisparte.common_utils.Resources
import com.indisparte.news.use_case.GetNewsArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


private val TAG = NewsViewModel::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@HiltViewModel
class NewsViewModel
@Inject constructor(
    private val getNewsArticleUseCase: GetNewsArticleUseCase
) : ViewModel() {

    private val _newsArticle = MutableStateFlow(NewsState())
    val newsArticle: StateFlow<NewsState> = _newsArticle

    init {
        getNewsArticles()
    }

    private fun getNewsArticles() {
        getNewsArticleUseCase().onEach {
            when (it) {
                is Resources.Loading -> {
                    _newsArticle.value = NewsState(true)
                }
                is Resources.Error -> {
                    _newsArticle.value = NewsState(error = it.message)
                }
                is Resources.Success -> {
                    _newsArticle.value = NewsState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}