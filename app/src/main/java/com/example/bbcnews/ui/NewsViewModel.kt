package com.example.bbcnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bbcnews.model.News
import com.example.bbcnews.repository.NewsRepository

class NewsViewModel : ViewModel() {

    private val newsRepository: NewsRepository

    val allheadline: LiveData<List<News>>

        get() = newsRepository.getMutableLiveData()

    init {
        newsRepository = NewsRepository()
    }
}