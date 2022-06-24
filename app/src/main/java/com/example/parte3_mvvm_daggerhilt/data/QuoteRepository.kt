package com.example.parte3_mvvm_daggerhilt.data

import com.example.parte3_mvvm_daggerhilt.data.model.QuoteModel
import com.example.parte3_mvvm_daggerhilt.data.model.QuoteProvider
import com.example.parte3_mvvm_daggerhilt.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService,
                                          private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        //QuoteProvider.quotes = response
        return response
    }
}