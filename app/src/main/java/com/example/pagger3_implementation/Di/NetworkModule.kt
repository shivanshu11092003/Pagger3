package com.example.pagger3_implementation.Di

import com.example.pagger3_implementation.Retrofit.QuotesApi
import com.example.pagger3_implementation.utils.Contants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule  {


    @Singleton
    @Provides
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getQuotesApi(retrofit: Retrofit): QuotesApi{
        return retrofit.create(QuotesApi::class.java)

    }
}