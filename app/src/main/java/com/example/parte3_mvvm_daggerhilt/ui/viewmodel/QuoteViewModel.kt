package com.example.parte3_mvvm_daggerhilt.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parte3_mvvm_daggerhilt.data.model.QuoteModel
import com.example.parte3_mvvm_daggerhilt.domain.GetQuotesInteractor
import com.example.parte3_mvvm_daggerhilt.domain.GetRandomQuotesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesInteractor: GetQuotesInteractor,
    private val getRandomQuotesInteractor: GetRandomQuotesInteractor
    ): ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesInteractor()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuotesInteractor()
        if(quote != null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }
}