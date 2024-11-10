import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thuprai_clone_kotlin.ui.login.model.LoginRequest
import com.example.thuprai_clone_kotlin.ui.login.repository.LoginRepositoryImplementation
import kotlinx.coroutines.launch

class LoginViewModel(
    private val secureStorage: SecureStorageService,
    private val loginRepository: LoginRepositoryImplementation
) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    fun login(email: String, password: String) {
        if (!validateInput(email, password)) {
            _errorMessage.value = "Please enter valid credentials"
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

                if (response.isSuccessful) {
                    response.body()?.let { loginResponse ->
                        // Save user details securely
                        saveUserDetails(loginResponse.token ?: "", email, password)
                        _loginSuccess.postValue(true)
                    } ?: run {
                        _errorMessage.postValue("Login response was empty")
                    }
                } else {
                    _errorMessage.postValue("Login failed: ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Login failed: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && password.length >= 6
    }

    private suspend fun saveUserDetails(token: String, email: String, password: String) {
        secureStorage.apply {
            saveData("auth_token", token)
            saveData("email", email)
            saveData("password", password)
            saveData("isLoggedIn", "true")
        }
    }
}