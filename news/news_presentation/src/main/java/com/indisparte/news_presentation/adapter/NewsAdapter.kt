package com.indisparte.news_presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.indisparte.news_domain.model.Article
import com.indisparte.news_presentation.databinding.ListItemArticleBinding

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            TODO("Not implemented yet")
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            TODO("Not implemented yet")
        }

    }
    private val dataList = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemBinding =
            ListItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(dataList.currentList[position])
    }

    override fun getItemCount(): Int {
        return dataList.currentList.size
    }

    var items: List<Article>
        get() = dataList.currentList
        set(value) = dataList.submitList(value)

    inner class NewsViewHolder(
        private val binding: ListItemArticleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article) {
            with(binding) {
                root.setOnClickListener {
                    //if the click on this item does not have a global action,
                    //delete this comment and call the method within the fragment or activity
                    /* onItemClickListener?.let {
                         it(item)
                     }*/
                    TODO("Not implemented yet: general click action")
                }
                article = item
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}