package com.example.pagger3_implementation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagger3_implementation.Repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(quotesRepository: QuotesRepository): ViewModel(){
    val list = quotesRepository.getQuotes().cachedIn(viewModelScope)
}