package com.example.bbcnews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bbcnews.databinding.HeadlinesBinding
import com.example.bbcnews.model.News

class HeadlineAdapter() : RecyclerView.Adapter<HeadlineAdapter.ViewHolder>() {
    var headlines= mutableListOf<News>()

    fun setHeadlineList(headlines : List<News>){
        this.headlines = headlines.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding= HeadlinesBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val headline = headlines.get(position).articles
        Glide.with(holder.itemView.context).load(headline.get(position).urlToImage).into(holder.binding.imgHeadlines)
        holder.binding.txtTitleHeading.text = headline.get(position).title
        holder.binding.txtDateHeading.text = headline.get(position).publishedAt
        holder.binding.txtDescription.text = headline.get(position).description
    }

    override fun getItemCount(): Int {
        return headlines.size
    }

    class ViewHolder (val binding: HeadlinesBinding) :
        RecyclerView.ViewHolder(binding.root){

    }
}