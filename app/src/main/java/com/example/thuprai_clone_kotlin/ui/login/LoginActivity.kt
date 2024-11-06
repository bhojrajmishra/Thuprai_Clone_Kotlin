package com.example.thuprai_clone_kotlin.ui.login

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.thuprai_clone_kotlin.R


class LoginActivity : AppCompatActivity() {

    // Declaring view variables
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var googleSignInButton: Button
    private lateinit var facebookSignInButton: Button
    private lateinit var forgotPasswordButton: TextView
    private lateinit var signUpButton: TextView
    private lateinit var togglePasswordVisibility: ImageButton

    private var isPasswordVisible = false

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
            navigateToSignUp()
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
        // Implement your login logic here
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        // Call your login API or authentication method
    }




    private fun navigateToForgotPassword() {
        // Navigate to forgot password screen

    }

    private fun navigateToSignUp() {
        // Navigate to sign up screen
    }
}