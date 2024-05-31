package com.example.pagger3_implementation.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagger3_implementation.Model.Result
import com.example.pagger3_implementation.Retrofit.QuotesApi

class QuotesPagingSource (val quotesApi: QuotesApi) : PagingSource<Int,Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        /** define karega next page konsa load karta hai agar hame kho chuke  hai next page kya tha
         * hamre pass ek anchor positon hoti hai jisse ham pta karenge hamari next position kya hai **/
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }


    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        // in this we write how ro load data
        return try {
            val position = params.key?: 1
            val response = quotesApi.getQuotes(position)
             LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position-1,
                nextKey =  if (position == response.totalPages) null else position+1
            )

        }catch (e : Exception){
            LoadResult.Error(e)
        }


    }
}