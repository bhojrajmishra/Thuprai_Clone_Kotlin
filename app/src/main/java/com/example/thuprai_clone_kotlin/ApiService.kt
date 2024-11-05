package com.example.thuprai_clone_kotlin

import com.example.thuprai_clone_kotlin.data.model.LoginRequest
import com.example.thuprai_clone_kotlin.data.model.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("login/")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

}