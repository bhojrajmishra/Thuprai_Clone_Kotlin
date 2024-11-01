package ui.login.repository

import com.example.thuprai_clone_kotlin.data.Result
import com.example.thuprai_clone_kotlin.data.model.LoginRequest
import com.example.thuprai_clone_kotlin.data.model.LoginResponse
import retrofit2.Response


interface LoginRepository {
    suspend fun login(username: String, password: String): Result<LoginResponse>

}