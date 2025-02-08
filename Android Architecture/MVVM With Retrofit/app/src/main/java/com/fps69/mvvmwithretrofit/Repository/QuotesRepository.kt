package com.fps69.mvvmwithretrofit.Repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fps69.mvvmwithretrofit.Api.QuoteService
import com.fps69.mvvmwithretrofit.Modle.News
import com.fps69.mvvmwithretrofit.room.NewsDatabase

class QuotesRepository(
    private val quoteService: QuoteService,
    private val newsDatabase: NewsDatabase,
    private val applicationContext: Context
) {


    private val quoteLiveDat = MutableLiveData<News>()

    val quotes: LiveData<News>
        get() = quoteLiveDat

    suspend fun getQuotes(category: String, page: Int) {
        val result = quoteService.getQuotes(category, page)
        if (result?.body() != null) {


            val articles = result.body()!!.articles.map { article ->
                article.copy(
                    author = article.author ?: "Unknown Author",
                    content = article.content ?: "No content",
                    description = article.description ?: "No description",  // Provide default value
                    title = article.title ?: "No title"
                )
            }
            newsDatabase.newsDao().aadNews(articles)
            quoteLiveDat.postValue(result.body())
        }
        else{
            Log.d("abhi", "Emptyyyyyyyyyyyyy")
            Log.d("abhi", "Emptyyyyyyyyyyyyy")
        }
    }
}