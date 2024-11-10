package com.example.thuprai_clone_kotlin.ui.login

import com.example.thuprai_clone_kotlin.ui.login.model.LoginResponse

class LoginResult(success: LoginResponse) {
    var success: LoggedInUserView? = null
    var error: Int? = null
}
