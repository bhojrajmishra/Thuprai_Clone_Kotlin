package com.example.thuprai_clone_kotlin

import SecureStorageService
import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
class CustomInterceptor () : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newRequest = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(newRequest)
    }
}