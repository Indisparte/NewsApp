package com.indisparte.news_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indisparte.common_utils.Activities
import com.indisparte.common_utils.Navigator
import com.indisparte.news_presentation.databinding.ActivityNewsBinding


/**
 *@author Antonio Di Nuzzo (Indisparte)
 */
class NewsActivity : AppCompatActivity() {

    companion object{
        fun launchActivity(activity: Activity){
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private var _binding: ActivityNewsBinding? = null
    private val binding: ActivityNewsBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

object GoToNewsActivity: Navigator {
    override fun navigate(activity: Activity) {
        NewsActivity.launchActivity(activity)
    }

}