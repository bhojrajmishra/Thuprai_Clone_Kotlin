package com.example.thuprai_clone_kotlin.ui.login

import com.example.thuprai_clone_kotlin.data.model.LoginResponse

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoginResponse? = null,
    val error: Int? = null
)