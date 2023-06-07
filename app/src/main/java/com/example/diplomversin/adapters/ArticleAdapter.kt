package com.example.diplomversin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diplomversin.R
import com.example.diplomversin.dataClass.Article

class ArticleAdapter(private val articleList: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_article, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = articleList[position]
        holder.titleTextView.text = currentItem.title
        holder.contentTextView.text = currentItem.content
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.article_title_text_view)
        val contentTextView: TextView = itemView.findViewById(R.id.article_content_text_view)
    }
}
