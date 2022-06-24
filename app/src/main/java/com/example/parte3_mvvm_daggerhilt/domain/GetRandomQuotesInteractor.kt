package com.example.parte3_mvvm_daggerhilt.domain

import com.example.parte3_mvvm_daggerhilt.data.QuoteRepository
import com.example.parte3_mvvm_daggerhilt.data.model.QuoteModel
import com.example.parte3_mvvm_daggerhilt.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuotesInteractor @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke() : QuoteModel?{
        val quotes = quoteProvider.quotes
        //val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()  //(0..quotes.size).random()
            return quotes[randomNumber]
        }
        return null
    }
}