package com.example.mybillz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybillz.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume(){
        super.onResume()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            clearErrors()
            validateSignUp()
        }
    }
    fun validateSignUp() {

        val email = binding.etemail.text.toString()
        var error=false
        if (email.isBlank()) {
            binding.tvemail.error = "Email is required"
        }

    }
    fun clearErrors() {
        binding.tvemail.error = null
    }
}

