package com.indisparte.common

sealed class Results<T> {
    object Loading : Results<Nothing>()
    data class Success<T>(val data: T?) : Results<T>()
    data class Error<T>(val message: String, val data: T? = null) : Results<T>()
}