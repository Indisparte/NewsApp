package com.indisparte.news.navigation

import com.indisparte.common_utils.Activities
import com.indisparte.common_utils.Navigator
import com.indisparte.news_presentation.GoToNewsActivity
import com.indisparte.search_presentation.GoToSearchActivity


private val TAG = DefaultNavigator::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class DefaultNavigator : Navigator.Provider {
    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.NewsActivity -> {GoToNewsActivity}
            Activities.SearchActivity -> {GoToSearchActivity}
        }
    }

}