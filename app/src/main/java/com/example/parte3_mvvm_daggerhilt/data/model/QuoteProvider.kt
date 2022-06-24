package com.example.parte3_mvvm_daggerhilt.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor(){
    var quotes:List<QuoteModel> = emptyList()
   /* companion object{
        var quotes:List<QuoteModel> = emptyList()
    }*/
}
