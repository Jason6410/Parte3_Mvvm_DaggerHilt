package com.example.parte3_mvvm_daggerhilt.data.network

import com.example.parte3_mvvm_daggerhilt.core.RetrofitHelper
import com.example.parte3_mvvm_daggerhilt.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient){
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}