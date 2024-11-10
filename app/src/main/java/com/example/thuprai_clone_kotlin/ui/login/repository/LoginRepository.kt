package com.example.thuprai_clone_kotlin.ui.login.repository

import com.example.thuprai_clone_kotlin.ui.login.model.LoginRequest
import com.example.thuprai_clone_kotlin.ui.login.model.LoginResponse
import retrofit2.Response


interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
}