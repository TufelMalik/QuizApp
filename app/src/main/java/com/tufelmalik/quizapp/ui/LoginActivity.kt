package com.tufelmalik.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tufelmalik.quizapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
        private lateinit var binding : ActivityLoginBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.btnLogin.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegistationActivity::class.java))
            }


            binding.btnLogin.setOnClickListener {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }

            binding.txtGotoReg.setOnClickListener{
                startActivity(Intent(this@LoginActivity, RegistationActivity::class.java))
            }



    }
}