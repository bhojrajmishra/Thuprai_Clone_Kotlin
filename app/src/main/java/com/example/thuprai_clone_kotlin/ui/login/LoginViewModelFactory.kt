//package com.example.thuprai_clone_kotlin.ui.login
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.thuprai_clone_kotlin.ApiService
//import com.example.thuprai_clone_kotlin.data.LoginRepositoryImplementation
//import com.example.thuprai_clone_kotlin.data.LoginRepository
//import ui.login.repository.LoginRepository
//
///**
// * ViewModel provider factory to instantiate LoginViewModel.
// * Required given LoginViewModel has a non-empty constructor
// */
//class LoginViewModelFactory : ViewModelProvider.Factory {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            return LoginViewModel(
//                loginRepository = LoginRepositoryImplementation(
//                    apiService = ApiService.create()
//                )
//            ) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}