package com.example.diplomversin.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diplomversin.ArticleData
import com.example.diplomversin.CipherData
import com.example.diplomversin.R
import com.example.diplomversin.second_fragments.ArticleActivity


class ArticlesAdapter(private val dataList1: ArrayList<ArticleData>, private val onItemClickListener: ((ArticleData) -> Unit)?) : RecyclerView.Adapter<ArticlesAdapter.ViewHolderClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout2, parent, false)
        return ViewHolderClass(itemView)
    }



    override fun getItemCount(): Int {
        return dataList1.size
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView){
        val rvTitle: TextView = itemView.findViewById(R.id.title2)
    }

    override fun onBindViewHolder(holder:  ArticlesAdapter.ViewHolderClass, position: Int) {
        val currentItem = dataList1[position]
        holder.rvTitle.text = currentItem.dataTitle1

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ArticleActivity::class.java)
            intent.putExtra("title", currentItem.dataTitle1)
            context.startActivity(intent)
        }

    }
}
