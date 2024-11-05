//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.thuprai_clone_kotlin.data.LoginRepositoryImplementation
//import com.example.thuprai_clone_kotlin.ui.login.LoginViewModel
//
//class LoginViewModelFactory(
//    private val loginRepository: LoginRepositoryImplementation,
//    private val secureStorageService: SecureStorageService
//) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return LoginViewModel(loginRepository, secureStorageService) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}