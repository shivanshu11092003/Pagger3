package com.example.pagger3_implementation.Retrofit

import com.example.pagger3_implementation.Model.Quotes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi  {

    @GET("/quotes")
    fun getQuotes(@Query("page") page:Int) : Quotes

}