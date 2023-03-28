package com.example.bbcnews.service

import com.example.bbcnews.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AllNEws {
    @GET("top-headlines?[sources]&[country]&[category ]&[apiKey]")
    fun getAllNEws(@Query("sources") source: String, @Query("country") country:String, @Query("category") category:String, @Query("apiKey") apiKey: String) : Call<News>
}