package com.example.thuprai_clone_kotlin.ui.login

import LoginViewModel
import SecureStorageService
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.thuprai_clone_kotlin.R
import com.example.thuprai_clone_kotlin.ui.login.repository.LoginRepositoryImplementation

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    // Declaring view variables
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var googleSignInButton: Button
    private lateinit var facebookSignInButton: Button
    private lateinit var forgotPasswordButton: TextView
    private lateinit var signUpButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Initialize views
        initializeViews()
        // Set up click listeners
        setupClickListeners()
        // Set up input validation
        setupInputValidation()
    }

    private fun initializeViews() {
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        googleSignInButton = findViewById(R.id.googleSignInButton)
        facebookSignInButton = findViewById(R.id.facebookSignInButton)
        forgotPasswordButton = findViewById(R.id.forgotPasswordButton)
        signUpButton = findViewById(R.id.signUpButton)

    }

    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            if (validateInputs()) {
                performLogin()
            }
        }

        forgotPasswordButton.setOnClickListener {
            navigateToForgotPassword()
        }

        signUpButton.setOnClickListener {
//            navigateToSignUp()
        }


    }

    private fun setupInputValidation() {
        emailEditText.addTextChangedListener { text ->
            validateEmail(text.toString())
        }

        passwordEditText.addTextChangedListener { text ->
            validatePassword(text.toString())
        }
    }

    private fun validateInputs(): Boolean {
        val isEmailValid = validateEmail(emailEditText.text.toString())
        val isPasswordValid = validatePassword(passwordEditText.text.toString())
        return isEmailValid && isPasswordValid
    }

    private fun validateEmail(email: String): Boolean {
        return if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = null
            true
        } else {
            emailEditText.error = "Please enter a valid email address"
            false
        }
    }

    private fun validatePassword(password: String): Boolean {
        return if (password.length >= 6) {
            passwordEditText.error = null
            true
        } else {
            passwordEditText.error = "Password must be at least 6 characters"
            false
        }
    }

    private fun performLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val viewModel = LoginViewModel(
            secureStorage = SecureStorageService(this),
            loginRepository = LoginRepositoryImplementation()
        )
     val response = viewModel.login(email, password)
        if (response != null) {
            // Login successful
            // Navigate to home screen
//            navigateToHome()
        } else {
            // Login failed
            // Show error message
        }
    }




    private fun navigateToForgotPassword() {
        // Navigate to forgot password screen


    }

//    private fun navigateToSignUp() {
//        // Navigate to sign up screen
//        intent = Intent(this, SignUpActivity::class.java)
//        startActivity(intent)
//    }

//    private fun navigateToHome() {
//        // Navigate to home screen
//        intent = Intent(this, HomeActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
}