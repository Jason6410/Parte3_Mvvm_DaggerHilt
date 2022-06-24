package com.example.parte3_mvvm_daggerhilt.data.network

import com.example.parte3_mvvm_daggerhilt.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(".json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}