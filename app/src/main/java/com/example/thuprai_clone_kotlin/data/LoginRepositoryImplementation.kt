package ui.login.repository


import com.example.thuprai_clone_kotlin.RetrofitClient
import com.example.thuprai_clone_kotlin.data.model.LoginRequest
import com.example.thuprai_clone_kotlin.data.model.LoginResponse
import retrofit2.Response


class LoginRepositoryImplementation : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return RetrofitClient.apiService.login(loginRequest)
    }
    }