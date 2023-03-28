package com.example.bbcnews.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.bbcnews.model.News
import com.example.bbcnews.network.RetrofitInstance
import com.example.bbcnews.utils.Keys
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val newsModelList=ArrayList<News>()
    private val mutableLiveData = MutableLiveData<List<News>>()


    fun getMutableLiveData(): MutableLiveData<List<News>> {
        val newsDataService = RetrofitInstance.service1

        val call = newsDataService.getAllNEws("","us","", Keys.API)
//        val call = newsDataService.getAllNEws()
        println(Keys.API)
        call.enqueue(object : Callback<News> {

            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<News>, response: Response<News>) {
                // val gson = GsonBuilder().create()
                if (response.isSuccessful) {
                    val  newsq : News  = response.body()!!
                    //ticle =response.body()
                    // headlineModelList.add(response.body)
                    // mutableLiveData.postValue(response.body())

                    for(news1 in newsq.articles){
                        newsModelList.add(newsq)
                    }
                    //newsModelList.add(newsq)
                    mutableLiveData.postValue(newsModelList)

                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return mutableLiveData
    }
    companion object {

        private val TAG = "DeveloperRepository"
    }
}