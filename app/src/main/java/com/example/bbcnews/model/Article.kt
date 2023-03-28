package com.example.bbcnews.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Article(@Expose
                   @SerializedName("author")
                   val author: String,
                   @Expose
                   @SerializedName("content")
                   val content: String,
                   @Expose
                   @SerializedName("description")
                   val description: String,
                   @Expose
                   @SerializedName("publishedAt")
                   val publishedAt: String,
                   @Expose
                   @SerializedName("source")
                   val source: Source,
                   @Expose
                   @SerializedName("title")
                   val title: String,
                   @Expose
                   @SerializedName("url")
                   val url: String,
                   @Expose
                   @SerializedName("urlToImage")
                   val urlToImage: String)
