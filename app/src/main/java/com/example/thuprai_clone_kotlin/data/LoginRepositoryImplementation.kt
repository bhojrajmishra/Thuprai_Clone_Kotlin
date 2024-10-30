package com.example.thuprai_clone_kotlin.data

import com.example.thuprai_clone_kotlin.ApiService
import com.example.thuprai_clone_kotlin.data.model.LoginRequest
import com.example.thuprai_clone_kotlin.data.model.LoginResponse
import ui.login.repository.LoginRepository
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginRepositoryImplementation(private val apiService: ApiService) : LoginRepository {

    override suspend fun login(username: String, password: String): Result<LoginResponse> {
        try {
            val response = apiService.login(LoginRequest(username, password))
            if (response.isSuccessful) {
                return Result.Success(response.body()!!)
            }
            return Result.Error(IOException("Error logging in"))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
}