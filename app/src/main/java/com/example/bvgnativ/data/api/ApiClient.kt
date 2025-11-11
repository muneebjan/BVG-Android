package com.example.bvgnativ.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val retrofit: BvgApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://v6.bvg.transport.rest/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BvgApiService::class.java)
    }
}
