package com.indisparte.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import com.google.android.material.datepicker.MaterialDatePicker
import com.indisparte.common_utils.Activities
import com.indisparte.common_utils.Constants
import com.indisparte.common_utils.Navigator
import com.indisparte.search.adapter.SearchNewsAdapter
import com.indisparte.search.databinding.ActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import java.text.SimpleDateFormat
import javax.inject.Inject


/**
 *@author Antonio Di Nuzzo (Indisparte)
 */
@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, SearchActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private var _binding: ActivitySearchBinding? = null
    private val binding: ActivitySearchBinding
        get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var newsAdapter: SearchNewsAdapter
    private lateinit var map: MutableMap<String, String>

    @Inject
    lateinit var provider: Navigator.Provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newsAdapter = SearchNewsAdapter()
        map = mutableMapOf()

        initView()

        setObservable()
    }

    private fun setObservable() {
        lifecycleScope.launchWhenStarted {

            viewModel.searchArticles.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@SearchActivity, it.error, Toast.LENGTH_LONG).show()
                }
                it.data?.let { articles ->
                    binding.progressBar.visibility = View.GONE
                    newsAdapter.items = articles
                }
            }
        }
    }

    private fun initView() {
        binding.recyclerView.adapter = newsAdapter
        //Set query parameter
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                //NOTE set this query into viewModel
                map[Constant.API_KEY] = Constants.API_KEY
                map[Constant.QUERY] = query
                viewModel.getSearchArticle(map)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {

                return false
            }
        })

        binding.toolbar.setNavigationOnClickListener {
            provider.getActivities(Activities.NewsActivity).navigate(this)
        }

        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.select_date -> {
                    val datePicker = MaterialDatePicker.Builder.dateRangePicker().build()
                    datePicker.show(this.supportFragmentManager, "range picker")

                    datePicker.addOnPositiveButtonClickListener {
                        val start = changeDateFormat(it.first)
                        val end = changeDateFormat(it.second)
                        map[Constant.START_DATE] = start
                        map[Constant.END_DATE] = end
                        viewModel.getSearchArticle(map)
                    }
                }
                else -> {
                    throw UnsupportedOperationException()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        return true
    }


    private fun changeDateFormat(long: Long?): String {
        return try {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            simpleDateFormat.format(long)
        } catch (e: Exception) {
            ""
        }
    }
}

object GoToSearchActivity : Navigator {
    override fun navigate(activity: Activity) {
        SearchActivity.launchActivity(activity)
    }

}