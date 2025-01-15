package com.fps69.mvvmwithretrofit

import android.app.Application
import com.fps69.mvvmwithretrofit.Api.QuoteService
import com.fps69.mvvmwithretrofit.Api.RetrofitHelper
import com.fps69.mvvmwithretrofit.Repository.QuotesRepository
import com.fps69.mvvmwithretrofit.room.NewsDatabase

class NewsApplication : Application() {


    lateinit var newsRepository : QuotesRepository

    override fun onCreate() {
        super.onCreate()
        initiallize()
    }

    private fun initiallize() {

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)

        val database = NewsDatabase.getDatabase(applicationContext)
         newsRepository = QuotesRepository(quoteService,database, applicationContext)

    }
}