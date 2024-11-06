package com.example.thuprai_clone_kotlin

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient () {
    private  val BASE_URL = "https://tbe.thuprai.com/v1/"
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(CustomInterceptor(
        ))
        .build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService: ApiService = retrofit.create(ApiService::class.java)
}