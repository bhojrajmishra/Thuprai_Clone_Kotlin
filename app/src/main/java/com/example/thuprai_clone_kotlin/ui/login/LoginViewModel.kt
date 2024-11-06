import com.example.thuprai_clone_kotlin.data.model.LoginRequest
import com.example.thuprai_clone_kotlin.data.model.LoginResponse
import ui.login.repository.LoginRepository

// LoginViewModel.kt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ui.login.repository.LoginRepositoryImplementation

class LoginViewModel(
    private val secureStorage: SecureStorageService,
    private val loginRepository: LoginRepositoryImplementation
) : ViewModel() {

    // UI State
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isPasswordVisible = MutableLiveData(false)
    val isPasswordVisible: LiveData<Boolean> = _isPasswordVisible

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    // Function to handle login
    fun login(email: String, password: String) {
        if (!validateInput(email, password)) {
            _errorMessage.value = "Please enter valid data"
            return
        }
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(
                    username = email,
                    password = password
                )

                val response = loginRepository.login(loginRequest)
            } catch (e: Exception) {
                _errorMessage.value = "Login failed: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && password.length >= 6
    }

    private suspend fun handleLoginResponse(
        response: LoginResponse?,
        email: String,
        password: String
    ) {

    }

    private suspend fun saveUserDetails(token: String, email: String, password: String) {
        secureStorage.apply {
            saveData("token", token)
            saveData("email", email)
            saveData("password", password)
            saveData("isLoggedIn", "true")
        }
    }

}
