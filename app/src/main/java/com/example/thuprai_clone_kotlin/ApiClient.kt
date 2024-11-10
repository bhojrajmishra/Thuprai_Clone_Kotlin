package com.example.thuprai_clone_kotlin

import CustomInterceptor
import SecureStorageService
import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://tbe.thuprai.com/"

    fun create(context: Context): ApiService {
        // Create the interceptor with secure storage
        val interceptor = CustomInterceptor(SecureStorageService(context))

        // Build OkHttp client with interceptor
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        // Build Retrofit with the client
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}
