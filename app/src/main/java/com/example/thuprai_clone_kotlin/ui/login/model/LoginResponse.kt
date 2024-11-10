package com.example.thuprai_clone_kotlin.ui.login.model

data class LoginResponse(
    val token: String,
    val user: User
)

data class User(
    val id: Int,
    val email: String,
    val username: String
)
