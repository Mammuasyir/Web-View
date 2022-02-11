package com.example.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.webview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()

            if (name.isNullOrEmpty()){
                Toast.makeText(this, "name is required !", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email.isNullOrEmpty()){
                Toast.makeText(this, "email is required !", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sessionManager.sessionLogin(name, email)

            val i = Intent(this, MainActivity::class.java)

            startActivity(i)
            finish()

        }
    }
}