package com.indisparte.common_utils

import android.app.Activity

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
interface Navigator {
    fun navigate(activity: Activity)

    interface Provider {
        fun getActivities(activities: Activities): Navigator
    }
}