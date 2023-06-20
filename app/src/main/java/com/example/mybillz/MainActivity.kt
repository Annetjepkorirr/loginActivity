package com.example.mybillz

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mybillz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.ivImage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            clearErrors()
            validateSignUp()
        }
    }

    fun validateSignUp() {
        val firstName = binding.etfirstName.text.toString()
        val lastName = binding.etlastName.text.toString()
        val email = binding.etemail.text.toString()
        val password = binding.etpassword.text.toString()
        val confirmation = binding.etconfirmpassword.text.toString()
        var error = false

        if (firstName.isBlank()) {
            binding.tilfirstName.error = "First name is required"
            error = true
        }
        if (lastName.isBlank()) {
            binding.tillastName.error = "Last name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilemail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilpassword.error = "Password is required"
            error = true
        }
        if (confirmation.isBlank()) {
            binding.tilconfirmPassword.error = "You need to confirm your password"
            error = true
        }
        if (password != confirmation) {
            binding.tilconfirmPassword.error = "Password and confirmation do not match"
            error = true
        }
        if (!error) {
            Toast.makeText(
                this,
                " Hello $firstName registration was successful ",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun clearErrors() {
        binding.tilfirstName.error = null
        binding.tillastName.error = null
        binding.tilemail.error = null
        binding.tilpassword.error = null
        binding.tilconfirmPassword.error = null
    }
}























