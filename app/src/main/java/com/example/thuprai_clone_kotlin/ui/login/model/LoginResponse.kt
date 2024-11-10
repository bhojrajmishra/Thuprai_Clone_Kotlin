package com.example.thuprai_clone_kotlin.ui.login.model

data class LoginResponse(
val fullName: String,
val email: String,
val id: Long,
val token: String,
val isStaff: Boolean,
val roles: List<Any?>,
val organizations: Organizations
)

class Organizations

