package com.example.bbcnews.network

import com.example.bbcnews.service.AllNEws
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BASE_URL ="https://newsapi.org/v2/"
    private var retrofit: Retrofit? = null

//    val service: US_Headlines
//        get() {
//            if (retrofit == null){
//                retrofit= Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//
//            return retrofit!!.create<US_Headlines>(US_Headlines::class.java!!)
//        }

    val service1: AllNEws
        get() {
            if (retrofit == null){
                retrofit= Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create<AllNEws>(AllNEws::class.java!!)
        }

}