package com.indisparte.news.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


private val TAG = BaseApplication::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
@HiltAndroidApp
class BaseApplication:Application() {

}