package com.indisparte.common_utils

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
sealed class Resources<T> {
    class Loading<T>() : Resources<T>()
    class Success<T>(val data: T?) : Resources<T>()
    class Error<T>(val message: String, val data: T?=null) : Resources<T>()

}
