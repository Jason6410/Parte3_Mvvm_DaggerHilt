package com.example.parte3_mvvm_daggerhilt.domain

import com.example.parte3_mvvm_daggerhilt.data.QuoteRepository
import com.example.parte3_mvvm_daggerhilt.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesInteractor @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke() : List<QuoteModel>?{
        return repository.getAllQuotes()
    }
}