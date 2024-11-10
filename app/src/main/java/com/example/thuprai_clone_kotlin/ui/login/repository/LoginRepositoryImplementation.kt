package com.example.thuprai_clone_kotlin.ui.login.repository


import com.example.thuprai_clone_kotlin.ApiService
import com.example.thuprai_clone_kotlin.RetrofitClient
import com.example.thuprai_clone_kotlin.ui.login.model.LoginRequest
import com.example.thuprai_clone_kotlin.ui.login.model.LoginResponse
import retrofit2.Response


class LoginRepositoryImplementation(private val apiService: ApiService) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return apiService.login(loginRequest)
    }
}