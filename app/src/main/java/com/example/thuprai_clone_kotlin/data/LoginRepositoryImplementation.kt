package ui.login.repository


import com.example.thuprai_clone_kotlin.RetrofitClient
import com.example.thuprai_clone_kotlin.data.model.LoginRequest
import com.example.thuprai_clone_kotlin.data.model.LoginResponse


class LoginRepositoryImplementation : LoginRepository {
    private val apiService = RetrofitClient(

    ).apiService
    override suspend fun login(username: String, password: String): LoginResponse? {
        val loginRequest = LoginRequest(username, password)
        val response = apiService.login(loginRequest)
        return response.body()
    }
}