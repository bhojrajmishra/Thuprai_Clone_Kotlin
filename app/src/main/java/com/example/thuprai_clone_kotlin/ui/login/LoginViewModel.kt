package com.example.thuprai_clone_kotlin.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ui.login.repository.LoginRepositoryImplementation

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult


    private val loginRepository = LoginRepositoryImplementation()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = loginRepository.login(username, password)
            if (response != null) {
                _loginResult.value = LoginResult(success = response)
            }
        }
    }
}
