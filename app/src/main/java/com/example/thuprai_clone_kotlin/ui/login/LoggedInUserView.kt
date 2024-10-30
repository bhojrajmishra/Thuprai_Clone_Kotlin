package com.example.thuprai_clone_kotlin.ui.login

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    val displayName: String,
    val token: String,
    val fullName: String,
    val email: String,
    //... other data fields that may be accessible to the UI
)