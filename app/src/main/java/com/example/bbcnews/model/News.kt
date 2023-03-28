package com.example.bbcnews.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class News(@Expose
                @SerializedName("articles")
                val articles: List<Article>,
                @Expose
                @SerializedName("status")
                val status: String,
                @Expose
                @SerializedName("totalResults")
                val totalResults: Int)
