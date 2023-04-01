package com.indisparte.common_utils


private val TAG = Activities::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
sealed class Activities {
    object NewsActivity : Activities()
    object SearchActivity : Activities()
}