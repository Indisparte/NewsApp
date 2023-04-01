package com.indisparte.search_presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.indisparte.search_domain.model.Article
import com.indisparte.search_presentation.databinding.ListItemSearchArticleBinding

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class SearchNewsAdapter : RecyclerView.Adapter<SearchNewsAdapter.SearchNewsViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.content == newItem.content
        }

    }
    private val dataList = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchNewsViewHolder {
        val itemBinding =
            ListItemSearchArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchNewsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SearchNewsViewHolder, position: Int) {
        holder.bind(dataList.currentList[position])
    }

    override fun getItemCount(): Int {
        return dataList.currentList.size
    }

    var items: List<Article>
        get() = dataList.currentList
        set(value) = dataList.submitList(value)

    inner class SearchNewsViewHolder(
        private val binding: ListItemSearchArticleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article) {
            with(binding) {
                root.setOnClickListener {
                    //if the click on this item does not have a global action,
                    //delete this comment and call the method within the fragment or activity
                    /* onItemClickListener?.let {
                         it(item)
                     }*/
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