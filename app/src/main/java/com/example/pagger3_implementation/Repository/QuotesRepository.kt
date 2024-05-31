package com.example.pagger3_implementation.Repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagger3_implementation.Paging.QuotesPagingSource
import com.example.pagger3_implementation.Retrofit.QuotesApi
import javax.inject.Inject

class QuotesRepository @Inject constructor(val quotesApi: QuotesApi) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {
            QuotesPagingSource(quotesApi)
        }

    ).liveData
}
